package com.back.cd.back.cd.Modelo.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.back.cd.back.cd.Modelo.Matriz_Control_Documental_Modelo;

@Repository
public interface Matriz_cd_Repositorio extends JpaRepository<Matriz_Control_Documental_Modelo, Long> {
	
	
	@Query(value = ""
		+ "SELECT * FROM matriz_cd.matrizcd WHERE folio_tt = :folio_tt", 
		nativeQuery = true)
	List<Matriz_Control_Documental_Modelo> buscarRegistroporfolio(@Param("folio_tt") Long folio_tt);

}
