package com.back.cd.back.cd.Modelo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.back.cd.back.cd.Modelo.Contactos_Planta_Modelo;

@Repository
public interface Contactos_Planta_Repositorio extends JpaRepository<Contactos_Planta_Modelo, Long>{
	@Query(value = ""
			+ "truncate matriz_cd.contactos_planta",
			nativeQuery = true)
		void TruncarContactosPlanta();

}
