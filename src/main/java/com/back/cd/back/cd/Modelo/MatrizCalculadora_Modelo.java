package com.back.cd.back.cd.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="matriz_calculadora")
@AllArgsConstructor
@NoArgsConstructor
public class MatrizCalculadora_Modelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codigo;
	private String clave;
	private String descripcion;
	private String familia;
	private String bu;
	private String tipomatriz;
	private String no_proveedor;
	private String proveedor;
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	private String vvnd;
	private String zcom_zpt_zmp;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFamilia() {
		return familia;
	}
	public void setFamilia(String familia) {
		this.familia = familia;
	}
	public String getBu() {
		return bu;
	}
	public void setBu(String bu) {
		this.bu = bu;
	}
	public String getTipomatriz() {
		return tipomatriz;
	}
	public void setTipomatriz(String tipomatriz) {
		this.tipomatriz = tipomatriz;
	}
	public String getNo_proveedor() {
		return no_proveedor;
	}
	public void setNo_proveedor(String no_proveedor) {
		this.no_proveedor = no_proveedor;
	}
	public String getVvnd() {
		return vvnd;
	}
	public void setVvnd(String vvnd) {
		this.vvnd = vvnd;
	}
	public String getZcom_zpt_zmp() {
		return zcom_zpt_zmp;
	}
	public void setZcom_zpt_zmp(String zcom_zpt_zmp) {
		this.zcom_zpt_zmp = zcom_zpt_zmp;
	}
}

