package com.back.cd.back.cd.Modelo;

import java.util.List;

public class MailDTO {
	private String noProveedor;
	private String nombreProveedor;
	private String to;
	private String cc;
	private String asunto;
	private String texto;
	private List<String> archivos;
	public String getNoProveedor() {
		return noProveedor;
	}
	public void setNoProveedor(String noProveedor) {
		this.noProveedor = noProveedor;
	}
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public List<String> getArchivos() {
		return archivos;
	}
	public void setArchivos(List<String> archivos) {
		this.archivos = archivos;
	}
}