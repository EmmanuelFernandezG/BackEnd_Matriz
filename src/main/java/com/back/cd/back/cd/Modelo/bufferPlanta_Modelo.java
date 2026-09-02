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
@Table(name="buffer_planta")
@AllArgsConstructor
@NoArgsConstructor
public class bufferPlanta_Modelo {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String planta;
	private String planeador;
	private String proveedor;
	private int codigo;
	private String clave;
	private String exclusiva_materia_prima;
	private String familia;
	private String tipo_orden;
	private String var_fsct;
	private int inv_disp_piezas;
	private int inv_disp_dias;
	private int piezas;
	private int dias_consumo;
	private int ss;
	private int total_dias;
	private int pcd;
	private int alm_07_piezas;
	private int alm_07_dias;
	private String po;
	private String po_th;
	private String sar;
	private String fc;
	private String estatus_confirmacion;
	private LocalDate etd;
	private LocalDate eta;
	private String sd_vs_pi;
	private String cantidad;
	private String cob_real;
	private String cob_plan;
	private String var_dias_lt;
	private String idB;
	private Integer ida;
	private String pa;
	private String pico_teorico;
	private String prov;
	private String orden_sugerida;
	private LocalDate fecha_emision_po;
	private LocalDate fecha_embarque;
	private String cantidad_sugerida;
	private String fecha_quemada;
	private String dias_inv;
	private String nota;
	private String no_sar;
	private String contenedor;
	private String factura;
	private String m3;
	private String peso;
	private String priority;
	private String filaAmarilla;
	
	public String getFilaAmarilla() {
		return filaAmarilla;
	}
	public void setFilaAmarilla(String filaAmarilla) {
		this.filaAmarilla = filaAmarilla;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlanta() {
		return planta;
	}
	public void setPlanta(String planta) {
		this.planta = planta;
	}
	public String getPlaneador() {
		return planeador;
	}
	public void setPlaneador(String planeador) {
		this.planeador = planeador;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getExclusiva_materia_prima() {
		return exclusiva_materia_prima;
	}
	public void setExclusiva_materia_prima(String exclusiva_materia_prima) {
		this.exclusiva_materia_prima = exclusiva_materia_prima;
	}
	public String getFamilia() {
		return familia;
	}
	public void setFamilia(String familia) {
		this.familia = familia;
	}
	public String getTipo_orden() {
		return tipo_orden;
	}
	public void setTipo_orden(String tipo_orden) {
		this.tipo_orden = tipo_orden;
	}
	public String getVar_fsct() {
		return var_fsct;
	}
	public void setVar_fsct(String var_fsct) {
		this.var_fsct = var_fsct;
	}
	public int getInv_disp_piezas() {
		return inv_disp_piezas;
	}
	public void setInv_disp_piezas(int inv_disp_piezas) {
		this.inv_disp_piezas = inv_disp_piezas;
	}
	public int getInv_disp_dias() {
		return inv_disp_dias;
	}
	public void setInv_disp_dias(int inv_disp_dias) {
		this.inv_disp_dias = inv_disp_dias;
	}
	public int getPiezas() {
		return piezas;
	}
	public void setPiezas(int piezas) {
		this.piezas = piezas;
	}
	public int getDias_consumo() {
		return dias_consumo;
	}
	public void setDias_consumo(int dias_consumo) {
		this.dias_consumo = dias_consumo;
	}
	public int getSs() {
		return ss;
	}
	public void setSs(int ss) {
		this.ss = ss;
	}
	public int getTotal_dias() {
		return total_dias;
	}
	public void setTotal_dias(int total_dias) {
		this.total_dias = total_dias;
	}
	public int getPcd() {
		return pcd;
	}
	public void setPcd(int pcd) {
		this.pcd = pcd;
	}
	public int getAlm_07_piezas() {
		return alm_07_piezas;
	}
	public void setAlm_07_piezas(int alm_07_piezas) {
		this.alm_07_piezas = alm_07_piezas;
	}
	public int getAlm_07_dias() {
		return alm_07_dias;
	}
	public void setAlm_07_dias(int alm_07_dias) {
		this.alm_07_dias = alm_07_dias;
	}
	public String getPo() {
		return po;
	}
	public void setPo(String po) {
		this.po = po;
	}
	public String getPo_th() {
		return po_th;
	}
	public void setPo_th(String po_th) {
		this.po_th = po_th;
	}
	public String getSar() {
		return sar;
	}
	public void setSar(String sar) {
		this.sar = sar;
	}
	public String getFc() {
		return fc;
	}
	public void setFc(String fc) {
		this.fc = fc;
	}
	public String getEstatus_confirmacion() {
		return estatus_confirmacion;
	}
	public void setEstatus_confirmacion(String estatus_confirmacion) {
		this.estatus_confirmacion = estatus_confirmacion;
	}
	public LocalDate getEtd() {
		return etd;
	}
	public void setEtd(LocalDate etd) {
		this.etd = etd;
	}
	public LocalDate getEta() {
		return eta;
	}
	public void setEta(LocalDate eta) {
		this.eta = eta;
	}
	public String getSd_vs_pi() {
		return sd_vs_pi;
	}
	public void setSd_vs_pi(String sd_vs_pi) {
		this.sd_vs_pi = sd_vs_pi;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getCob_real() {
		return cob_real;
	}
	public void setCob_real(String cob_real) {
		this.cob_real = cob_real;
	}
	public String getCob_plan() {
		return cob_plan;
	}
	public void setCob_plan(String cob_plan) {
		this.cob_plan = cob_plan;
	}
	public String getVar_dias_lt() {
		return var_dias_lt;
	}
	public void setVar_dias_lt(String var_dias_lt) {
		this.var_dias_lt = var_dias_lt;
	}
	public String getIdB() {
		return idB;
	}
	public void setIdB(String idB) {
		this.idB = idB;
	}
	public Integer getIda() {
		return ida;
	}
	public void setIda(Integer ida) {
		this.ida = ida;
	}
	public String getPa() {
		return pa;
	}
	public void setPa(String pa) {
		this.pa = pa;
	}
	public String getPico_teorico() {
		return pico_teorico;
	}
	public void setPico_teorico(String pico_teorico) {
		this.pico_teorico = pico_teorico;
	}
	public String getProv() {
		return prov;
	}
	public void setProv(String prov) {
		this.prov = prov;
	}
	public String getOrden_sugerida() {
		return orden_sugerida;
	}
	public void setOrden_sugerida(String orden_sugerida) {
		this.orden_sugerida = orden_sugerida;
	}
	public LocalDate getFecha_emision_po() {
		return fecha_emision_po;
	}
	public void setFecha_emision_po(LocalDate fecha_emision_po) {
		this.fecha_emision_po = fecha_emision_po;
	}
	public LocalDate getFecha_embarque() {
		return fecha_embarque;
	}
	public void setFecha_embarque(LocalDate fecha_embarque) {
		this.fecha_embarque = fecha_embarque;
	}
	public String getCantidad_sugerida() {
		return cantidad_sugerida;
	}
	public void setCantidad_sugerida(String cantidad_sugerida) {
		this.cantidad_sugerida = cantidad_sugerida;
	}
	public String getFecha_quemada() {
		return fecha_quemada;
	}
	public void setFecha_quemada(String fecha_quemada) {
		this.fecha_quemada = fecha_quemada;
	}
	public String getDias_inv() {
		return dias_inv;
	}
	public void setDias_inv(String dias_inv) {
		this.dias_inv = dias_inv;
	}
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	public String getNo_sar() {
		return no_sar;
	}
	public void setNo_sar(String no_sar) {
		this.no_sar = no_sar;
	}
	public String getContenedor() {
		return contenedor;
	}
	public void setContenedor(String contenedor) {
		this.contenedor = contenedor;
	}
	public String getFactura() {
		return factura;
	}
	public void setFactura(String factura) {
		this.factura = factura;
	}
	public String getM3() {
		return m3;
	}
	public void setM3(String m3) {
		this.m3 = m3;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	
}
