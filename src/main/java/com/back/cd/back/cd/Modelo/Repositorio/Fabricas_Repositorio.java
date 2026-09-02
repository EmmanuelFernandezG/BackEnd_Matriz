package com.back.cd.back.cd.Modelo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.back.cd.back.cd.Modelo.Fabricas_Modelo;

@Repository
public interface Fabricas_Repositorio extends JpaRepository<Fabricas_Modelo, Long>{
	@Query(value = ""
			+ "truncate matriz_cd.fabricas",
			nativeQuery = true)
		void Truncarfabricas() ;

	
	@Query(value = "select distinct sap_fabrica from matriz_cd.fabricas where sap_prov_real = :noSap", nativeQuery = true)
	List<String> findFabricasByProveedor(@Param("noSap") String noSap);

	@Query(value = "select nombre_fabrica from matriz_cd.fabricas where sap_prov_real = :noSap and sap_fabrica = :sapFabrica limit 1", nativeQuery = true)
	String findNombreFabrica(@Param("noSap") String noSap, @Param("sapFabrica") String sapFabrica);
	//

	}
