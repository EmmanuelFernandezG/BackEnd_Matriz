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

import com.back.cd.back.cd.Modelo.Formato_Trial_Modelo;
import com.back.cd.back.cd.Modelo.Repositorio.Formato_Trial_Repositorio;

@RestController
@RequestMapping("/importaciones/trialorder")
@CrossOrigin
public class Formato_Trial_Controller {
	@Autowired
	private Formato_Trial_Repositorio trial_Repositorio;
	
	@PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody Formato_Trial_Modelo trial) {
        try {
            Formato_Trial_Modelo guardado = trial_Repositorio.save(trial);
            if (guardado.getFolio() == null || guardado.getFolio().isEmpty()) {
                String folioAutogenerado = "TRIAL-" + String.format("%04d", guardado.getId());
                
                guardado.setFolio(folioAutogenerado);
                guardado = trial_Repositorio.save(guardado);
            }
            return ResponseEntity.ok(guardado); 
        } catch (Exception e) {
        	e.printStackTrace();
            return ResponseEntity.badRequest().body("Error al guardar: " + e.getMessage());
        }
    }
	
	@GetMapping("/buscar/{folio}")
    public ResponseEntity<Formato_Trial_Modelo> buscarPorFolio(@PathVariable String folio) {
        return trial_Repositorio.findByFolio(folio)
        		.map(registro -> ResponseEntity.ok().body(registro))//encuent
                .orElse(ResponseEntity.notFound().build()); //error 404 no encontrado
    }
	
	@GetMapping("/listar")
    public ResponseEntity<List<Formato_Trial_Modelo>> listarTodos() {
        List<Formato_Trial_Modelo> lista = trial_Repositorio.findAll();
        return ResponseEntity.ok(lista);
    }
}
