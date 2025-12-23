package com.back.cd.back.cd.Modelo.Repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.back.cd.back.cd.Modelo.Matriz_Control_Documental_Modelo;

@Repository
public interface Matriz_cd_Repositorio extends JpaRepository<Matriz_Control_Documental_Modelo, Long> {
	
	
	@Query(value = ""
		+ "SELECT * FROM matriz_cd.matrizcd WHERE folio_tt = :folio_tt", 
		nativeQuery = true)
	List<Matriz_Control_Documental_Modelo> buscarRegistroporfolio(@Param("folio_tt") Long folio_tt);

	@Query(value = ""
			+ "SELECT * FROM matriz_cd.matrizcd WHERE historial_de_modificacion = :historial_de_modificacion " +
			 " ORDER BY fecha_de_recepcion DESC  LIMIT 3 ", 
			nativeQuery = true)
		List<Matriz_Control_Documental_Modelo> buscarRegistroporusuario(@Param("historial_de_modificacion") String historial_de_modificacion);

	@Query(value = ""
	+ " SELECT c.Gte_Responsable_BU,  c.Planeador_planeacion,  COALESCE(w.TC_MP, 'N/A') AS TC_MP "
	+ " FROM contactos c  LEFT JOIN wksh w  ON w.Concatenar = :concatenar "
	+ " WHERE c.Unidad_de_Negocio = RIGHT(:concatenar, length(:concatenar)-6)"
	+ " OR c.Unidad_de_Negocio = RIGHT(:concatenar, LENGTH(:concatenar) - 7)",
	nativeQuery = true)
	Optional<Matriz_ProveedorCambio> findporBu(@Param("concatenar") String concatenar);
		
	@Query(value = ""
		+ " SELECT  COALESCE((select comentarios from matriz_cd.pool where pi in(:foliott, :nooc) limit 1), Null) as motivo_matrices, "
		+ "COALESCE((select status_de_liberacion from matriz_cd.pool where pi in(:foliott, :nooc) limit 1), Null) as liberada_por_matrices ",	
		nativeQuery = true)
	Optional<CondicionMatricesBack> CondicionMatrices(@Param("foliott") Long foliott, @Param("nooc") Long nooc);
	
}
