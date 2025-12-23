package com.back.cd.back.cd.Modelo.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.back.cd.back.cd.Modelo.Folders_documentos_Modelo;
@Repository
public interface documentos_Repositorio extends JpaRepository<Folders_documentos_Modelo, Long>  {
	

	@Query(value = ""
		    + "SELECT DISTINCT docs.*, links.capacitador "
		    + "            FROM matriz_cd.folders_docs docs "
		    + "           left JOIN matriz_cd.links_documentos links "
		    + "            ON docs.id = links.id_folder ",
		    nativeQuery = true)
			List<DocumentosSesionesJoin> getSesiones();
	
}
