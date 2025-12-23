package com.back.cd.back.cd.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.cd.back.cd.Exception.ResourceNotFoundException;
import com.back.cd.back.cd.Modelo.Matriz_Control_Documental_Modelo;
import com.back.cd.back.cd.Modelo.SocDTO;
import com.back.cd.back.cd.Modelo.Soc_Modelo;
import com.back.cd.back.cd.Modelo.Repositorio.SocProjection;
import com.back.cd.back.cd.Modelo.Repositorio.Soc_Familia_1Item;
import com.back.cd.back.cd.Modelo.Repositorio.Soc_Nuevos;
import com.back.cd.back.cd.Modelo.Repositorio.Soc_Proveedor;
import com.back.cd.back.cd.Modelo.Repositorio.Soc_Repositorio;

@RestController
@RequestMapping("/importaciones/controldocumental")
@CrossOrigin
public class Soc_Controller {
	@Autowired
	private Soc_Repositorio soc_Repositorio;
	
	@GetMapping("/soccompleto/") 
	public List<Soc_Modelo> listarSocTodo(){
		return soc_Repositorio.findAll();
	}
	@GetMapping("/matrizcd/nuevapo/new/{folio_tt}")
	public List<SocProjection> crearMzRegistro(@PathVariable("folio_tt") Long folio_tt) {
	    return soc_Repositorio.crearMzporfolio(folio_tt);
	}

	@GetMapping("/seguimientooc/{poPi}")
	public Optional<Soc_Nuevos> traeSocPorOrden(@PathVariable("poPi") long poPi) {
		return soc_Repositorio.findByNoOrden(poPi);
	}
	
	@PostMapping("/seguimientooc/nuevaPO")
	public Soc_Modelo crearRegistro(@RequestBody Soc_Modelo soc_Modelo) {
		return soc_Repositorio.save(soc_Modelo);
	}

	@PutMapping("/seguimientooc/modPO/{Id}")
	public ResponseEntity<Soc_Modelo> actualizarRegSOc(@PathVariable("Id") Long Id, @RequestBody Soc_Modelo soc_modeloReg){
		Soc_Modelo soc_modelo = soc_Repositorio.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Registro No Encontrado : " + Id) );
	 soc_modelo.setAplica(soc_modeloReg.getAplica());
	 soc_modelo.setAsistentepos(soc_modeloReg.getAsistentepos());
	 soc_modelo.setColocador(soc_modeloReg.getColocador());
	 soc_modelo.setConfirmacion_de_proforma_por_parte_del_proveedor(soc_modeloReg.getConfirmacion_de_proforma_por_parte_del_proveedor());
	 soc_modelo.setControl_interno(soc_modeloReg.getControl_interno());
	 soc_modelo.setEnvio_de_laocal_proveedoreoc(soc_modeloReg.getEnvio_de_laocal_proveedoreoc());
	 soc_modelo.setFamilia_del_producto(soc_modeloReg.getFamilia_del_producto());
	 soc_modelo.setFecha_de_embarque_de_laoc(soc_modeloReg.getFecha_de_embarque_de_laoc());
	 soc_modelo.setFecha_de_emisionoc(soc_modeloReg.getFecha_de_emisionoc());
	 soc_modelo.setFecha_de_emisionrea(soc_modeloReg.getFecha_de_emisionrea());
	 soc_modelo.setFecha_de_reciboactrlpos(soc_modeloReg.getFecha_de_reciboactrlpos());
	 soc_modelo.setFoliott(soc_modeloReg.getFoliott());
	 soc_modelo.setFull(soc_modeloReg.getFull());
	 soc_modelo.setMoneda(soc_modeloReg.getMoneda());
	 soc_modelo.setMonto_de_overstock(soc_modeloReg.getMonto_de_overstock());
	 soc_modelo.setMonto_de_po(soc_modeloReg.getMonto_de_po());
	 soc_modelo.setNo_de_proveedor(soc_modeloReg.getNo_de_proveedor());
	 soc_modelo.setNooc(soc_modeloReg.getNooc());
	 soc_modelo.setObservaciones(soc_modeloReg.getObservaciones());
	 soc_modelo.setPromesa_de_embarque_proforma(soc_modeloReg.getPromesa_de_embarque_proforma());
	 soc_modelo.setPuerto_de_embarque(soc_modeloReg.getPuerto_de_embarque());
	 soc_modelo.setRea(soc_modeloReg.getRea());
	 soc_modelo.setRecepcion_de_la_proformarp(soc_modeloReg.getRecepcion_de_la_proformarp());
	 soc_modelo.setStatus_de_embarque(soc_modeloReg.getStatus_de_embarque());
	 soc_modelo.setReporte_con_problemas(soc_modeloReg.getReporte_con_problemas());
	 soc_modelo.setStatus_problema(soc_modeloReg.getStatus_problema());
	 soc_modelo.setUbicacion_en_archivo(soc_modeloReg.getUbicacion_en_archivo());
	 soc_modelo.setUnidad_de_negocio(soc_modeloReg.getUnidad_de_negocio());
     return ResponseEntity.ok(soc_Repositorio.save(soc_modelo));

	}

	@GetMapping("/proveedor/{no_proveedor}")
	public Optional<Soc_Proveedor> getProveedor(@PathVariable("no_proveedor") Integer no_proveedor) {
		return soc_Repositorio.findProveedorByNoProv(no_proveedor);
	}
	@GetMapping("/familia/{codigo}")
	public Optional<Soc_Familia_1Item> getFamilia(@PathVariable("codigo") Integer codigo){
		return soc_Repositorio.findcodigos(codigo);
	}
	
}
