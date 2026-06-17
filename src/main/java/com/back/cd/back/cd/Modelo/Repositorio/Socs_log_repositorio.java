package com.back.cd.back.cd.Modelo.Repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.back.cd.back.cd.Modelo.Socs_log_modelo;

public interface Socs_log_repositorio extends JpaRepository<Socs_log_modelo,Long > {

	@Query(value = ""
			+ "UPDATE matriz_cd.matrizcd m JOIN matriz_cd.pool p ON m.folio_tt = p.pi SET m.liberada_por_matrices = p.status_de_liberacion, "
			+ "m.fecha_matrices = p.fecha_de_liberacion_rechazo, m.motivo_matrices = p.comentarios WHERE m.folio_tt IS NOT NULL",
			nativeQuery = true)
		void actualizarBase() ;
	
}
