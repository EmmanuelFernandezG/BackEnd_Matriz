package com.back.cd.back.cd.Modelo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="wksh")
@AllArgsConstructor
@NoArgsConstructor
public class wksh {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id; 
	private int No_Proveedor;
	private String Nombre_del_proveedor;
	private String BU;
	private String Concatenar;
	private String TC_MP;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public int getNo_Proveedor() {
		return No_Proveedor;
	}
	public void setNo_Proveedor(int no_Proveedor) {
		No_Proveedor = no_Proveedor;
	}
	public String getNombre_del_proveedor() {
		return Nombre_del_proveedor;
	}
	public void setNombre_del_proveedor(String nombre_del_proveedor) {
		Nombre_del_proveedor = nombre_del_proveedor;
	}
	public String getBU() {
		return BU;
	}
	public void setBU(String bU) {
		BU = bU;
	}
	public String getConcatenar() {
		return Concatenar;
	}
	public void setConcatenar(String concatenar) {
		Concatenar = concatenar;
	}
	public String getTC_MP() {
		return TC_MP;
	}
	public void setTC_MP(String tC_MP) {
		TC_MP = tC_MP;
	}
}
