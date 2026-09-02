package com.back.cd.back.cd.Modelo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.back.cd.back.cd.Modelo.MatrizCalculadora_Modelo;

@Repository
public interface Matriz_Calculadora_Repositorio extends JpaRepository<MatrizCalculadora_Modelo, Long>{
	@Query(value = ""
			+ "truncate matriz_cd.matriz_calculadora",
			nativeQuery = true)
		void TruncarMatrizCalculadora() ;
}
