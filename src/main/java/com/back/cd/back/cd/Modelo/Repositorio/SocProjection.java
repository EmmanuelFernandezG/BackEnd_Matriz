package com.back.cd.back.cd.Modelo.Repositorio;

import java.sql.Date;
import java.time.LocalDate;

public interface SocProjection {
	Long getfolio_tt();
	Long getNo_oc();
	String getUnidad_de_negocio();
	Long getNo_de_proveedor();
	LocalDate getEtd_po();
	Float getMontopi();
	String getMoneda();
	String getStatus_de_embarque();
	String getGerente_de_compras();
	String getConfirmador();
	String getProveedor();
	String getPto_directo();
	String getValidaciones_extraordinarias();
	String getLiberada_por_matrices();
	String getMotivo_matrices();
	String getFecha_matrices();
	
}
