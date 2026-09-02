package com.back.cd.back.cd.Modelo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.back.cd.back.cd.Modelo.contactos;

@Repository
public interface contactosRepository extends JpaRepository<contactos, Long>{
	@Query(value = ""
			+ "truncate matriz_cd.contactos",
			nativeQuery = true)
		void Truncarcontactos() ;
}
