package com.back.cd.back.cd.Modelo.Repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back.cd.back.cd.Modelo.Registro_Usuarios_Sesiones_Modelo;

public interface Registro_Usuarios_Sesiones_Repositorio extends JpaRepository<Registro_Usuarios_Sesiones_Modelo, Long> {

	Optional<Registro_Usuarios_Sesiones_Modelo> findByUsuario(String usuario);
}
