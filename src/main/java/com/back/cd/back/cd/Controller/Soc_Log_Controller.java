package com.back.cd.back.cd.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.back.cd.back.cd.Modelo.Matriz_Control_Documental_Modelo;
import com.back.cd.back.cd.Modelo.Socs_log_modelo;
import com.back.cd.back.cd.Modelo.Repositorio.Soc_Repositorio;
import com.back.cd.back.cd.Modelo.Repositorio.SocProjection;

@RestController
@RequestMapping("/importaciones/controldocumental")
@CrossOrigin

public class Soc_Log_Controller {
		@Autowired
	    private Soc_Repositorio socsRepository;
		@Autowired
		private com.back.cd.back.cd.Modelo.Repositorio.Socs_log_repositorio socs_log_repositorio;
		
		@GetMapping("/socs")
//		public List<socsProjection> verTabla() {
//		    return Service.getTablaSocs();
//		}
		public List<SocProjection> getTabla(@RequestParam("usuario") String usuario) {
		    if ("prueba".equalsIgnoreCase(usuario)) {
		        return socsRepository.obtenerDataTabla(usuario);
		    }
		    return socsRepository.obtenerDataTabla(usuario);
	    }
		
		@PostMapping("/new_log")
		public Socs_log_modelo guardarregistro(@RequestBody Socs_log_modelo socs_log_modelo) {
			return socs_log_repositorio.save(socs_log_modelo);
		}

		@PostMapping("/refreshbases")
		 public ResponseEntity<String> actualizar() {
	        socs_log_repositorio.actualizarBase();
	        return ResponseEntity.ok("Actualización ejecutada correctamente");
	    }
		
		@GetMapping("/log-all")
		public List<Socs_log_modelo> obtenerTodosLosLogs() {
		    return socs_log_repositorio.findAll();
		}
		
		@PutMapping("/guardar")
		public ResponseEntity<?> guardarOActualizar(@RequestBody Socs_log_modelo socs_log_modelo) {
	        try {
	            Socs_log_modelo guardado = socs_log_repositorio.save(socs_log_modelo);
	            return ResponseEntity.ok(guardado);
	        } catch (Exception e) {
	            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
	        }
	    }
		
	}