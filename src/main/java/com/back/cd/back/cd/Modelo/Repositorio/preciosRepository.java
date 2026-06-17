package com.back.cd.back.cd.Modelo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.back.cd.back.cd.Modelo.precios;

public interface preciosRepository extends JpaRepository<precios, Long> {

	@Query(value = ""
			+ "truncate matriz_cd.precios",
			nativeQuery = true)
		void Truncarprecios() ;
	

}
