package com.back.cd.back.cd.Modelo.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.back.cd.back.cd.Modelo.HistorialSOCs_Modelo;

@Repository
public interface Historial_Soc_Repositorio extends JpaRepository<HistorialSOCs_Modelo, Long> {

	
	@Query(value = ""
		    + "SELECT * from historialsoc  "
		    + " WHERE nooc = :nooc",
		    nativeQuery = true)
		List<HistorialSOCs_Modelo> buscarporOrden(@Param("nooc") Long nooc);
	
}
