package com.back.cd.back.cd.Modelo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.cd.back.cd.Modelo.Folders_carpeta_principal_Modelo;

@Repository
public interface Folders_carpetas_principal_Repositorio extends JpaRepository<Folders_carpeta_principal_Modelo, Long> {

}
