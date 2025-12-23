package com.back.cd.back.cd.Modelo.Repositorio;

import java.time.LocalDate;

public interface DocumentosSesionesJoin {

	Long getid();
	String getNombre_carpeta();
	Long getId_c_arriba();
	String getCapacitador();
	LocalDate getFecha_sesion();
	String getDuracion();
	
}
