package com.back.cd.back.cd.Modelo;

import java.math.BigInteger;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@javax.persistence.Entity
@javax.persistence.Table(name = "usuarios")
public class Usuarios_Modelo {

	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private long id;

	@javax.persistence.Column(name = "usuario")
     private String usuario;

	@javax.persistence.Column(name = "constrasena")
    private String constrasena;

	@javax.persistence.Column(name = "perfil")
    private String perfil;

	@javax.persistence.Column(name = "email")
    private String email;

	@javax.persistence.Column(name = "version")
    private BigInteger version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getConstrasena() {
		return constrasena;
	}

	public void setConstrasena(String constrasena) {
		this.constrasena = constrasena;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigInteger getVersion() {
		return version;
	}

	public void setVersion(BigInteger version) {
		this.version = version;
	}

}
