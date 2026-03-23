package com.back.cd.back.cd.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="codigos")
@AllArgsConstructor
@NoArgsConstructor
public class codigos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private int Codigo;
	private String Clave;
	private String Descripcion;
	private String ClvFamSAP;
	private String FamiliaSAP;
	private String MarcaComercial;
	private String Contactos;
	private String UnidadDeNegocio;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public int getCodigo() {
		return Codigo;
	}
	public void setCodigo(int codigo) {
		Codigo = codigo;
	}
	public String getClave() {
		return Clave;
	}
	public void setClave(String clave) {
		Clave = clave;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getClvFamSAP() {
		return ClvFamSAP;
	}
	public void setClvFamSAP(String clvFamSAP) {
		ClvFamSAP = clvFamSAP;
	}
	public String getFamiliaSAP() {
		return FamiliaSAP;
	}
	public void setFamiliaSAP(String familiaSAP) {
		FamiliaSAP = familiaSAP;
	}
	public String getMarcaComercial() {
		return MarcaComercial;
	}
	public void setMarcaComercial(String marcaComercial) {
		MarcaComercial = marcaComercial;
	}
	public String getContactos() {
		return Contactos;
	}
	public void setContactos(String contactos) {
		Contactos = contactos;
	}
	public String getUnidadDeNegocio() {
		return UnidadDeNegocio;
	}
	public void setUnidadDeNegocio(String unidadDeNegocio) {
		UnidadDeNegocio = unidadDeNegocio;
	}
}
