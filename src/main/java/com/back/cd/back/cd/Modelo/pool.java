package com.back.cd.back.cd.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="pool")
@AllArgsConstructor
@NoArgsConstructor
public class pool {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String anomalias; 
	private String bu; 
	private String comentarios; 
	private String fecha_de_liberacion_rechazo; 
	private String ida; 
	private String liberada_por; 
	private String no_de_proveedor; 
	private String open_purchase_orders_etd; 
	private int pi;
	private String proveedor;
	private String recibidas_en_el_dia;
	private String seg_ctrl_doc;
	private String status_de_liberacion;
	private String status_matriz_dias_transcurridos;
	private String urgente;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAnomalias() {
		return anomalias;
	}
	public void setAnomalias(String anomalias) {
		this.anomalias = anomalias;
	}
	public String getBu() {
		return bu;
	}
	public void setBu(String bu) {
		this.bu = bu;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public String getFecha_de_liberacion_rechazo() {
		return fecha_de_liberacion_rechazo;
	}
	public void setFecha_de_liberacion_rechazo(String fecha_de_liberacion_rechazo) {
		this.fecha_de_liberacion_rechazo = fecha_de_liberacion_rechazo;
	}
	public String getIda() {
		return ida;
	}
	public void setIda(String ida) {
		this.ida = ida;
	}
	public String getLiberada_por() {
		return liberada_por;
	}
	public void setLiberada_por(String liberada_por) {
		this.liberada_por = liberada_por;
	}
	public String getNo_de_proveedor() {
		return no_de_proveedor;
	}
	public void setNo_de_proveedor(String no_de_proveedor) {
		this.no_de_proveedor = no_de_proveedor;
	}
	public String getOpen_purchase_orders_etd() {
		return open_purchase_orders_etd;
	}
	public void setOpen_purchase_orders_etd(String open_purchase_orders_etd) {
		this.open_purchase_orders_etd = open_purchase_orders_etd;
	}
	public int getPi() {
		return pi;
	}
	public void setPi(int pi) {
		this.pi = pi;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public String getRecibidas_en_el_dia() {
		return recibidas_en_el_dia;
	}
	public void setRecibidas_en_el_dia(String recibidas_en_el_dia) {
		this.recibidas_en_el_dia = recibidas_en_el_dia;
	}
	public String getSeg_ctrl_doc() {
		return seg_ctrl_doc;
	}
	public void setSeg_ctrl_doc(String seg_ctrl_doc) {
		this.seg_ctrl_doc = seg_ctrl_doc;
	}
	public String getStatus_de_liberacion() {
		return status_de_liberacion;
	}
	public void setStatus_de_liberacion(String status_de_liberacion) {
		this.status_de_liberacion = status_de_liberacion;
	}
	public String getStatus_matriz_dias_transcurridos() {
		return status_matriz_dias_transcurridos;
	}
	public void setStatus_matriz_dias_transcurridos(String status_matriz_dias_transcurridos) {
		this.status_matriz_dias_transcurridos = status_matriz_dias_transcurridos;
	}
	public String getUrgente() {
		return urgente;
	}
	public void setUrgente(String urgente) {
		this.urgente = urgente;
	}
}
