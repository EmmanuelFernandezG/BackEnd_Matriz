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
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "carpeta_principal")
public class Folders_carpeta_principal_Modelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String carpeta_principal;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCarpeta_principal() {
		return carpeta_principal;
	}
	public void setCarpeta_principal(String carpeta_principal) {
		this.carpeta_principal = carpeta_principal;
	}
	

}
