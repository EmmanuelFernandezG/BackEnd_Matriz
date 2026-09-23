package com.back.cd.back.cd.Modelo.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.back.cd.back.cd.Modelo.Control_PIs_Modelo;
import com.back.cd.back.cd.Modelo.Matriz_Control_Documental_Modelo;

@Repository
public interface Control_PIs_Repositorio extends JpaRepository<Control_PIs_Modelo, Long>{
	@Query(value = ""
			+ "truncate matriz_cd.control_pis",
			nativeQuery = true)
		void TruncarControlPIs() ;
	
	@Query(value = ""
			+ "SELECT * FROM matriz_cd.control_pis WHERE nopo = :nopo", 
			nativeQuery = true)
		List<Control_PIs_Modelo> buscarRegistro(@Param("nopo") Long nopo);
}