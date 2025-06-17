package com.back.cd.back.cd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.cd.back.cd.Exception.ResourceNotFoudException;
import com.back.cd.back.cd.Modelo.Usuarios_Modelo;
import com.back.cd.back.cd.Modelo.Repositorio.Usuarios_Repositorio;


@RestController
@RequestMapping("/importaciones/usuarios")
@CrossOrigin

public class Usuario_controller {

	
	@Autowired
	private Usuarios_Repositorio usuarios_Repositorio;
	

	@GetMapping("/usuarios")
	public List<Usuarios_Modelo> listarUsers(){
		return usuarios_Repositorio.findAll();
	}
	
	@GetMapping("/usuarios/{Id}")
	public ResponseEntity<Usuarios_Modelo>  usuarioPorId(@PathVariable("Id") Long Id){
		Usuarios_Modelo usuarios_Modelo = usuarios_Repositorio.findById(Id)
		.orElseThrow(() -> new ResourceNotFoudException("Usuario No Existe: " + Id));
		return ResponseEntity.ok(usuarios_Modelo);
	}
	
}
