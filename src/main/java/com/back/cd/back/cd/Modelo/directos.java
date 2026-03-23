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
@Table(name="directos")
@AllArgsConstructor
@NoArgsConstructor
public class directos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int almacenp5days;
	private int almacenp5pcs;
	private String alt_vendor;
	private float bo;
	private String ce;
	private int cob_plan;
	private int cob_real;
	private int codigo;
	private String contenedor;
	private float dailymrpsale; 
	private int days_in_statuspo;
	private String descripcion;
	private String directo;
	private int existencias_sucursales_days; 
	private int existencias_sucursales_pcs;
	private String factura;
	private String familia;
	private String full_consol;
	private int ida;
	private int inv_peak_plan;
	private int inv_peak_real;
	private String min_qty;
	private String money;
	private LocalDate open_purchase_orderseta;
	private LocalDate open_purchase_ordersetd;
	private float over_stock;
	private int pcsbo;
	private String planeador;
	private int po_days;
	private int po_pm;
	private int po_qty;
	private int po_th;
	private String pod;
	private String proveedor;
	private String sar;
	private String sar2;
	private String sd_vspi;
	private int ss_days;
	private String status_confirmacion;
	private int total_disponible_days;
	private int total_disponible_pcs;
	private int var_sales_vs4weeks;
	private int var_sales_vs_fcstm;
	private int var_vslt;
	private LocalDate registro;
	private String unidadde_negocio;
	private String comentarios;
	private String foliott;
	private String nooc;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getAlmacenp5days() {
		return almacenp5days;
	}
	public void setAlmacenp5days(int almacenp5days) {
		this.almacenp5days = almacenp5days;
	}
	public int getAlmacenp5pcs() {
		return almacenp5pcs;
	}
	public void setAlmacenp5pcs(int almacenp5pcs) {
		this.almacenp5pcs = almacenp5pcs;
	}
	public String getAlt_vendor() {
		return alt_vendor;
	}
	public void setAlt_vendor(String alt_vendor) {
		this.alt_vendor = alt_vendor;
	}
	public float getBo() {
		return bo;
	}
	public void setBo(float bo) {
		this.bo = bo;
	}
	public String getCe() {
		return ce;
	}
	public void setCe(String ce) {
		this.ce = ce;
	}
	public int getCob_plan() {
		return cob_plan;
	}
	public void setCob_plan(int cob_plan) {
		this.cob_plan = cob_plan;
	}
	public int getCob_real() {
		return cob_real;
	}
	public void setCob_real(int cob_real) {
		this.cob_real = cob_real;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getContenedor() {
		return contenedor;
	}
	public void setContenedor(String contenedor) {
		this.contenedor = contenedor;
	}
	public float getDailymrpsale() {
		return dailymrpsale;
	}
	public void setDailymrpsale(float dailymrpsale) {
		this.dailymrpsale = dailymrpsale;
	}
	public int getDays_in_statuspo() {
		return days_in_statuspo;
	}
	public void setDays_in_statuspo(int days_in_statuspo) {
		this.days_in_statuspo = days_in_statuspo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDirecto() {
		return directo;
	}
	public void setDirecto(String directo) {
		this.directo = directo;
	}
	public int getExistencias_sucursales_days() {
		return existencias_sucursales_days;
	}
	public void setExistencias_sucursales_days(int existencias_sucursales_days) {
		this.existencias_sucursales_days = existencias_sucursales_days;
	}
	public int getExistencias_sucursales_pcs() {
		return existencias_sucursales_pcs;
	}
	public void setExistencias_sucursales_pcs(int existencias_sucursales_pcs) {
		this.existencias_sucursales_pcs = existencias_sucursales_pcs;
	}
	public String getFactura() {
		return factura;
	}
	public void setFactura(String factura) {
		this.factura = factura;
	}
	public String getFamilia() {
		return familia;
	}
	public void setFamilia(String familia) {
		this.familia = familia;
	}
	public String getFull_consol() {
		return full_consol;
	}
	public void setFull_consol(String full_consol) {
		this.full_consol = full_consol;
	}
	public int getIda() {
		return ida;
	}
	public void setIda(int ida) {
		this.ida = ida;
	}
	public int getInv_peak_plan() {
		return inv_peak_plan;
	}
	public void setInv_peak_plan(int inv_peak_plan) {
		this.inv_peak_plan = inv_peak_plan;
	}
	public int getInv_peak_real() {
		return inv_peak_real;
	}
	public void setInv_peak_real(int inv_peak_real) {
		this.inv_peak_real = inv_peak_real;
	}
	public String getMin_qty() {
		return min_qty;
	}
	public void setMin_qty(String min_qty) {
		this.min_qty = min_qty;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public LocalDate getOpen_purchase_orderseta() {
		return open_purchase_orderseta;
	}
	public void setOpen_purchase_orderseta(LocalDate open_purchase_orderseta) {
		this.open_purchase_orderseta = open_purchase_orderseta;
	}
	public LocalDate getOpen_purchase_ordersetd() {
		return open_purchase_ordersetd;
	}
	public void setOpen_purchase_ordersetd(LocalDate open_purchase_ordersetd) {
		this.open_purchase_ordersetd = open_purchase_ordersetd;
	}
	public float getOver_stock() {
		return over_stock;
	}
	public void setOver_stock(float over_stock) {
		this.over_stock = over_stock;
	}
	public int getPcsbo() {
		return pcsbo;
	}
	public void setPcsbo(int pcsbo) {
		this.pcsbo = pcsbo;
	}
	public String getPlaneador() {
		return planeador;
	}
	public void setPlaneador(String planeador) {
		this.planeador = planeador;
	}
	public int getPo_days() {
		return po_days;
	}
	public void setPo_days(int po_days) {
		this.po_days = po_days;
	}
	public int getPo_pm() {
		return po_pm;
	}
	public void setPo_pm(int po_pm) {
		this.po_pm = po_pm;
	}
	public int getPo_qty() {
		return po_qty;
	}
	public void setPo_qty(int po_qty) {
		this.po_qty = po_qty;
	}
	public int getPo_th() {
		return po_th;
	}
	public void setPo_th(int po_th) {
		this.po_th = po_th;
	}
	public String getPod() {
		return pod;
	}
	public void setPod(String pod) {
		this.pod = pod;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public String getSar() {
		return sar;
	}
	public void setSar(String sar) {
		this.sar = sar;
	}
	public String getSar2() {
		return sar2;
	}
	public void setSar2(String sar2) {
		this.sar2 = sar2;
	}
	public String getSd_vspi() {
		return sd_vspi;
	}
	public void setSd_vspi(String sd_vspi) {
		this.sd_vspi = sd_vspi;
	}
	public int getSs_days() {
		return ss_days;
	}
	public void setSs_days(int ss_days) {
		this.ss_days = ss_days;
	}
	public String getStatus_confirmacion() {
		return status_confirmacion;
	}
	public void setStatus_confirmacion(String status_confirmacion) {
		this.status_confirmacion = status_confirmacion;
	}
	public int getTotal_disponible_days() {
		return total_disponible_days;
	}
	public void setTotal_disponible_days(int total_disponible_days) {
		this.total_disponible_days = total_disponible_days;
	}
	public int getTotal_disponible_pcs() {
		return total_disponible_pcs;
	}
	public void setTotal_disponible_pcs(int total_disponible_pcs) {
		this.total_disponible_pcs = total_disponible_pcs;
	}
	public int getVar_sales_vs4weeks() {
		return var_sales_vs4weeks;
	}
	public void setVar_sales_vs4weeks(int var_sales_vs4weeks) {
		this.var_sales_vs4weeks = var_sales_vs4weeks;
	}
	public int getVar_sales_vs_fcstm() {
		return var_sales_vs_fcstm;
	}
	public void setVar_sales_vs_fcstm(int var_sales_vs_fcstm) {
		this.var_sales_vs_fcstm = var_sales_vs_fcstm;
	}
	public int getVar_vslt() {
		return var_vslt;
	}
	public void setVar_vslt(int var_vslt) {
		this.var_vslt = var_vslt;
	}
	public LocalDate getRegistro() {
		return registro;
	}
	public void setRegistro(LocalDate registro) {
		this.registro = registro;
	}
	public String getUnidadde_negocio() {
		return unidadde_negocio;
	}
	public void setUnidadde_negocio(String unidadde_negocio) {
		this.unidadde_negocio = unidadde_negocio;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public String getFoliott() {
		return foliott;
	}
	public void setFoliott(String foliott) {
		this.foliott = foliott;
	}
	public String getNooc() {
		return nooc;
	}
	public void setNooc(String nooc) {
		this.nooc = nooc;
	}
}
