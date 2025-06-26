package com.back.cd.back.cd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.cd.back.cd.Modelo.Matriz_Control_Documental_Modelo;
import com.back.cd.back.cd.Modelo.SocDTO;
import com.back.cd.back.cd.Modelo.Soc_Modelo;
import com.back.cd.back.cd.Modelo.Repositorio.SocProjection;
import com.back.cd.back.cd.Modelo.Repositorio.Soc_Repositorio;

@RestController
@RequestMapping("/importaciones/controldocumental")
@CrossOrigin
public class Soc_Controller {
	@Autowired
	private Soc_Repositorio soc_Repositorio;
	
	@GetMapping("/matrizcd/nuevapo/new/{folio_tt}")
	public List<SocProjection> crearMzRegistro(@PathVariable("folio_tt") Long folio_tt) {
	    return soc_Repositorio.crearMzporfolio(folio_tt);
	}


}
