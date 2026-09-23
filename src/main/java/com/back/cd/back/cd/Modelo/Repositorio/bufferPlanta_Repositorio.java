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
	
    @Query(value = "delete from matriz_cd.socs where id in (select id from matriz_cd.socs where unidad_de_negocio like 'P L A N T A %')", nativeQuery = true)
    void limpiarSocsPlanta();

    @Query(value = "insert ignore into matriz_cd.socs (familia_del_producto, foliott, full, no_de_proveedor, nooc, status_de_embarque, unidad_de_negocio) " +
                   "select familia, po, fc, left(proveedor, 6), if(po_th IS NULL OR po_th = '' OR po_th = 0, po, po_th), estatus_confirmacion, planta " +
                   "from matriz_cd.buffer_planta where filaAmarilla = 'Blanco' and po is not null and po != ''", nativeQuery = true)
    void bufferASocs();

	
}
