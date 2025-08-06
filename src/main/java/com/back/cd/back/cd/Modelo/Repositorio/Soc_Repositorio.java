package com.back.cd.back.cd.Modelo.Repositorio;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.back.cd.back.cd.Modelo.Matriz_Control_Documental_Modelo;
import com.back.cd.back.cd.Modelo.Soc_Modelo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.back.cd.back.cd.Modelo.Matriz_Control_Documental_Modelo;
import com.back.cd.back.cd.Modelo.Soc_Modelo;

public interface Soc_Repositorio extends JpaRepository<Soc_Modelo, Long> {
	

	@Query(value = ""
		    + "SELECT DISTINCT "
		    + "  socs.foliott AS folio_tt, "
		    + "  socs.nooc AS no_oc, "
		    + "  socs.unidad_de_negocio, "
		    + "  socs.no_de_proveedor, "
		    + "  socs.fecha_de_embarque_de_laoc AS etd_po, "
		    + "  socs.monto_de_po AS montopi, "
		    + "  socs.moneda, "
		    + "  socs.status_de_embarque, "
		    + "  contactos.Gte_Responsable_BU AS gerente_de_compras, "
		    + "  contactos.Planeador_planeacion AS confirmador, "
		    + "  lista_proveedores.supplier AS proveedor, "
		    + "  COALESCE(directos.pod, 'NA') AS pto_directo, "
		    + "  COALESCE(wksh.TC_MP, 'N/A') AS validaciones_extraordinarias, "
		    + "	 pool.status_de_liberacion AS liberada_por_matrices, "
		    + "	 pool.comentarios AS motivo_matrices , "
		    + "	 pool.fecha_de_liberacion_rechazo as fecha_matrices "
		    + " FROM socs "
		    + " LEFT JOIN contactos ON socs.unidad_de_negocio = contactos.Unidad_de_Negocio "
		    + " LEFT JOIN lista_proveedores ON lista_proveedores.acreedor = socs.no_de_proveedor "
		    + " LEFT JOIN directos ON directos.po_pm = socs.foliott "
		    + " LEFT JOIN wksh ON wksh.Concatenar = CONCAT(COALESCE(socs.no_de_proveedor, ''), COALESCE(socs.unidad_de_negocio, '')) "
		    + " LEFT JOIN pool ON pool.pi = socs.foliott "
		    + " WHERE socs.foliott = :folio_tt",
		    nativeQuery = true)
		List<SocProjection> crearMzporfolio(@Param("folio_tt") Long folio_tt);

	@Query(value = ""
			+ " SELECT socs.*, lp.descripcion_cond_pago as terminos_de_pago, lp.supplier as proveedor " 
           + " FROM matriz_cd.socs socs " 
           + " JOIN matriz_cd.lista_proveedores lp " 
           + " ON socs.no_de_proveedor = lp.acreedor " 
           + " WHERE foliott = :PO_PI OR nooc = :PO_PI "
           + "LIMIT 1",
			nativeQuery = true)
			Optional<Soc_Nuevos> findByNoOrden(@Param("PO_PI") Long poPi);
			
			@Query(value = ""
				+ " Select supplier as proveedor , descripcion_cond_pago as terminos_de_pago from lista_proveedores where acreedor = :no_proveedor limit 1 ",
				nativeQuery = true)
			Optional<Soc_Proveedor> findProveedorByNoProv(@Param("no_proveedor") Integer no_proveedor );

			@Query(value = ""
					+ " select FamiliaSAP as familia_del_producto, UnidadDeNegocio as unidad_de_negocio from codigos where codigo = :codigo ",
					nativeQuery = true)
				Optional<Soc_Familia_1Item> findcodigos(@Param("codigo") Integer codigo );


}
