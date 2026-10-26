package com.back.cd.back.cd.Modelo;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "formato_revisados")
@AllArgsConstructor
@NoArgsConstructor
public class Formato_Revisados_Modelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	long id;
	private String unidad_de_negocio;
	private	String responsable;
	private String clasir;
	private	String cuentadocs;
	private String tipoRev;
	private String proveedor;
	private String tipo_modificacion;
	private String tipotabla;
	private String nosolped;
	private String molde;
	private String motivo;
	private String clvterm;
	private String nuevotermpago;
	private String buprovalternos;
    public String getBuprovalternos() {
		return buprovalternos;
	}

	public void setBuprovalternos(String buprovalternos) {
		this.buprovalternos = buprovalternos;
	}
	public String getNuevotermpago() {
		return nuevotermpago;
	}
	public void setNuevotermpago(String nuevotermpago) {
		this.nuevotermpago = nuevotermpago;
	}
	//private String nvotermpago;
	private String contenido_tabla;
	private String po;
	private String c_pag;
	public String getC_pag() {
		return c_pag;
	}
	public void setC_pag(String c_pag) {
		this.c_pag = c_pag;
	}
	public String getPo() {
		return po;
	}
	public void setPo(String po) {
		this.po = po;
	}
	public String getClvterm() {
		return clvterm;
	}
	public void setClvterm(String clvterm) {
		this.clvterm = clvterm;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUnidad_de_negocio() {
		return unidad_de_negocio;
	}
	public void setUnidad_de_negocio(String unidad_de_negocio) {
		this.unidad_de_negocio = unidad_de_negocio;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public String getClasir() {
		return clasir;
	}
	public void setClasir(String clasir) {
		this.clasir = clasir;
	}
	public String getCuentadocs() {
		return cuentadocs;
	}
	public void setCuentadocs(String cuentadocs) {
		this.cuentadocs = cuentadocs;
	}
	public String getTipoRev() {
		return tipoRev;
	}
	public void setTipoRev(String tipoRev) {
		this.tipoRev = tipoRev;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public String getTipo_modificacion() {
		return tipo_modificacion;
	}
	public void setTipo_modificacion(String tipo_modificacion) {
		this.tipo_modificacion = tipo_modificacion;
	}
	public String getTipotabla() {
		return tipotabla;
	}
	public void setTipotabla(String tipotabla) {
		this.tipotabla = tipotabla;
	}
	public String getNosolped() {
		return nosolped;
	}
	public void setNosolped(String nosolped) {
		this.nosolped = nosolped;
	}
	public String getMolde() {
		return molde;
	}
	public void setMolde(String molde) {
		this.molde = molde;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getContenido_tabla() {
		return contenido_tabla;
	}
	public void setContenido_tabla(String contenido_tabla) {
		this.contenido_tabla = contenido_tabla;
	}
	
}