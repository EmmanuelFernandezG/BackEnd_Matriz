package com.back.cd.back.cd.Modelo;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tp_pm_tabla_revisados")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tppm_Modelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long po;
	private String proveedor;
	private int posicion;
	private long cantidad;
	private String moneda;
	private long material;
	private String clave;
	private long poth;
	private	LocalDate etd;
	private float precio;
	public long getPo() {
		return po;
	}
	public void setPo(long po) {
		this.po = po;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	public long getCantidad() {
		return cantidad;
	}
	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public long getMaterial() {
		return material;
	}
	public void setMaterial(long material) {
		this.material = material;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public long getPoth() {
		return poth;
	}
	public void setPoth(long poth) {
		this.poth = poth;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDate getEtd() {
		return etd;
	}
	public void setEtd(LocalDate localDate) {
		this.etd = localDate;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
		
}
