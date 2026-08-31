package com.back.cd.back.cd.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="codigos_planeador")
public class Codigos_Planeador_Modelo {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String item;
	private String nombre_planner;
	private String gerente_planner;
	private String descripcion;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getNombre_planner() {
		return nombre_planner;
	}
	public void setNombre_planner(String nombre_planner) {
		this.nombre_planner = nombre_planner;
	}
	public String getGerente_planner() {
		return gerente_planner;
	}
	public void setGerente_planner(String gerente_planner) {
		this.gerente_planner = gerente_planner;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getComprador() {
		return comprador;
	}
	public void setComprador(String comprador) {
		this.comprador = comprador;
	}
	private String comprador;
	
}