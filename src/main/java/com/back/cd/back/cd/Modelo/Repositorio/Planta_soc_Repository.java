package com.back.cd.back.cd.Modelo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.cd.back.cd.Modelo.Planta_Soc_Modelo;

@Repository
public interface Planta_soc_Repository extends JpaRepository<Planta_Soc_Modelo, Long>{
	

}
