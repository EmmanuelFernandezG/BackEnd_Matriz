package com.back.cd.back.cd.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.back.cd.back.cd.Exception.ResourceNotFoundException;
import com.back.cd.back.cd.Modelo.Matriz_Control_Documental_Modelo;
import com.back.cd.back.cd.Modelo.Repositorio.CondicionMatricesBack;
import com.back.cd.back.cd.Modelo.Repositorio.Matriz_ProveedorCambio;
import com.back.cd.back.cd.Modelo.Repositorio.Matriz_cd_Repositorio;
import com.back.cd.back.cd.Modelo.Repositorio.Soc_Familia_1Item;

@RestController
@RequestMapping("/importaciones/controldocumental")
@CrossOrigin
public class Matriz_Cd_Controller {

	@Autowired
	private Matriz_cd_Repositorio matriz_cd_Repositorio;
	
	@GetMapping("/matrizcd")
	public List<Matriz_Control_Documental_Modelo> listartodo(){
		return matriz_cd_Repositorio.findAll();
	}
	
	@PostMapping("/matrizcd")
	public Matriz_Control_Documental_Modelo guardarregistro(@RequestBody Matriz_Control_Documental_Modelo matriz_Control_Documental_Modelo) {
		return matriz_cd_Repositorio.save(matriz_Control_Documental_Modelo);
	}
	
	@GetMapping("/matrizcd/{Id}")
	public ResponseEntity<Matriz_Control_Documental_Modelo> listaRegporId(@PathVariable("Id") Long Id){
		Matriz_Control_Documental_Modelo matriz_Control_Documental_Modelo = matriz_cd_Repositorio.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Registro No Encontrado : " + Id) );
		return ResponseEntity.ok(matriz_Control_Documental_Modelo);
		
	}
	
	@PutMapping("/matrizcd/{Id}")
	public ResponseEntity<Matriz_Control_Documental_Modelo> actualizarRegistro(@PathVariable("Id") Long Id, @RequestBody Matriz_Control_Documental_Modelo registromodif){
		Matriz_Control_Documental_Modelo matriz_Control_Documental_Modelo = matriz_cd_Repositorio.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Registro No Encontrado : " + Id) );
	 matriz_Control_Documental_Modelo.setFecha_de_recepcion(registromodif.getFecha_de_recepcion());
     matriz_Control_Documental_Modelo.setFecha_inicio(registromodif.getFecha_inicio());
     matriz_Control_Documental_Modelo.setFolio_tt(registromodif.getFolio_tt());
     matriz_Control_Documental_Modelo.setNo_oc(registromodif.getNo_oc());
     matriz_Control_Documental_Modelo.setUnidad_de_negocio(registromodif.getUnidad_de_negocio());
     matriz_Control_Documental_Modelo.setNo_de_proveedor(registromodif.getNo_de_proveedor());
     matriz_Control_Documental_Modelo.setProveedor(registromodif.getProveedor());
     matriz_Control_Documental_Modelo.setGerente_de_compras(registromodif.getGerente_de_compras());
     matriz_Control_Documental_Modelo.setConfirmador(registromodif.getConfirmador());
     matriz_Control_Documental_Modelo.setSegunda(registromodif.getSegunda());
     matriz_Control_Documental_Modelo.setPrecio(registromodif.getPrecio());
     matriz_Control_Documental_Modelo.setMatriz(registromodif.getMatriz());
     matriz_Control_Documental_Modelo.setDatos_fiscales(registromodif.getDatos_fiscales());
     matriz_Control_Documental_Modelo.setTerm_de_pago(registromodif.getTerm_de_pago());
     matriz_Control_Documental_Modelo.setDir_de_prov(registromodif.getDir_de_prov());
     matriz_Control_Documental_Modelo.setTax_id(registromodif.getTax_id());
     matriz_Control_Documental_Modelo.setIncoterm(registromodif.getIncoterm());
     matriz_Control_Documental_Modelo.setQty(registromodif.getQty());
     matriz_Control_Documental_Modelo.setEtd(registromodif.getEtd());
     matriz_Control_Documental_Modelo.setEtd_po(registromodif.getEtd_po());
     matriz_Control_Documental_Modelo.setEtd_pi(registromodif.getEtd_pi());
     matriz_Control_Documental_Modelo.setMontopi(registromodif.getMontopi());
     matriz_Control_Documental_Modelo.setMoneda(registromodif.getMoneda());
     matriz_Control_Documental_Modelo.setAdd_elim_item(registromodif.getAdd_elim_item());
     matriz_Control_Documental_Modelo.setPeso_vol(registromodif.getPeso_vol());
     matriz_Control_Documental_Modelo.setPto_directo(registromodif.getPto_directo());
     matriz_Control_Documental_Modelo.setValidacion_pod_vs_pi(registromodif.getValidacion_pod_vs_pi());
     matriz_Control_Documental_Modelo.setObservaciones(registromodif.getObservaciones());
     matriz_Control_Documental_Modelo.setLiberacion_de_matr_con_sello(registromodif.getLiberacion_de_matr_con_sello());
     matriz_Control_Documental_Modelo.setValidaciones_extraordinarias(registromodif.getValidaciones_extraordinarias());
     matriz_Control_Documental_Modelo.setCondicion_de_matrices(registromodif.getCondicion_de_matrices());
     matriz_Control_Documental_Modelo.setCompartida(registromodif.getCompartida());
     matriz_Control_Documental_Modelo.setArea_destino(registromodif.getArea_destino());
     matriz_Control_Documental_Modelo.setFecha_area_destino(registromodif.getFecha_area_destino());
     matriz_Control_Documental_Modelo.setAcuse(registromodif.getAcuse());
     matriz_Control_Documental_Modelo.setStatus__problema(registromodif.getStatus__problema());
     matriz_Control_Documental_Modelo.setLiberada_por_matrices(registromodif.getLiberada_por_matrices());
     matriz_Control_Documental_Modelo.setFecha_matrices(registromodif.getFecha_matrices());
     matriz_Control_Documental_Modelo.setMotivo_matrices(registromodif.getMotivo_matrices());
     matriz_Control_Documental_Modelo.setLiberada_por_bu(registromodif.getLiberada_por_bu());
     matriz_Control_Documental_Modelo.setFecha_bu(registromodif.getFecha_bu());
     matriz_Control_Documental_Modelo.setMotivo_bu(registromodif.getMotivo_bu());
     matriz_Control_Documental_Modelo.setLiberada_por_planeacion(registromodif.getLiberada_por_planeacion());
     matriz_Control_Documental_Modelo.setFecha_planeacion(registromodif.getFecha_planeacion());
     matriz_Control_Documental_Modelo.setMotivo_planeacion(registromodif.getMotivo_planeacion());
     matriz_Control_Documental_Modelo.setLiberada_por_auditoria(registromodif.getLiberada_por_auditoria());
     matriz_Control_Documental_Modelo.setFecha_auditoria(registromodif.getFecha_auditoria());
     matriz_Control_Documental_Modelo.setMotivo_auditoria(registromodif.getMotivo_auditoria());
     matriz_Control_Documental_Modelo.setLiberada_por_sap(registromodif.getLiberada_por_sap());
     matriz_Control_Documental_Modelo.setFecha_sap(registromodif.getFecha_sap());
     matriz_Control_Documental_Modelo.setMotivo_sap(registromodif.getMotivo_sap());
     matriz_Control_Documental_Modelo.setEnvio_a_proveedor(registromodif.getEnvio_a_proveedor());
     matriz_Control_Documental_Modelo.setTrial(registromodif.getTrial());
     matriz_Control_Documental_Modelo.setHistorial_de_modificacion(registromodif.getHistorial_de_modificacion());
     matriz_Control_Documental_Modelo.setFecha_revision(registromodif.getFecha_revision());
     matriz_Control_Documental_Modelo.setFecha_entrega_compras(registromodif.getFecha_entrega_compras());
     matriz_Control_Documental_Modelo.setFecha_de_envio(registromodif.getFecha_de_envio());

     return ResponseEntity.ok(matriz_cd_Repositorio.save(matriz_Control_Documental_Modelo));

	}
	@DeleteMapping("/matrizcd/{Id}")
	public ResponseEntity<Map<String, Boolean>> eliminarRegistro(@PathVariable Long Id){
		Matriz_Control_Documental_Modelo matriz_Control_Documental_Modelo = matriz_cd_Repositorio.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Registro No Encontrado : " + Id) );
		matriz_cd_Repositorio.delete(matriz_Control_Documental_Modelo);
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/matrizcd/nuevapo/{folio_tt}")
	public List<Matriz_Control_Documental_Modelo> buscarRegistro(@PathVariable("folio_tt") Long folio_tt) {
	    return matriz_cd_Repositorio.buscarRegistroporfolio(folio_tt);
	}

	@GetMapping("/matrizcd/inicio/{historial_de_modificacion}")
	public List<Matriz_Control_Documental_Modelo> buscarRegistroporuser(@PathVariable("historial_de_modificacion") String historial_de_modificacion) {
	    return matriz_cd_Repositorio.buscarRegistroporusuario(historial_de_modificacion);
	}

	@GetMapping("/cambiobu/{concatenar}")
		public Optional<Matriz_ProveedorCambio> getProveedor(@PathVariable("concatenar") String concatenar){
			return matriz_cd_Repositorio.findporBu(concatenar);
		}

		@GetMapping("/condmatrices/{foliott}/{nooc}")
		public Optional<CondicionMatricesBack> condicionMatriz(@PathVariable("foliott") Long foliott, @PathVariable("nooc") Long nooc){
			return matriz_cd_Repositorio.CondicionMatrices(foliott, nooc);
		}

		
		
	}
	