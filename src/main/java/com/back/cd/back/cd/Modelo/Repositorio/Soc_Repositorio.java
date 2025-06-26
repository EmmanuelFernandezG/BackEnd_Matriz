package com.back.cd.back.cd.Modelo.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.back.cd.back.cd.Modelo.Matriz_Control_Documental_Modelo;
import com.back.cd.back.cd.Modelo.SocDTO;
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
		    + "  contactos.Gte_Responsable_BU AS gerente_de_compras, "
		    + "  contactos.Planeador_planeacion AS confirmador, "
		    + "  lista_proveedores.supplier AS proveedor, "
		    + "  COALESCE(directos.pod, '-') AS pto_directo, "
		    + "  COALESCE(wksh.TC_MP, '-') AS validaciones_extraordinarias "
		    + "FROM socs "
		    + "LEFT JOIN contactos ON socs.unidad_de_negocio = contactos.Unidad_de_Negocio "
		    + "LEFT JOIN lista_proveedores ON lista_proveedores.acreedor = socs.no_de_proveedor "
		    + "LEFT JOIN directos ON directos.po_pm = socs.foliott "
		    + "LEFT JOIN wksh ON wksh.Concatenar = CONCAT(COALESCE(socs.no_de_proveedor, ''), COALESCE(socs.unidad_de_negocio, '')) "
		    + "WHERE socs.foliott = :folio_tt",
		    nativeQuery = true)
		List<SocProjection> crearMzporfolio(@Param("folio_tt") Long folio_tt);

	

}
