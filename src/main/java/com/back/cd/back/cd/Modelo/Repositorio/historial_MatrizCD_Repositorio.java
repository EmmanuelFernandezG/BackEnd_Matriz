package com.back.cd.back.cd.Modelo.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.back.cd.back.cd.Modelo.Historial_Matriz_CD;

public interface historial_MatrizCD_Repositorio extends JpaRepository<Historial_Matriz_CD, Long> {

	
	@Query(value = ""
		    + "SELECT * from historialmatrizcd  "
		    + " WHERE po = :folio_tt",
		    nativeQuery = true)
		List<Historial_Matriz_CD> consutaHist(@Param("folio_tt") Long folio_tt);

	
}
