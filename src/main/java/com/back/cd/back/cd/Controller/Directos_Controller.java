package com.back.cd.back.cd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.cd.back.cd.Modelo.directos;
import com.back.cd.back.cd.Modelo.Repositorio.directosRepository;

@RestController
@RequestMapping("/importaciones/controldocumental")
@CrossOrigin(origins = "*")
public class Directos_Controller {
	@Autowired
	private directosRepository directosRepository;
	
	@GetMapping("/directosall/") 
	public List<directos> listarDirectos(){
		return directosRepository.findAll();
	}
}
