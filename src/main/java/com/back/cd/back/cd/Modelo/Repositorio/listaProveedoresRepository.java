package com.back.cd.back.cd.Modelo.Repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.back.cd.back.cd.Modelo.listaProveedores;



@Repository
public interface listaProveedoresRepository extends JpaRepository<listaProveedores, Integer>{
	Optional<listaProveedores> findFirstByAcreedor(String acreedor);
	
	@Query(value = ""
			+ "truncate matriz_cd.lista_proveedores",
			nativeQuery = true)
		void Truncarlistaproveedores() ;
}


