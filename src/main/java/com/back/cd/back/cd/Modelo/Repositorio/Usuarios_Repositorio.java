package com.back.cd.back.cd.Modelo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.cd.back.cd.Modelo.Usuarios_Modelo;
@Repository

public interface Usuarios_Repositorio extends JpaRepository<Usuarios_Modelo, Long> {

}
