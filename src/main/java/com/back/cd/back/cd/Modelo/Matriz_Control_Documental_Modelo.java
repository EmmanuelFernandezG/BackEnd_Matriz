package com.back.cd.back.cd.Modelo;

import java.time.LocalDateTime;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@javax.persistence.Entity
@javax.persistence.Table(name = "matrizcd")
public class Matriz_Control_Documental_Modelo {
	
	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private long id;

	@javax.persistence.Column(name = "fecha_de_recepcion")
     private LocalDateTime fecha_de_recepcion;

     @javax.persistence.Column(name = "fecha_inicio")
     private LocalDateTime fecha_inicio;

     @javax.persistence.Column(name = "folio_tt")
     private Integer folio_tt;

     @javax.persistence.Column(name = "no_oc")
     private Integer no_oc;

     @javax.persistence.Column(name = "unidad_de_negocio")
     private String unidad_de_negocio;

     @javax.persistence.Column(name = "no_de_proveedor")
     private Integer no_de_proveedor;

     @javax.persistence.Column(name = "proveedor")
     private String proveedor;

     @javax.persistence.Column(name = "gerente_de_compras")
     private String gerente_de_compras;

     @javax.persistence.Column(name = "confirmador")
     private String confirmador;

     @javax.persistence.Column(name = "segunda")
     private String segunda;

     @javax.persistence.Column(name = "precio")
     private String precio;

     @javax.persistence.Column(name = "matriz")
     private String matriz;

     @javax.persistence.Column(name = "datos_fiscales")
     private String datos_fiscales;

     @javax.persistence.Column(name = "term_de_pago")
     private String term_de_pago;

     @javax.persistence.Column(name = "dir_de_prov")
     private String dir_de_prov;

     @javax.persistence.Column(name = "tax_id")
     private String tax_id;

     @javax.persistence.Column(name = "incoterm")
     private String incoterm;

     @javax.persistence.Column(name = "qty")
     private String qty;

     @javax.persistence.Column(name = "etd")
     private String etd;

     @javax.persistence.Column(name = "etd_po")
     private LocalDateTime etd_po;

     @javax.persistence.Column(name = "etd_pi")
     private LocalDateTime etd_pi;

     @javax.persistence.Column(name = "montopi")
     private Float montopi;

     @javax.persistence.Column(name = "moneda")
     private String moneda;

     @javax.persistence.Column(name = "add_elim_item")
     private String add_elim_item;

     @javax.persistence.Column(name = "peso_vol")
     private String peso_vol;

     @javax.persistence.Column(name = "pto_directo")
     private String pto_directo;

     @javax.persistence.Column(name = "validacion_pod_vs_pi")
     private String validacion_pod_vs_pi;

     @javax.persistence.Column(name = "observaciones", length = 2612)
     private String observaciones;

     @javax.persistence.Column(name = "liberacion_de_matr_con_sello")
     private String liberacion_de_matr_con_sello;

     @javax.persistence.Column(name = "validaciones_extraordinarias")
     private String validaciones_extraordinarias;

     @javax.persistence.Column(name = "condicion_de_matrices")
     private String condicion_de_matrices;

     @javax.persistence.Column(name = "compartida")
     private String compartida;

     @javax.persistence.Column(name = "area_destino")
     private String area_destino;

     @javax.persistence.Column(name = "fecha_area_destino")
     private LocalDateTime fecha_area_destino;

     @javax.persistence.Column(name = "acuse")
     private String acuse;

     @javax.persistence.Column(name = "status__problema")
     private String status__problema;

     @javax.persistence.Column(name = "liberada_por_matrices")
     private String liberada_por_matrices;

     @javax.persistence.Column(name = "fecha_matrices")
     private LocalDateTime fecha_matrices;

     @javax.persistence.Column(name = "motivo_matrices", length = 1500)
     private String motivo_matrices;

     @javax.persistence.Column(name = "liberada_por_bu")
     private String liberada_por_bu;

     @javax.persistence.Column(name = "fecha_bu")
     private LocalDateTime fecha_bu;

     @javax.persistence.Column(name = "motivo_bu")
     private String motivo_bu;

     @javax.persistence.Column(name = "liberada_por_planeacion")
     private String liberada_por_planeacion;

     @javax.persistence.Column(name = "fecha_planeacion")
     private LocalDateTime fecha_planeacion;

     @javax.persistence.Column(name = "motivo_planeacion")
     private String motivo_planeacion;

     @javax.persistence.Column(name = "liberada_por_auditoria")
     private String liberada_por_auditoria;

     @javax.persistence.Column(name = "fecha_auditoria")
     private LocalDateTime fecha_auditoria;

     @javax.persistence.Column(name = "motivo_auditoria")
     private String motivo_auditoria;

     @javax.persistence.Column(name = "liberada_por_sap")
     private String liberada_por_sap;

     @javax.persistence.Column(name = "fecha_sap")
     private LocalDateTime fecha_sap;

     @javax.persistence.Column(name = "motivo_sap")
     private String motivo_sap;

     @javax.persistence.Column(name = "envio_a_proveedor")
     private String envio_a_proveedor;

     @javax.persistence.Column(name = "trial")
     private String trial;

     @javax.persistence.Column(name = "fecha_entrega_compras")
     private LocalDateTime fecha_entrega_compras;
     
     
     public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getFecha_de_recepcion() {
		return fecha_de_recepcion;
	}

	public void setFecha_de_recepcion(LocalDateTime fecha_de_recepcion) {
		this.fecha_de_recepcion = fecha_de_recepcion;
	}

	public LocalDateTime getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(LocalDateTime fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Integer getFolio_tt() {
		return folio_tt;
	}

	public void setFolio_tt(Integer folio_tt) {
		this.folio_tt = folio_tt;
	}

	public Integer getNo_oc() {
		return no_oc;
	}

	public void setNo_oc(Integer no_oc) {
		this.no_oc = no_oc;
	}

	public String getUnidad_de_negocio() {
		return unidad_de_negocio;
	}

	public void setUnidad_de_negocio(String unidad_de_negocio) {
		this.unidad_de_negocio = unidad_de_negocio;
	}

	public Integer getNo_de_proveedor() {
		return no_de_proveedor;
	}

	public void setNo_de_proveedor(Integer no_de_proveedor) {
		this.no_de_proveedor = no_de_proveedor;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getGerente_de_compras() {
		return gerente_de_compras;
	}

	public void setGerente_de_compras(String gerente_de_compras) {
		this.gerente_de_compras = gerente_de_compras;
	}

	public String getConfirmador() {
		return confirmador;
	}

	public void setConfirmador(String confirmador) {
		this.confirmador = confirmador;
	}

	public String getSegunda() {
		return segunda;
	}

	public void setSegunda(String segunda) {
		this.segunda = segunda;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getMatriz() {
		return matriz;
	}

	public void setMatriz(String matriz) {
		this.matriz = matriz;
	}

	public String getDatos_fiscales() {
		return datos_fiscales;
	}

	public void setDatos_fiscales(String datos_fiscales) {
		this.datos_fiscales = datos_fiscales;
	}

	public String getTerm_de_pago() {
		return term_de_pago;
	}

	public void setTerm_de_pago(String term_de_pago) {
		this.term_de_pago = term_de_pago;
	}

	public String getDir_de_prov() {
		return dir_de_prov;
	}

	public void setDir_de_prov(String dir_de_prov) {
		this.dir_de_prov = dir_de_prov;
	}

	public String getTax_id() {
		return tax_id;
	}

	public void setTax_id(String tax_id) {
		this.tax_id = tax_id;
	}

	public String getIncoterm() {
		return incoterm;
	}

	public void setIncoterm(String incoterm) {
		this.incoterm = incoterm;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getEtd() {
		return etd;
	}

	public void setEtd(String etd) {
		this.etd = etd;
	}

	public LocalDateTime getEtd_po() {
		return etd_po;
	}

	public void setEtd_po(LocalDateTime etd_po) {
		this.etd_po = etd_po;
	}

	public LocalDateTime getEtd_pi() {
		return etd_pi;
	}

	public void setEtd_pi(LocalDateTime etd_pi) {
		this.etd_pi = etd_pi;
	}

	public Float getMontopi() {
		return montopi;
	}

	public void setMontopi(Float montopi) {
		this.montopi = montopi;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getAdd_elim_item() {
		return add_elim_item;
	}

	public void setAdd_elim_item(String add_elim_item) {
		this.add_elim_item = add_elim_item;
	}

	public String getPeso_vol() {
		return peso_vol;
	}

	public void setPeso_vol(String peso_vol) {
		this.peso_vol = peso_vol;
	}

	public String getPto_directo() {
		return pto_directo;
	}

	public void setPto_directo(String pto_directo) {
		this.pto_directo = pto_directo;
	}

	public String getValidacion_pod_vs_pi() {
		return validacion_pod_vs_pi;
	}

	public void setValidacion_pod_vs_pi(String validacion_pod_vs_pi) {
		this.validacion_pod_vs_pi = validacion_pod_vs_pi;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getLiberacion_de_matr_con_sello() {
		return liberacion_de_matr_con_sello;
	}

	public void setLiberacion_de_matr_con_sello(String liberacion_de_matr_con_sello) {
		this.liberacion_de_matr_con_sello = liberacion_de_matr_con_sello;
	}

	public String getValidaciones_extraordinarias() {
		return validaciones_extraordinarias;
	}

	public void setValidaciones_extraordinarias(String validaciones_extraordinarias) {
		this.validaciones_extraordinarias = validaciones_extraordinarias;
	}

	public String getCondicion_de_matrices() {
		return condicion_de_matrices;
	}

	public void setCondicion_de_matrices(String condicion_de_matrices) {
		this.condicion_de_matrices = condicion_de_matrices;
	}

	public String getCompartida() {
		return compartida;
	}

	public void setCompartida(String compartida) {
		this.compartida = compartida;
	}

	public String getArea_destino() {
		return area_destino;
	}

	public void setArea_destino(String area_destino) {
		this.area_destino = area_destino;
	}

	public LocalDateTime getFecha_area_destino() {
		return fecha_area_destino;
	}

	public void setFecha_area_destino(LocalDateTime fecha_area_destino) {
		this.fecha_area_destino = fecha_area_destino;
	}

	public String getAcuse() {
		return acuse;
	}

	public void setAcuse(String acuse) {
		this.acuse = acuse;
	}

	public String getStatus__problema() {
		return status__problema;
	}

	public void setStatus__problema(String status__problema) {
		this.status__problema = status__problema;
	}

	public String getLiberada_por_matrices() {
		return liberada_por_matrices;
	}

	public void setLiberada_por_matrices(String liberada_por_matrices) {
		this.liberada_por_matrices = liberada_por_matrices;
	}

	public LocalDateTime getFecha_matrices() {
		return fecha_matrices;
	}

	public void setFecha_matrices(LocalDateTime fecha_matrices) {
		this.fecha_matrices = fecha_matrices;
	}

	public String getMotivo_matrices() {
		return motivo_matrices;
	}

	public void setMotivo_matrices(String motivo_matrices) {
		this.motivo_matrices = motivo_matrices;
	}

	public String getLiberada_por_bu() {
		return liberada_por_bu;
	}

	public void setLiberada_por_bu(String liberada_por_bu) {
		this.liberada_por_bu = liberada_por_bu;
	}

	public LocalDateTime getFecha_bu() {
		return fecha_bu;
	}

	public void setFecha_bu(LocalDateTime fecha_bu) {
		this.fecha_bu = fecha_bu;
	}

	public String getMotivo_bu() {
		return motivo_bu;
	}

	public void setMotivo_bu(String motivo_bu) {
		this.motivo_bu = motivo_bu;
	}

	public String getLiberada_por_planeacion() {
		return liberada_por_planeacion;
	}

	public void setLiberada_por_planeacion(String liberada_por_planeacion) {
		this.liberada_por_planeacion = liberada_por_planeacion;
	}

	public LocalDateTime getFecha_planeacion() {
		return fecha_planeacion;
	}

	public void setFecha_planeacion(LocalDateTime fecha_planeacion) {
		this.fecha_planeacion = fecha_planeacion;
	}

	public String getMotivo_planeacion() {
		return motivo_planeacion;
	}

	public void setMotivo_planeacion(String motivo_planeacion) {
		this.motivo_planeacion = motivo_planeacion;
	}

	public String getLiberada_por_auditoria() {
		return liberada_por_auditoria;
	}

	public void setLiberada_por_auditoria(String liberada_por_auditoria) {
		this.liberada_por_auditoria = liberada_por_auditoria;
	}

	public LocalDateTime getFecha_auditoria() {
		return fecha_auditoria;
	}

	public void setFecha_auditoria(LocalDateTime fecha_auditoria) {
		this.fecha_auditoria = fecha_auditoria;
	}

	public String getMotivo_auditoria() {
		return motivo_auditoria;
	}

	public void setMotivo_auditoria(String motivo_auditoria) {
		this.motivo_auditoria = motivo_auditoria;
	}

	public String getLiberada_por_sap() {
		return liberada_por_sap;
	}

	public void setLiberada_por_sap(String liberada_por_sap) {
		this.liberada_por_sap = liberada_por_sap;
	}

	public LocalDateTime getFecha_sap() {
		return fecha_sap;
	}

	public void setFecha_sap(LocalDateTime fecha_sap) {
		this.fecha_sap = fecha_sap;
	}

	public String getMotivo_sap() {
		return motivo_sap;
	}

	public void setMotivo_sap(String motivo_sap) {
		this.motivo_sap = motivo_sap;
	}

	public String getEnvio_a_proveedor() {
		return envio_a_proveedor;
	}

	public void setEnvio_a_proveedor(String envio_a_proveedor) {
		this.envio_a_proveedor = envio_a_proveedor;
	}

	public String getTrial() {
		return trial;
	}

	public void setTrial(String trial) {
		this.trial = trial;
	}

	public String getHistorial_de_modificacion() {
		return historial_de_modificacion;
	}

	public void setHistorial_de_modificacion(String historial_de_modificacion) {
		this.historial_de_modificacion = historial_de_modificacion;
	}

	public LocalDateTime getFecha_revision() {
		return fecha_revision;
	}

	public void setFecha_revision(LocalDateTime fecha_revision) {
		this.fecha_revision = fecha_revision;
	}

	public LocalDateTime getFecha_entrega_compras() {
		return fecha_entrega_compras;
	}

	public void setFecha_entrega_compras(LocalDateTime fecha_entrega_compras) {
		this.fecha_entrega_compras = fecha_entrega_compras;
	}

	@javax.persistence.Column(name = "historial_de_modificacion")
     private String historial_de_modificacion;

     @javax.persistence.Column(name = "fecha_revision")
     private LocalDateTime fecha_revision;

}
