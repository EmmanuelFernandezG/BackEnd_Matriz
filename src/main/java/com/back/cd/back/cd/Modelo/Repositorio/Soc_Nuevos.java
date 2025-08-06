package com.back.cd.back.cd.Modelo.Repositorio;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Soc_Nuevos {
	Long getId();
	String getAplica();
	String getAsistentepos();
	String getColocador();
	String getConfirmacion_de_proforma_por_parte_del_proveedor();
	String getControl_interno();
	LocalDate getEnvio_de_laocal_proveedoreoc();
	String getEnvio_de_proforma_autorizadaaproveedor();
	String getFamilia_del_producto();
	LocalDate getFecha_de_embarque_de_laoc();
	LocalDate getFecha_de_emisionoc();
	LocalDate getFecha_de_emisionrea();
	LocalDate getFecha_de_reciboactrlpos();
	Integer getFoliott();
	String getFull();
	String getMoneda();
	BigDecimal getMonto_de_overstock();
	BigDecimal getMonto_de_po();
	Integer getNo_de_proveedor();
	Integer getNooc();
	String getObservaciones();
	String getPromesa_de_embarque_proforma();
	String getPuerto_de_embarque();
	String getRea();
	String getRecepcion_de_la_proformarp();
	String getReporte_con_problemas();
	String getStatus_de_embarque();
	String getStatus_problema();
	String getUbicacion_en_archivo();
	String getUnidad_de_negocio();
	String getTerminos_de_pago();
	String getProveedor();

}
