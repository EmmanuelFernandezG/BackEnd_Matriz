package com.back.cd.back.cd.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="trial_order")
@AllArgsConstructor
@NoArgsConstructor
public class Formato_Trial_Modelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String folio;
    private String bu;
    
    private String fecha;
    
    @Column(name = "no_prov_sap")
    private String noProvSap;

    @Column(name = "nombreprov")
    private String nombreProv;

    @Column(name = "claveprov")
    private String claveProv;
    
    private String fabrica;
    private String spec;
    
    @Column(name="razon_social")
    private String razonSocial;
    
    @Column(name="tipo_orden")
    private String tipoOrden;
    
    @Column(name="tipo_contenedor")
    private String tipoContenedor;
    
    private String almacen;
    private String centro;
    @Column(name="requiere_nom")
    private String requiereNom;
    private String sellos;
    @Column(name="contenido_tablas")
    private String contenidoTablas;
    @Column(name="pod")
    private String pod;
    private String nombrefabrica;
	public String getNombrefabrica() {
		return nombrefabrica;
	}

	public void setNombrefabrica(String nombrefabrica) {
		this.nombrefabrica = nombrefabrica;
	}

	public String getPod() {
		return pod;
	}

	public void setPod(String pod) {
		this.pod = pod;
	}

	public String getContenidoTablas() {
		return contenidoTablas;
	}

	public void setContenidoTablas(String contenidoTablas) {
		this.contenidoTablas = contenidoTablas;
	}

	public String getSellos() {
		return sellos;
	}

	public void setSellos(String sellos) {
		this.sellos = sellos;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getTipoOrden() {
		return tipoOrden;
	}

	public void setTipoOrden(String tipoOrden) {
		this.tipoOrden = tipoOrden;
	}

	public String getTipoContenedor() {
		return tipoContenedor;
	}

	public void setTipoContenedor(String tipoContenedor) {
		this.tipoContenedor = tipoContenedor;
	}

	public String getAlmacen() {
		return almacen;
	}

	public void setAlmacen(String almacen) {
		this.almacen = almacen;
	}

	public String getCentro() {
		return centro;
	}

	public void setCentro(String centro) {
		this.centro = centro;
	}

	public String getRequiereNom() {
		return requiereNom;
	}

	public void setRequiereNom(String requiereNom) {
		this.requiereNom = requiereNom;
	}

	public String getFabrica() {
		return fabrica;
	}

	public void setFabrica(String fabrica) {
		this.fabrica = fabrica;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getBu() {
		return bu;
	}

	public void setBu(String bu) {
		this.bu = bu;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNoProvSap() {
		return noProvSap;
	}

	public void setNoProvSap(String noProvSap) {
		this.noProvSap = noProvSap;
	}

	public String getNombreProv() {
		return nombreProv;
	}

	public void setNombreProv(String nombreProv) {
		this.nombreProv = nombreProv;
	}

	public String getClaveProv() {
		return claveProv;
	}

	public void setClaveProv(String claveProv) {
		this.claveProv = claveProv;
	}
}
