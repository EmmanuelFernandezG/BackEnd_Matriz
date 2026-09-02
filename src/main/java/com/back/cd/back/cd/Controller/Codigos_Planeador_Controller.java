package com.back.cd.back.cd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.cd.back.cd.Modelo.Codigos_Planeador_Modelo;
import com.back.cd.back.cd.Modelo.Repositorio.Codigos_Planeador_Repositorio;

@RestController
@CrossOrigin
@RequestMapping("/importaciones/CodigosPlanPlanta")
public class Codigos_Planeador_Controller {
	@Autowired
	private Codigos_Planeador_Repositorio codigos_Planeador_Repositorio;


	@GetMapping("/codigosplaneadorall")
	public List<Codigos_Planeador_Modelo> listarcodigosplaneador(){
		return codigos_Planeador_Repositorio.findAll();
	}

}
