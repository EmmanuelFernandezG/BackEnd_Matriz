package com.back.cd.back.cd.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "registro_usuarios")
public class Registro_Usuarios_Sesiones_Modelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String usuario;
	private String capacitaciones_inscri;
	private String status_capa;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getCapacitaciones_inscri() {
		return capacitaciones_inscri;
	}
	public void setCapacitaciones_inscri(String capacitaciones_inscri) {
		this.capacitaciones_inscri = capacitaciones_inscri;
	}
	public String getStatus_capa() {
		return status_capa;
	}
	public void setStatus_capa(String status_capa) {
		this.status_capa = status_capa;
	}
	
	

}
