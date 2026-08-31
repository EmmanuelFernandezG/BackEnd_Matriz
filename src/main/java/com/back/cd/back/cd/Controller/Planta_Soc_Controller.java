package com.back.cd.back.cd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.cd.back.cd.Modelo.Matriz_Control_Documental_Modelo;
import com.back.cd.back.cd.Modelo.Planta_Soc_Modelo;
import com.back.cd.back.cd.Modelo.sellos_Modelo;
import com.back.cd.back.cd.Modelo.Repositorio.Planta_soc_Repository;

@RestController
@RequestMapping("/importaciones/planta")
@CrossOrigin
public class Planta_Soc_Controller {

	@Autowired
	private Planta_soc_Repository planta_soc_Repository;
	
	
	@GetMapping("/soc/alldata")	
	public	List<Planta_Soc_Modelo> getallSocPlanta(){
		return planta_soc_Repository.findAll();
	}
	
	@PutMapping("/soc/planta/{Id}")
	public ResponseEntity<Planta_Soc_Modelo> actualizarRegistroPlanta(@PathVariable("Id") Long Id, @RequestBody Planta_Soc_Modelo planta_Soc_Modelo){
	     return ResponseEntity.ok(planta_soc_Repository.save(planta_Soc_Modelo));
	}
}
