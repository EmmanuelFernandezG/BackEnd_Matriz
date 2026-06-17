package com.back.cd.back.cd.Modelo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.back.cd.back.cd.Modelo.wksh;


@Repository
public interface wkshRepository extends JpaRepository<wksh, Long>{

	@Query(value = ""
			+ "truncate matriz_cd.wksh",
			nativeQuery = true)
		void Truncarwksh() ;
	

	
	
}
