package com.back.cd.back.cd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.cd.back.cd.Modelo.Formato_Revisados_Modelo;
import com.back.cd.back.cd.Modelo.Formato_Trial_Modelo;
import com.back.cd.back.cd.Modelo.Matriz_Control_Documental_Modelo;
import com.back.cd.back.cd.Modelo.Repositorio.Formato_Revisados_Repository;

@RestController
@RequestMapping("/importaciones/revisados")
@CrossOrigin
public class Formato_Revisados_Controller {
	@Autowired
	private	Formato_Revisados_Repository formato_Revisados_Repository;
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<Formato_Revisados_Modelo> consultartodo(@PathVariable Long id) {
	    return formato_Revisados_Repository.findById(id)
	            .map(ResponseEntity::ok)
	            .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/guardarrevisado/")
	public Formato_Revisados_Modelo guardarregistro(@RequestBody Formato_Revisados_Modelo revisado) {
		return formato_Revisados_Repository.save(revisado);
	}
	
	@GetMapping("/listar")
    public ResponseEntity<List<Formato_Revisados_Modelo>> listarTodos() {
        List<Formato_Revisados_Modelo> lista = formato_Revisados_Repository.findAll();
        return ResponseEntity.ok(lista);
    }
}
