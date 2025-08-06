package com.back.cd.back.cd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.cd.back.cd.Modelo.Historial_Matriz_CD;
import com.back.cd.back.cd.Modelo.Matriz_Control_Documental_Modelo;
import com.back.cd.back.cd.Modelo.Repositorio.SocProjection;
import com.back.cd.back.cd.Modelo.Repositorio.historial_MatrizCD_Repositorio;

@RestController
@CrossOrigin
@RequestMapping("/importaciones/controldocumental/historial")
public class Historial_MatrizCD_Controller {
	
	@Autowired
	public historial_MatrizCD_Repositorio historial_MatrizCD_Repositorio;
	
	@PostMapping("/nhist")
	public Historial_Matriz_CD guardahistorial(@RequestBody Historial_Matriz_CD historial_Matriz_CD) {
		return historial_MatrizCD_Repositorio.save(historial_Matriz_CD);
	}
	
	@GetMapping("/nhist/{folio_tt}")
	public List<Historial_Matriz_CD> consultaHistorial(@PathVariable("folio_tt") Long folio_tt) {
		return historial_MatrizCD_Repositorio.consutaHist(folio_tt);
	}
}
