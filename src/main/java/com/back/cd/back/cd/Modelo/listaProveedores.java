package com.back.cd.back.cd.Modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Entity
@Table(name="lista_proveedores")
@AllArgsConstructor
@NoArgsConstructor
public class listaProveedores {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String acreedor;
    private String supplier;
    private String ps;
    private String nombre_pais;
    private String mon;
    private String c_pag;
    private String descripcion_cond_pago;
    private String responsable;
    private String respacreedor;
    private String direcc;
    private String nif;
    private String nif2;
    private String incot;
    private String incoterms2;
    private String orgc;
    private String grupo;
    private LocalDate fecha;
    private String concbusq;
    private String calle;
    private String poblacion;
    private String distrito;
    private String cp;
    private String telefono1;
    private String ntelefax;
    private String rg;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAcreedor() {
		return acreedor;
	}
	public void setAcreedor(String acreedor) {
		this.acreedor = acreedor;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getPs() {
		return ps;
	}
	public void setPs(String ps) {
		this.ps = ps;
	}
	public String getNombre_pais() {
		return nombre_pais;
	}
	public void setNombre_pais(String nombre_pais) {
		this.nombre_pais = nombre_pais;
	}
	public String getMon() {
		return mon;
	}
	public void setMon(String mon) {
		this.mon = mon;
	}
	public String getC_pag() {
		return c_pag;
	}
	public void setC_pag(String c_pag) {
		this.c_pag = c_pag;
	}
	public String getDescripcion_cond_pago() {
		return descripcion_cond_pago;
	}
	public void setDescripcion_cond_pago(String descripcion_cond_pago) {
		this.descripcion_cond_pago = descripcion_cond_pago;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public String getRespacreedor() {
		return respacreedor;
	}
	public void setRespacreedor(String respacreedor) {
		this.respacreedor = respacreedor;
	}
	public String getDirecc() {
		return direcc;
	}
	public void setDirecc(String direcc) {
		this.direcc = direcc;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getNif2() {
		return nif2;
	}
	public void setNif2(String nif2) {
		this.nif2 = nif2;
	}
	public String getIncot() {
		return incot;
	}
	public void setIncot(String incot) {
		this.incot = incot;
	}
	public String getIncoterms2() {
		return incoterms2;
	}
	public void setIncoterms2(String incoterms2) {
		this.incoterms2 = incoterms2;
	}
	public String getOrgc() {
		return orgc;
	}
	public void setOrgc(String orgc) {
		this.orgc = orgc;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getConcbusq() {
		return concbusq;
	}
	public void setConcbusq(String concbusq) {
		this.concbusq = concbusq;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getTelefono1() {
		return telefono1;
	}
	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}
	public String getNtelefax() {
		return ntelefax;
	}
	public void setNtelefax(String ntelefax) {
		this.ntelefax = ntelefax;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}

	
}
