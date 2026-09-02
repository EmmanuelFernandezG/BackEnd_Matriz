package com.back.cd.back.cd.Modelo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.cd.back.cd.Modelo.sellos_Modelo;

@Repository
public interface Sellos_Repositorio extends JpaRepository<sellos_Modelo, Long>{

}
