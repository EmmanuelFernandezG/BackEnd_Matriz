package com.back.cd.back.cd.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="sellos")
@AllArgsConstructor
@NoArgsConstructor
public class sellos_Modelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codigo_sap;
	private String uso;
	private String texto_sello;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo_sap() {
		return codigo_sap;
	}
	public void setCodigo_sap(String codigo_sap) {
		this.codigo_sap = codigo_sap;
	}
	public String getUso() {
		return uso;
	}
	public void setUso(String uso) {
		this.uso = uso;
	}
	public String getTexto_sello() {
		return texto_sello;
	}
	public void setTexto_sello(String texto_sello) {
		this.texto_sello = texto_sello;
	}
}
