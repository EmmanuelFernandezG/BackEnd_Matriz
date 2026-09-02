package com.back.cd.back.cd.Modelo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.back.cd.back.cd.Modelo.Control_PIs_Modelo;

@Repository
public interface Control_PIs_Repositorio extends JpaRepository<Control_PIs_Modelo, Long>{
	@Query(value = ""
			+ "truncate matriz_cd.control_pis",
			nativeQuery = true)
		void TruncarControlPIs() ;
}
