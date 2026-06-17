package com.back.cd.back.cd.Modelo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.back.cd.back.cd.Modelo.pool;


@Repository
public interface poolRepository extends JpaRepository<pool, Long>{

	@Query(value = ""
			+ "truncate matriz_cd.pool",
			nativeQuery = true)
		void Truncarpool() ;
	
	
	
}
