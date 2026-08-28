package com.back.cd.back.cd.Modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="control_pis")
public class Control_PIs_Modelo {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nopo;
	private String foliott;
	private String razonsocial;
	private String incoterm;
	private String puerto;
	private String terminopago;
	private String cantidad;
	private String precio;
	private String etd;
	private String comentarios;
	private LocalDate fechainicial;
	private LocalDate fecharegistr;
	private LocalDate fecharev;
	private LocalDate fechainicialcompras;
	private LocalDate fechafinalcompras;
	private LocalDate finicialplan;
	private LocalDate ffinalplan;
	
	public LocalDate getFecharev() {
		return fecharev;
	}
	public void setFecharev(LocalDate fecharev) {
		this.fecharev = fecharev;
	}
	public LocalDate getFechainicialcompras() {
		return fechainicialcompras;
	}
	public void setFechainicialcompras(LocalDate fechainicialcompras) {
		this.fechainicialcompras = fechainicialcompras;
	}
	public LocalDate getFechafinalcompras() {
		return fechafinalcompras;
	}
	public void setFechafinalcompras(LocalDate fechafinalcompras) {
		this.fechafinalcompras = fechafinalcompras;
	}
	public LocalDate getFinicialplan() {
		return finicialplan;
	}
	public void setFinicialplan(LocalDate finicialplan) {
		this.finicialplan = finicialplan;
	}
	public LocalDate getFfinalplan() {
		return ffinalplan;
	}
	public void setFfinalplan(LocalDate ffinalplan) {
		this.ffinalplan = ffinalplan;
	}
	public LocalDate getFecharegistr() {
		return fecharegistr;
	}
	public void setFecharegistr(LocalDate fecharegistr) {
		this.fecharegistr = fecharegistr;
	}
	public LocalDate getFechainicial() {
		return fechainicial;
	}
	public void setFechainicial(LocalDate fechainicial) {
		this.fechainicial = fechainicial;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public String getEtd() {
		return etd;
	}
	public void setEtd(String etd) {
		this.etd = etd;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getTerminopago() {
		return terminopago;
	}
	public void setTerminopago(String terminopago) {
		this.terminopago = terminopago;
	}
	public String getPuerto() {
		return puerto;
	}
	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}
	public String getIncoterm() {
		return incoterm;
	}
	public void setIncoterm(String incoterm) {
		this.incoterm = incoterm;
	}
	public String getRazonsocial() {
		return razonsocial;
	}
	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNopo() {
		return nopo;
	}
	public void setNopo(String nopo) {
		this.nopo = nopo;
	}
	public String getFoliott() {
		return foliott;
	}
	public void setFoliott(String foliott) {
		this.foliott = foliott;
	}
}
