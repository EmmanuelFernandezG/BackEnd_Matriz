package com.back.cd.back.cd.Controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.HandlerMapping;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/importaciones/documentos")
public class DocumentosController {

    private static final Path BASE_DIR = Paths.get("\\\\cernotes\\Catalogo Truper\\");

    @GetMapping("/api/archivos")
    public ResponseEntity<List<Map<String, Object>>> listarOrganizado() {
        Map<String, List<Map<String, String>>> agrupado = new HashMap<>();

        try (Stream<Path> paths = Files.walk(BASE_DIR)) {
            paths.filter(Files::isRegularFile).forEach(path -> {
                String relativo = BASE_DIR.relativize(path).toString().replace("\\", "/");
                String nombreArchivo = path.getFileName().toString();
                String carpeta = relativo.contains("/") ? relativo.substring(0, relativo.lastIndexOf("/")) : "Raíz";

                Map<String, String> archivoInfo = new HashMap<>();
                archivoInfo.put("nombre", nombreArchivo);
                archivoInfo.put("relativo", relativo);

                agrupado.computeIfAbsent(carpeta, k -> new ArrayList<>()).add(archivoInfo);
            });
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        List<Map<String, Object>> resultado = agrupado.entrySet().stream()
            .map(entry -> {
                Map<String, Object> carpetaMap = new HashMap<>();
                carpetaMap.put("carpeta", entry.getKey());
                carpetaMap.put("archivos", entry.getValue());
                return carpetaMap;
            })
            .collect(Collectors.toList());

        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/api/archivos/ver/**")
    public ResponseEntity<Resource> verArchivo(HttpServletRequest request) throws IOException {
        String rutaRelativa = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        rutaRelativa = rutaRelativa.replace("/importaciones/documentos/api/archivos/ver/", "");

        Path completo = BASE_DIR.resolve(rutaRelativa).normalize();

        if (!completo.startsWith(BASE_DIR)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        if (!Files.exists(completo)) {
            return ResponseEntity.notFound().build();
        }

        Resource archivo = new UrlResource(completo.toUri());
        String contentType = Files.probeContentType(completo);
        MediaType mediaType = MediaType.APPLICATION_OCTET_STREAM;

        try {
            if (contentType != null) {
                mediaType = MediaType.parseMediaType(contentType);
            }
        } catch (Exception ex) {
            // Mantener el tipo por defecto si hay error
        }

        return ResponseEntity.ok()
                .contentType(mediaType)
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + archivo.getFilename() + "\"")
                .body(archivo);
    }
}
