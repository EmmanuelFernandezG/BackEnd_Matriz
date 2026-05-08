package com.back.cd.back.cd.Modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="socs_log")
public class socs_log_modelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(name = "nopo")
	private Long nopo;
	@Column(name = "autorizacion_previa")
	private LocalDate autorizacion_previa;
	@Column(name = "comentarios_doc")
	private String comentarios_doc;
	@Column(name = "fecha_final_plan")
	private LocalDate fecha_final_plan;
	
	@Column(name = "comentarios_plan")
	private String comentarios_plan;
	@Column(name = "fecha_final_compras")
	private LocalDate fecha_final_compras;
	@Column(name = "comentarios_compras")
	private String comentarios_compras;
	@Column(name = "numero_reimp")
    private String numero_reimp;
	@Column(name = "comentarios_reimp")
    private String comentarios_reimp;
	@Column(name = "status_reimp")
    private String status_reimp;

	@Column(name = "asistentepos")
    private String asistentepos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNopo() {
		return nopo;
	}

	public void setNopo(Long nopo) {
		this.nopo = nopo;
	}

	public LocalDate getAutorizacion_previa() {
		return autorizacion_previa;
	}

	public void setAutorizacion_previa(LocalDate autorizacion_previa) {
		this.autorizacion_previa = autorizacion_previa;
	}

	public String getComentarios_doc() {
		return comentarios_doc;
	}

	public void setComentarios_doc(String comentarios_doc) {
		this.comentarios_doc = comentarios_doc;
	}

	public LocalDate getFecha_final_plan() {
		return fecha_final_plan;
	}

	public void setFecha_final_plan(LocalDate fecha_final_plan) {
		this.fecha_final_plan = fecha_final_plan;
	}

	public String getComentarios_plan() {
		return comentarios_plan;
	}

	public void setComentarios_plan(String comentarios_plan) {
		this.comentarios_plan = comentarios_plan;
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

	public String getNumero_reimp() {
		return numero_reimp;
	}

	public void setNumero_reimp(String numero_reimp) {
		this.numero_reimp = numero_reimp;
	}

	public String getComentarios_reimp() {
		return comentarios_reimp;
	}

	public void setComentarios_reimp(String comentarios_reimp) {
		this.comentarios_reimp = comentarios_reimp;
	}

	public String getStatus_reimp() {
		return status_reimp;
	}

	public void setStatus_reimp(String status_reimp) {
		this.status_reimp = status_reimp;
	}

	public String getAsistentepos() {
		return asistentepos;
	}

	public void setAsistentepos(String asistentepos) {
		this.asistentepos = asistentepos;
	}


}
