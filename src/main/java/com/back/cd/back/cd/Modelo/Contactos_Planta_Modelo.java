package com.back.cd.back.cd.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contactos_planta")
public class Contactos_Planta_Modelo {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String responsable;
	private String gerente;
	private String rol;
	private String correspondencia;
	private String bu;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public String getGerente() {
		return gerente;
	}
	public void setGerente(String gerente) {
		this.gerente = gerente;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getCorrespondencia() {
		return correspondencia;
	}
	public void setCorrespondencia(String correspondencia) {
		this.correspondencia = correspondencia;
	}
	public String getBu() {
		return bu;
	}
	public void setBu(String bu) {
		this.bu = bu;
	}
}