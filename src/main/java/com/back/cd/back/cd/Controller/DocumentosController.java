package com.back.cd.back.cd.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.HandlerMapping;

import com.back.cd.back.cd.Modelo.Historial_Matriz_CD;
import com.back.cd.back.cd.Exception.ResourceNotFoundException;
import com.back.cd.back.cd.Modelo.Archivos_Folder_Documentos_Modeo;
import com.back.cd.back.cd.Modelo.Folders_documentos_Modelo;
import com.back.cd.back.cd.Modelo.Repositorio.DocumentosSesionesJoin;
import com.back.cd.back.cd.Modelo.Repositorio.Folders_carpetas_principal_Repositorio;
import com.back.cd.back.cd.Modelo.Repositorio.documentos_Repositorio;
import com.back.cd.back.cd.Modelo.Repositorio.historial_MatrizCD_Repositorio;

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
	@Autowired
	public documentos_Repositorio docs_repositorio;

	@Autowired
	public Folders_carpetas_principal_Repositorio folders_carpetas_principal_Repositorio;
	
	
	@GetMapping("/folders")
		public List<DocumentosSesionesJoin> consultaFolders() {
			return docs_repositorio.getSesiones();
		}
	
	@PutMapping("/fechaydur/{Id}")
	public ResponseEntity<Folders_documentos_Modelo> actualizardatos(@PathVariable("Id") Long Id, @RequestBody Folders_documentos_Modelo folders_documentos_Modelo){
		Folders_documentos_Modelo foldok = docs_repositorio.findById(Id)
		.orElseThrow(() -> new ResourceNotFoundException("Registro No Encontrado : " + Id) );
		foldok.setDuracion(folders_documentos_Modelo.getDuracion());
		foldok.setFecha_sesion(folders_documentos_Modelo.getFecha_sesion());
		return ResponseEntity.ok(docs_repositorio.save(folders_documentos_Modelo));
	}

}
