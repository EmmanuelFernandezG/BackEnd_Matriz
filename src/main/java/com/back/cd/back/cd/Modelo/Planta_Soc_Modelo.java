package com.back.cd.back.cd.Modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Planta_soc")
@AllArgsConstructor
@NoArgsConstructor
public class Planta_Soc_Modelo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private LocalDateTime fecha_de_creacion;
	private long po;
	private String comprador;
	private String colocador;
	private String confirmador;	
	private long no_de_proveedor;
	private String proveedor;
	private String tipo;
	private String revisado;
	private String urgente;
	private LocalDate fecha_inicial_sap;
	private LocalDate fecha_final_sap;
	private LocalDate inicio_proceso_cd;
	private LocalDate fecha_inicial_colocacion;
	private LocalDate fecha_final_colocacion;
	private String comentarios_colocacion;
	private LocalDate fecha_inicial_compras;
	private LocalDate fecha_final_compras;
	private String comentarios_compras;
	private LocalDate fecha_inicial_planeacion;
	private LocalDate fecha_final_planeacion;
	private String comentarios_planeacion;
	private LocalDate fecha_inicial_dircompras;
	private LocalDate fecha_final_dircompras;
	private String comentarios_dircompras;
	private LocalDate fecha_inicial_mp;
	private LocalDate fecha_final_mp;
	private String comentarios_mp;
	private LocalDate fecha_inicial_dg;
	private LocalDate fecha_final_dg;
	private String comentarios_dg;
	private String enviada;
	private String er_comentario;
	private String motivo_de_revisado;
	
	public String getConfirmador() {
		return confirmador;
	}
	public void setConfirmador(String confirmador) {
		this.confirmador = confirmador;
	}
	public LocalDateTime getFecha_de_creacion() {
		return fecha_de_creacion;
	}
	public void setFecha_de_creacion(LocalDateTime fecha_de_creacion) {
		this.fecha_de_creacion = fecha_de_creacion;
	}
	public String getColocador() {
		return colocador;
	}
	public void setColocador(String colocador) {
		this.colocador = colocador;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public long getPo() {
		return po;
	}
	public void setPo(long po) {
		this.po = po;
	}
	public String getComprador() {
		return comprador;
	}
	public void setComprador(String comprador) {
		this.comprador = comprador;
	}
	public long getNo_de_proveedor() {
		return no_de_proveedor;
	}
	public void setNo_de_proveedor(long no_de_proveedor) {
		this.no_de_proveedor = no_de_proveedor;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public String getRevisado() {
		return revisado;
	}
	public void setRevisado(String revisado) {
		this.revisado = revisado;
	}
	public String getUrgente() {
		return urgente;
	}
	public void setUrgente(String urgente) {
		this.urgente = urgente;
	}
	public LocalDate getFecha_inicial_sap() {
		return fecha_inicial_sap;
	}
	public void setFecha_inicial_sap(LocalDate fecha_inicial_sap) {
		this.fecha_inicial_sap = fecha_inicial_sap;
	}
	public LocalDate getFecha_final_sap() {
		return fecha_final_sap;
	}
	public void setFecha_final_sap(LocalDate fecha_final_sap) {
		this.fecha_final_sap = fecha_final_sap;
	}
	public LocalDate getInicio_proceso_cd() {
		return inicio_proceso_cd;
	}
	public void setInicio_proceso_cd(LocalDate inicio_proceso_cd) {
		this.inicio_proceso_cd = inicio_proceso_cd;
	}
	public LocalDate getFecha_inicial_colocacion() {
		return fecha_inicial_colocacion;
	}
	public void setFecha_inicial_colocacion(LocalDate fecha_inicial_colocacion) {
		this.fecha_inicial_colocacion = fecha_inicial_colocacion;
	}
	public LocalDate getFecha_final_colocacion() {
		return fecha_final_colocacion;
	}
	public void setFecha_final_colocacion(LocalDate fecha_final_colocacion) {
		this.fecha_final_colocacion = fecha_final_colocacion;
	}
	public String getComentarios_colocacion() {
		return comentarios_colocacion;
	}
	public void setComentarios_colocacion(String comentarios_colocacion) {
		this.comentarios_colocacion = comentarios_colocacion;
	}
	public LocalDate getFecha_inicial_compras() {
		return fecha_inicial_compras;
	}
	public void setFecha_inicial_compras(LocalDate fecha_inicial_compras) {
		this.fecha_inicial_compras = fecha_inicial_compras;
	}
	public LocalDate getFecha_final_compras() {
		return fecha_final_compras;
	}
	public void setFecha_final_compras(LocalDate fecha_final_compras) {
		this.fecha_final_compras = fecha_final_compras;
	}
	public String getComentarios_compras() {
		return comentarios_compras;
	}
	public void setComentarios_compras(String comentarios_compras) {
		this.comentarios_compras = comentarios_compras;
	}
	public LocalDate getFecha_inicial_planeacion() {
		return fecha_inicial_planeacion;
	}
	public void setFecha_inicial_planeacion(LocalDate fecha_inicial_planeacion) {
		this.fecha_inicial_planeacion = fecha_inicial_planeacion;
	}
	public LocalDate getFecha_final_planeacion() {
		return fecha_final_planeacion;
	}
	public void setFecha_final_planeacion(LocalDate fecha_final_planeacion) {
		this.fecha_final_planeacion = fecha_final_planeacion;
	}
	public String getComentarios_planeacion() {
		return comentarios_planeacion;
	}
	public void setComentarios_planeacion(String comentarios_planeacion) {
		this.comentarios_planeacion = comentarios_planeacion;
	}
	public LocalDate getFecha_inicial_dircompras() {
		return fecha_inicial_dircompras;
	}
	public void setFecha_inicial_dircompras(LocalDate fecha_inicial_dircompras) {
		this.fecha_inicial_dircompras = fecha_inicial_dircompras;
	}
	public LocalDate getFecha_final_dircompras() {
		return fecha_final_dircompras;
	}
	public void setFecha_final_dircompras(LocalDate fecha_final_dircompras) {
		this.fecha_final_dircompras = fecha_final_dircompras;
	}
	public String getComentarios_dircompras() {
		return comentarios_dircompras;
	}
	public void setComentarios_dircompras(String comentarios_dircompras) {
		this.comentarios_dircompras = comentarios_dircompras;
	}
	public LocalDate getFecha_inicial_mp() {
		return fecha_inicial_mp;
	}
	public void setFecha_inicial_mp(LocalDate fecha_inicial_mp) {
		this.fecha_inicial_mp = fecha_inicial_mp;
	}
	public LocalDate getFecha_final_mp() {
		return fecha_final_mp;
	}
	public void setFecha_final_mp(LocalDate fecha_final_mp) {
		this.fecha_final_mp = fecha_final_mp;
	}
	public String getComentarios_mp() {
		return comentarios_mp;
	}
	public void setComentarios_mp(String comentarios_mp) {
		this.comentarios_mp = comentarios_mp;
	}
	public LocalDate getFecha_inicial_dg() {
		return fecha_inicial_dg;
	}
	public void setFecha_inicial_dg(LocalDate fecha_inicial_dg) {
		this.fecha_inicial_dg = fecha_inicial_dg;
	}
	public LocalDate getFecha_final_dg() {
		return fecha_final_dg;
	}
	public void setFecha_final_dg(LocalDate fecha_final_dg) {
		this.fecha_final_dg = fecha_final_dg;
	}
	public String getComentarios_dg() {
		return comentarios_dg;
	}
	public void setComentarios_dg(String comentarios_dg) {
		this.comentarios_dg = comentarios_dg;
	}
	public String getEnviada() {
		return enviada;
	}
	public void setEnviada(String enviada) {
		this.enviada = enviada;
	}
	public String getEr_comentario() {
		return er_comentario;
	}
	public void setEr_comentario(String er_comentario) {
		this.er_comentario = er_comentario;
	}
	public String getMotivo_de_revisado() {
		return motivo_de_revisado;
	}
	public void setMotivo_de_revisado(String motivo_de_revisado) {
		this.motivo_de_revisado = motivo_de_revisado;
	}
	
	
}
