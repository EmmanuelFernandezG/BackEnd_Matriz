package com.back.cd.back.cd.Controller;

import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.cd.back.cd.Exception.ResourceNotFoundException;
import com.back.cd.back.cd.Modelo.HistorialSOCs_Modelo;
import com.back.cd.back.cd.Modelo.Matriz_Control_Documental_Modelo;
import com.back.cd.back.cd.Modelo.Soc_Modelo;
import com.back.cd.back.cd.Modelo.Repositorio.Historial_Soc_Repositorio;
import com.back.cd.back.cd.Modelo.Repositorio.Soc_Repositorio;

@RestController
@CrossOrigin
@RequestMapping("/importaciones/historialsoc")
public class Historial_Soc_Controlles {

	@Autowired
	
	public Historial_Soc_Repositorio historial_Soc_Repositorio;
	
	@GetMapping("/{orden}")
	public ResponseEntity<List<HistorialSOCs_Modelo>> listarHistporId(@PathVariable("orden") Long nooc) {
	    List<HistorialSOCs_Modelo> resultados = historial_Soc_Repositorio.buscarporOrden(nooc);
	    if (resultados.isEmpty()) {
	        throw new ResourceNotFoundException("No se encontraron registros para la orden: " + nooc);
	    }
	    return ResponseEntity.ok(resultados);
	}
	
	@PostMapping("/generarHistSoc/")
		public HistorialSOCs_Modelo guardarHistorial(@RequestBody HistorialSOCs_Modelo historialSOCs_Modelo) {
			return (historial_Soc_Repositorio.save(historialSOCs_Modelo));
		}
			
}
