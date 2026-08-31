package com.back.cd.back.cd.Modelo.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.back.cd.back.cd.Modelo.bufferPlanta_Modelo;
@Repository
public interface bufferPlanta_Repositorio extends JpaRepository<bufferPlanta_Modelo, Long> {
	@Query(value = ""
			+ "truncate matriz_cd.buffer_planta",
			nativeQuery = true)
		void TruncarBufferPlanta();
	
	@Query(value = ""
		+ " WITH ordenado AS ("
		+ "    SELECT id, po, po_th, prov, codigo, clave, etd, ida, ROW_NUMBER() OVER(PARTITION BY po ORDER BY ida ASC) AS rn "
		+ "    FROM matriz_cd.buffer_planta  WHERE filaAmarilla = 'Blanco'"
		+ ") SELECT id, po, po_th, prov, codigo, clave, etd, ida FROM ordenado WHERE rn = 1 ORDER BY po ASC",
		nativeQuery = true)
	List<Buffer_Projection_Planta> BuscarSinTotales();
}
