package com.back.cd.back.cd.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.cd.back.cd.Exception.ResourceNotFoundException;
import com.back.cd.back.cd.Modelo.Archivos_Folder_Documentos_Modeo;
import com.back.cd.back.cd.Modelo.Folders_carpeta_principal_Modelo;
import com.back.cd.back.cd.Modelo.Matriz_Control_Documental_Modelo;
import com.back.cd.back.cd.Modelo.Soc_Modelo;
import com.back.cd.back.cd.Modelo.Repositorio.Archivos_Documentos_Repositorio;
import com.back.cd.back.cd.Modelo.Repositorio.Folders_carpetas_principal_Repositorio;

@RestController
@CrossOrigin
@RequestMapping("/importaciones/documentos")
public class Archivos_Folder_Controller {

	@Autowired
	public Archivos_Documentos_Repositorio archivos_Documentos_Repositorio;
	
	@Autowired
	public Folders_carpetas_principal_Repositorio folders_carpetas_principal_Repositorio;
	
	@GetMapping("/carpatasini")
	public List<Folders_carpeta_principal_Modelo> consultaCarpetasPrincipal() {
		return folders_carpetas_principal_Repositorio.findAll();
	}

	@GetMapping("/archivos/full")
	public List<Archivos_Folder_Documentos_Modeo>getAllLinks() {
		return archivos_Documentos_Repositorio.findAll();			
	}
	@GetMapping("/archivos/{id_folder}")
		public List<Archivos_Folder_Documentos_Modeo>consultaArchivos(@PathVariable("id_folder") Long id_folder) {
			return archivos_Documentos_Repositorio.GetbyIdFolder(id_folder);
					
		}
	@PostMapping("/archivos/nuevoDoc")
	public Archivos_Folder_Documentos_Modeo crearDocumento(@RequestBody Archivos_Folder_Documentos_Modeo archivos_Folder_Documentos_Modeo) {
		return archivos_Documentos_Repositorio.save(archivos_Folder_Documentos_Modeo);
	}
	
	@PutMapping("/archivos/nuevoDoc/{Id}")
	public ResponseEntity<Archivos_Folder_Documentos_Modeo> actualizarDocumentos(@PathVariable("Id") Long Id, @RequestBody Archivos_Folder_Documentos_Modeo archivos_Folder_Documentos_Modeo){
		Archivos_Folder_Documentos_Modeo archivosok = archivos_Documentos_Repositorio.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Registro No Encontrado : " + Id) );
	 archivosok.setArea(archivos_Folder_Documentos_Modeo.getArea());
	 archivosok.setCapacitador(archivos_Folder_Documentos_Modeo.getCapacitador());
	 archivosok.setDireccion(archivos_Folder_Documentos_Modeo.getDireccion());
	 archivosok.setId(archivos_Folder_Documentos_Modeo.getId());
	 archivosok.setId_carpeta_principal(archivos_Folder_Documentos_Modeo.getId_carpeta_principal());
	 archivosok.setId_folder(archivos_Folder_Documentos_Modeo.getId_folder());
	 archivosok.setLink(archivos_Folder_Documentos_Modeo.getLink());
	 archivosok.setNombre_archivo(archivos_Folder_Documentos_Modeo.getNombre_archivo());
	 archivosok.setOnboarding(archivos_Folder_Documentos_Modeo.getOnboarding());
	 archivosok.setTipo(archivos_Folder_Documentos_Modeo.getTipo());
	 return ResponseEntity.ok(archivos_Documentos_Repositorio.save(archivos_Folder_Documentos_Modeo));

	}
	@DeleteMapping("/archivos/elimin/{Id}")
	public ResponseEntity<Map<String, Boolean>> eliminarDocumento(@PathVariable Long Id){
		Archivos_Folder_Documentos_Modeo archivosok = archivos_Documentos_Repositorio.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Registro No Encontrado : " + Id) );
		archivos_Documentos_Repositorio.delete(archivosok);
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
		
}
