package com.back.cd.back.cd.Modelo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.back.cd.back.cd.Modelo.MatricesPlanta_Modelo;

@Repository
public interface MatricesPlanta_Repositorio extends JpaRepository<MatricesPlanta_Modelo, Long>{
	@Query(value = ""
			+ "truncate matriz_cd.matrices_planta",
			nativeQuery = true)
		void TruncarMatricesPlanta() ;
}