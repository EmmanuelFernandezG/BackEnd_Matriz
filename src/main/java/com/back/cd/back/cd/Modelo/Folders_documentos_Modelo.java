package com.back.cd.back.cd.Modelo;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "folders_docs")
public class Folders_documentos_Modelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre_carpeta ;
	private long id_c_arriba;
	private LocalDate  fecha_sesion;
	private String duracion;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre_carpeta() {
		return nombre_carpeta;
	}
	public void setNombre_carpeta(String nombre_carpeta) {
		this.nombre_carpeta = nombre_carpeta;
	}
	public long getId_c_arriba() {
		return id_c_arriba;
	}
	public void setId_c_arriba(long id_c_arriba) {
		this.id_c_arriba = id_c_arriba;
	}
	public LocalDate getFecha_sesion() {
		return fecha_sesion;
	}
	public void setFecha_sesion(LocalDate fecha_sesion) {
		this.fecha_sesion = fecha_sesion;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}	
	
}
