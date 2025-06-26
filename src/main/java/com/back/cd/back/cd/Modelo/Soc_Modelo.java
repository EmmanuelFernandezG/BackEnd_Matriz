package com.back.cd.back.cd.Modelo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@javax.persistence.Entity
@javax.persistence.Table(name = "socs")
public class Soc_Modelo {

     @javax.persistence.Id
     @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
     private Long id;

     private String aplica;
     private String asistentepos;
     private String colocador;
     private String confirmacion_de_proforma_por_parte_del_proveedor;
     private String control_interno;
     private LocalDate envio_de_laocal_proveedoreoc;
     private String envio_de_proforma_autorizadaaproveedor;
     private String familia_del_producto;
     private LocalDate fecha_de_embarque_de_laoc;
     private LocalDate fecha_de_emisionoc;
     private LocalDate fecha_de_emisionrea;
     private LocalDate fecha_de_reciboactrlpos;
     private Integer foliott;
     private String full;
     private String moneda;
     private Float monto_de_overstock;
     private Float monto_de_po;
     private Integer no_de_proveedor;
     private Integer nooc;
     private String observaciones;
     private String promesa_de_embarque_proforma;
     private String puerto_de_embarque;
     private String rea;
     private String recepcion_de_la_proformarp;
     private String reporte_con_problemas;
     private String status_de_embarque;
     private String status_problema;
     private String ubicacion_en_archivo;
     private String unidad_de_negocio;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAplica() {
		return aplica;
	}
	public void setAplica(String aplica) {
		this.aplica = aplica;
	}
	public String getAsistentepos() {
		return asistentepos;
	}
	public void setAsistentepos(String asistentepos) {
		this.asistentepos = asistentepos;
	}
	public String getColocador() {
		return colocador;
	}
	public void setColocador(String colocador) {
		this.colocador = colocador;
	}
	public String getConfirmacion_de_proforma_por_parte_del_proveedor() {
		return confirmacion_de_proforma_por_parte_del_proveedor;
	}
	public void setConfirmacion_de_proforma_por_parte_del_proveedor(
			String confirmacion_de_proforma_por_parte_del_proveedor) {
		this.confirmacion_de_proforma_por_parte_del_proveedor = confirmacion_de_proforma_por_parte_del_proveedor;
	}
	public String getControl_interno() {
		return control_interno;
	}
	public void setControl_interno(String control_interno) {
		this.control_interno = control_interno;
	}
	public LocalDate getEnvio_de_laocal_proveedoreoc() {
		return envio_de_laocal_proveedoreoc;
	}
	public void setEnvio_de_laocal_proveedoreoc(LocalDate envio_de_laocal_proveedoreoc) {
		this.envio_de_laocal_proveedoreoc = envio_de_laocal_proveedoreoc;
	}
	public String getEnvio_de_proforma_autorizadaaproveedor() {
		return envio_de_proforma_autorizadaaproveedor;
	}
	public void setEnvio_de_proforma_autorizadaaproveedor(String envio_de_proforma_autorizadaaproveedor) {
		this.envio_de_proforma_autorizadaaproveedor = envio_de_proforma_autorizadaaproveedor;
	}
	public String getFamilia_del_producto() {
		return familia_del_producto;
	}
	public void setFamilia_del_producto(String familia_del_producto) {
		this.familia_del_producto = familia_del_producto;
	}
	public LocalDate getFecha_de_embarque_de_laoc() {
		return fecha_de_embarque_de_laoc;
	}
	public void setFecha_de_embarque_de_laoc(LocalDate fecha_de_embarque_de_laoc) {
		this.fecha_de_embarque_de_laoc = fecha_de_embarque_de_laoc;
	}
	public LocalDate getFecha_de_emisionoc() {
		return fecha_de_emisionoc;
	}
	public void setFecha_de_emisionoc(LocalDate fecha_de_emisionoc) {
		this.fecha_de_emisionoc = fecha_de_emisionoc;
	}
	public LocalDate getFecha_de_emisionrea() {
		return fecha_de_emisionrea;
	}
	public void setFecha_de_emisionrea(LocalDate fecha_de_emisionrea) {
		this.fecha_de_emisionrea = fecha_de_emisionrea;
	}
	public LocalDate getFecha_de_reciboactrlpos() {
		return fecha_de_reciboactrlpos;
	}
	public void setFecha_de_reciboactrlpos(LocalDate fecha_de_reciboactrlpos) {
		this.fecha_de_reciboactrlpos = fecha_de_reciboactrlpos;
	}
	public Integer getFoliott() {
		return foliott;
	}
	public void setFoliott(Integer foliott) {
		this.foliott = foliott;
	}
	public String getFull() {
		return full;
	}
	public void setFull(String full) {
		this.full = full;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public Float getMonto_de_overstock() {
		return monto_de_overstock;
	}
	public void setMonto_de_overstock(Float monto_de_overstock) {
		this.monto_de_overstock = monto_de_overstock;
	}
	public Float getMonto_de_po() {
		return monto_de_po;
	}
	public void setMonto_de_po(Float monto_de_po) {
		this.monto_de_po = monto_de_po;
	}
	public Integer getNo_de_proveedor() {
		return no_de_proveedor;
	}
	public void setNo_de_proveedor(Integer no_de_proveedor) {
		this.no_de_proveedor = no_de_proveedor;
	}
	public Integer getNooc() {
		return nooc;
	}
	public void setNooc(Integer nooc) {
		this.nooc = nooc;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getPromesa_de_embarque_proforma() {
		return promesa_de_embarque_proforma;
	}
	public void setPromesa_de_embarque_proforma(String promesa_de_embarque_proforma) {
		this.promesa_de_embarque_proforma = promesa_de_embarque_proforma;
	}
	public String getPuerto_de_embarque() {
		return puerto_de_embarque;
	}
	public void setPuerto_de_embarque(String puerto_de_embarque) {
		this.puerto_de_embarque = puerto_de_embarque;
	}
	public String getRea() {
		return rea;
	}
	public void setRea(String rea) {
		this.rea = rea;
	}
	public String getRecepcion_de_la_proformarp() {
		return recepcion_de_la_proformarp;
	}
	public void setRecepcion_de_la_proformarp(String recepcion_de_la_proformarp) {
		this.recepcion_de_la_proformarp = recepcion_de_la_proformarp;
	}
	public String getReporte_con_problemas() {
		return reporte_con_problemas;
	}
	public void setReporte_con_problemas(String reporte_con_problemas) {
		this.reporte_con_problemas = reporte_con_problemas;
	}
	public String getStatus_de_embarque() {
		return status_de_embarque;
	}
	public void setStatus_de_embarque(String status_de_embarque) {
		this.status_de_embarque = status_de_embarque;
	}
	public String getStatus_problema() {
		return status_problema;
	}
	public void setStatus_problema(String status_problema) {
		this.status_problema = status_problema;
	}
	public String getUbicacion_en_archivo() {
		return ubicacion_en_archivo;
	}
	public void setUbicacion_en_archivo(String ubicacion_en_archivo) {
		this.ubicacion_en_archivo = ubicacion_en_archivo;
	}
	public String getUnidad_de_negocio() {
		return unidad_de_negocio;
	}
	public void setUnidad_de_negocio(String unidad_de_negocio) {
		this.unidad_de_negocio = unidad_de_negocio;
	}

	
}
