package com.back.cd.back.cd.Modelo;

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
@Table(name = "links_documentos")
public class Archivos_Folder_Documentos_Modeo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long	id;
	private Long	id_carpeta_principal;
	private	String nombre_archivo;
	private String link ;
	private Long id_folder;
	private String capacitador;
	private String onboarding;
	private String area;
	private String direccion;
	private String tipo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_carpeta_principal() {
		return id_carpeta_principal;
	}
	public void setId_carpeta_principal(Long id_carpeta_principal) {
		this.id_carpeta_principal = id_carpeta_principal;
	}
	public String getNombre_archivo() {
		return nombre_archivo;
	}
	public void setNombre_archivo(String nombre_archivo) {
		this.nombre_archivo = nombre_archivo;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Long getId_folder() {
		return id_folder;
	}
	public void setId_folder(Long id_folder) {
		this.id_folder = id_folder;
	}
	public String getCapacitador() {
		return capacitador;
	}
	public void setCapacitador(String capacitador) {
		this.capacitador = capacitador;
	}
	public String getOnboarding() {
		return onboarding;
	}
	public void setOnboarding(String onboarding) {
		this.onboarding = onboarding;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	
}
