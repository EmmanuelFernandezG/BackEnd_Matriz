package com.back.cd.back.cd.Modelo;

import java.time.LocalDate;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "historialsoc")

public class HistorialSOCs_Modelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private	LocalDate registro;
	private Long foliott;
	private Long nooc;
	private String comentarios; 
	private String unidadde_negocio	;
	private String usuario;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getRegistro() {
		return registro;
	}
	public void setRegistro(LocalDate registro) {
		this.registro = registro;
	}
	public Long getFoliott() {
		return foliott;
	}
	public void setFoliott(Long foliott) {
		this.foliott = foliott;
	}
	public Long getNooc() {
		return nooc;
	}
	public void setNooc(Long nooc) {
		this.nooc = nooc;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public String getUnidadde_negocio() {
		return unidadde_negocio;
	}
	public void setUnidadde_negocio(String unidadde_negocio) {
		this.unidadde_negocio = unidadde_negocio;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	
	
}
