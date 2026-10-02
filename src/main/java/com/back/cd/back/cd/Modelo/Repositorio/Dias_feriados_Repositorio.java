package com.back.cd.back.cd.Modelo.Repositorio;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.back.cd.back.cd.Modelo.Dias_feriados_Modelo;

@Repository
public interface Dias_feriados_Repositorio extends JpaRepository<Dias_feriados_Modelo, Long>{
	Optional<Dias_feriados_Modelo> findByFecha(LocalDate fecha);
	@Query(value = ""
		    +"select fecha from matriz_cd.dias_feriados",
		    nativeQuery = true)
	List<LocalDate> findAllFechas();
}