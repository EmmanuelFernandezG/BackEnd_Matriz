package com.back.cd.back.cd.Modelo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.back.cd.back.cd.Modelo.Codigos_Planeador_Modelo;

@Repository
public interface Codigos_Planeador_Repositorio extends JpaRepository<Codigos_Planeador_Modelo, Long>{
	@Query(value = ""
			+ "truncate matriz_cd.codigos_planeador",
			nativeQuery = true)
		void TruncarCodigosPlaneador();
}
