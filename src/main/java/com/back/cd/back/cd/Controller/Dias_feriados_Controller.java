package com.back.cd.back.cd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.cd.back.cd.Modelo.Dias_feriados_Modelo;
import com.back.cd.back.cd.Modelo.Repositorio.Dias_feriados_Repositorio;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/importaciones/feriados")
public class Dias_feriados_Controller {
	@Autowired
	private Dias_feriados_Repositorio dias_feriados_Repositorio;
	
	@GetMapping("/todos")
	public ResponseEntity<List<Dias_feriados_Modelo>> obtenerTodos() {
        return ResponseEntity.ok(dias_feriados_Repositorio.findAll());
    }
}