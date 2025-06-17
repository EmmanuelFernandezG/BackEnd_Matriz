package com.back.cd.back.cd.Modelo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.cd.back.cd.Modelo.Matriz_Control_Documental_Modelo;

@Repository
public interface Matriz_cd_Repositorio extends JpaRepository<Matriz_Control_Documental_Modelo, Long> {

}
