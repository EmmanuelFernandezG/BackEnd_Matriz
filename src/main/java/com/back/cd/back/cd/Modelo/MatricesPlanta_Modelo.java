package com.back.cd.back.cd.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="matrices_planta")
@AllArgsConstructor
@NoArgsConstructor
public class MatricesPlanta_Modelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nombre;
	private String trader_utilizado;
	private String prices;
	//private String days;//
	//private String remark;//
	private String pm;
	private String hoja;
	public String getHoja() {
		return hoja;
	}
	public void setHoja(String hoja) {
		this.hoja = hoja;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTrader_utilizado() {
		return trader_utilizado;
	}
	public void setTrader_utilizado(String trader_utilizado) {
		this.trader_utilizado = trader_utilizado;
	}
	public String getPrices() {
		return prices;
	}
	public void setPrices(String prices) {
		this.prices = prices;
	}
	public String getPm() {
		return pm;
	}
	public void setPm(String pm) {
		this.pm = pm;
	}
}