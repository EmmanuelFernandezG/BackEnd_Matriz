package com.back.cd.back.cd.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.cd.back.cd.Modelo.Control_PIs_Modelo;
import com.back.cd.back.cd.Modelo.Repositorio.Control_PIs_Repositorio;

@RestController
@RequestMapping("/seguimiento/planta")
@CrossOrigin(origins = "*")
public class ControlPIs_Controller {
	@Autowired
	private Control_PIs_Repositorio control_PIs_Repositorio;
	
	@PutMapping("/guardar")
	public ResponseEntity<?> guardarOActualizar(@RequestBody Control_PIs_Modelo control_PIs_Modelo) {
        try {
            Control_PIs_Modelo guardado = control_PIs_Repositorio.save(control_PIs_Modelo);
            return ResponseEntity.ok(guardado);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }
	
}
