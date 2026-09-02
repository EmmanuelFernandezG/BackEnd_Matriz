package com.back.cd.back.cd.Modelo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.back.cd.back.cd.Modelo.bufferPlanta_Modelo;

@Repository
public interface buffer_Repositorio extends JpaRepository<bufferPlanta_Modelo, Long>{
	@Query(value = ""
			+ "truncate matriz_cd.buffer_planta",
			nativeQuery = true)
		void TruncarBufferPlanta();
}