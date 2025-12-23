package com.back.cd.back.cd.Modelo.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.back.cd.back.cd.Modelo.Archivos_Folder_Documentos_Modeo;

@Repository
public interface Archivos_Documentos_Repositorio extends JpaRepository<Archivos_Folder_Documentos_Modeo, Long> {

	@Query(value = ""
		    + "select * from matriz_cd.links_documentos where id_folder = :id_folder ",
		    nativeQuery = true)
			List<Archivos_Folder_Documentos_Modeo> GetbyIdFolder(@Param("id_folder") Long id_folder);

}
