package com.back.cd.back.cd.Controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.cd.back.cd.Modelo.Registro_Usuarios_Sesiones_Modelo;
import com.back.cd.back.cd.Modelo.Repositorio.Registro_Usuarios_Sesiones_Repositorio;

@RestController
@CrossOrigin
@RequestMapping("/importaciones/registrousers")
public class Registro_Usuarios_Sesiones_Controller {
	@Autowired
	private Registro_Usuarios_Sesiones_Repositorio registro_Usuarios_Sesiones_Repositorio;
		
	@GetMapping("/consultar/") 
	public List<Registro_Usuarios_Sesiones_Modelo> ConsutaAll(){
		return registro_Usuarios_Sesiones_Repositorio.findAll();
	}

	@PostMapping("/registrarSesion")
	public Registro_Usuarios_Sesiones_Modelo registrarSesion(@RequestBody Registro_Usuarios_Sesiones_Modelo registro) {
	    Optional<Registro_Usuarios_Sesiones_Modelo> existente =
	        registro_Usuarios_Sesiones_Repositorio.findByUsuario(registro.getUsuario());
	    if (existente.isPresent()) {
	        Registro_Usuarios_Sesiones_Modelo actualizado = existente.get();
	        actualizado.setCapacitaciones_inscri(registro.getCapacitaciones_inscri());
	        actualizado.setStatus_capa(registro.getStatus_capa());
	        return registro_Usuarios_Sesiones_Repositorio.save(actualizado);
	    } else {
	        return registro_Usuarios_Sesiones_Repositorio.save(registro);
	    }
	}
	
	@DeleteMapping("/eliminarUser/{id}")
	public ResponseEntity<String> eliminarUsuarioSesiones(@PathVariable long id) {
	    if (!registro_Usuarios_Sesiones_Repositorio.existsById(id)) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body("El usuario con id " + id + " no existe");
	    }
	    registro_Usuarios_Sesiones_Repositorio.deleteById(id);
	    return ResponseEntity.ok("Usuario eliminado correctamente");
	}
}
