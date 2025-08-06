package com.back.cd.back.cd.Modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "historialmatrizcd")
public class Historial_Matriz_CD {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String actual;
	private String anterior;
	private String	dato;
	private LocalDateTime fechaactualizacion;
	private long po;
	private String usuario;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getActual() {
		return actual;
	}
	public void setActual(String actual) {
		this.actual = actual;
	}
	public String getAnterior() {
		return anterior;
	}
	public void setAnterior(String anterior) {
		this.anterior = anterior;
	}
	public String getDato() {
		return dato;
	}
	public void setDato(String dato) {
		this.dato = dato;
	}
	public LocalDateTime getFechaactualizacion() {
		return fechaactualizacion;
	}
	public void setFechaactualizacion(LocalDateTime fechaactualizacion) {
		this.fechaactualizacion = fechaactualizacion;
	}
	public long getPo() {
		return po;
	}
	public void setPo(long po) {
		this.po = po;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
}
