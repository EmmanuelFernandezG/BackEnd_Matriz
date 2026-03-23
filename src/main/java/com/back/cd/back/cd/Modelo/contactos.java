package com.back.cd.back.cd.Modelo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="contactos")
@AllArgsConstructor
@NoArgsConstructor
public class contactos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Grupo_de_Compras; 
	private String Grupo_de_Planeadores;
	private String Unidad_de_Negocio;
	private String Director_SR_de_BU;
	private String Director_JR_de_BU;
	private String Gte_Responsable_BU;
	private String Comprador;
	private String Asistente;
	private String Gerente_planeacion;
	private String Planeador_planeacion;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGrupo_de_Compras() {
		return Grupo_de_Compras;
	}
	public void setGrupo_de_Compras(String grupo_de_Compras) {
		Grupo_de_Compras = grupo_de_Compras;
	}
	public String getGrupo_de_Planeadores() {
		return Grupo_de_Planeadores;
	}
	public void setGrupo_de_Planeadores(String grupo_de_Planeadores) {
		Grupo_de_Planeadores = grupo_de_Planeadores;
	}
	public String getUnidad_de_Negocio() {
		return Unidad_de_Negocio;
	}
	public void setUnidad_de_Negocio(String unidad_de_Negocio) {
		Unidad_de_Negocio = unidad_de_Negocio;
	}
	public String getDirector_SR_de_BU() {
		return Director_SR_de_BU;
	}
	public void setDirector_SR_de_BU(String director_SR_de_BU) {
		Director_SR_de_BU = director_SR_de_BU;
	}
	public String getDirector_JR_de_BU() {
		return Director_JR_de_BU;
	}
	public void setDirector_JR_de_BU(String director_JR_de_BU) {
		Director_JR_de_BU = director_JR_de_BU;
	}
	public String getGte_Responsable_BU() {
		return Gte_Responsable_BU;
	}
	public void setGte_Responsable_BU(String gte_Responsable_BU) {
		Gte_Responsable_BU = gte_Responsable_BU;
	}
	public String getComprador() {
		return Comprador;
	}
	public void setComprador(String comprador) {
		Comprador = comprador;
	}
	public String getAsistente() {
		return Asistente;
	}
	public void setAsistente(String asistente) {
		Asistente = asistente;
	}
	public String getGerente_planeacion() {
		return Gerente_planeacion;
	}
	public void setGerente_planeacion(String gerente_planeacion) {
		Gerente_planeacion = gerente_planeacion;
	}
	public String getPlaneador_planeacion() {
		return Planeador_planeacion;
	}
	public void setPlaneador_planeacion(String planeador_planeacion) {
		Planeador_planeacion = planeador_planeacion;
	}
}
