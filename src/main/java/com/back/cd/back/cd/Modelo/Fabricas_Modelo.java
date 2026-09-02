package com.back.cd.back.cd.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="fabricas")
@AllArgsConstructor
@NoArgsConstructor
public class Fabricas_Modelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String codigo;
	private String clave;
	private String sap_prov_real;
	private String nombre_prov_real;
	private String sap_fabrica;
	private String nombre_fabrica;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getSap_prov_real() {
		return sap_prov_real;
	}
	public void setSap_prov_real(String sap_prov_real) {
		this.sap_prov_real = sap_prov_real;
	}
	public String getNombre_prov_real() {
		return nombre_prov_real;
	}
	public void setNombre_prov_real(String nombre_prov_real) {
		this.nombre_prov_real = nombre_prov_real;
	}
	public String getSap_fabrica() {
		return sap_fabrica;
	}
	public void setSap_fabrica(String sap_fabrica) {
		this.sap_fabrica = sap_fabrica;
	}
	public String getNombre_fabrica() {
		return nombre_fabrica;
	}
	public void setNombre_fabrica(String nombre_fabrica) {
		this.nombre_fabrica = nombre_fabrica;
	}
}
