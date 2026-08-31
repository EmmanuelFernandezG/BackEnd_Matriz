package com.back.cd.back.cd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.cd.back.cd.Modelo.Buffer_Planta_acortado_Modelo;
import com.back.cd.back.cd.Modelo.bufferPlanta_Modelo;
import com.back.cd.back.cd.Modelo.Repositorio.Buffer_Projection_Planta;
import com.back.cd.back.cd.Modelo.Repositorio.bufferPlanta_Repositorio;

import lombok.Getter;

@RestController
@RequestMapping("/importaciones/planta")
@CrossOrigin
public class Buffer_planta_controller {

	@Autowired
	private bufferPlanta_Repositorio bufferPlanta_Repositorio;
	
		@GetMapping("/buffer_planta")
		public List<bufferPlanta_Modelo> get_Buffer_planta(){
			return bufferPlanta_Repositorio.findAll();
		}

		@GetMapping("/buffer_sin_totales")
		public List<Buffer_Projection_Planta> getSinTots(){
			return bufferPlanta_Repositorio.BuscarSinTotales();
		}
}
