package com.back.cd.back.cd.Modelo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.cd.back.cd.Modelo.codigos;


@Repository
public interface codigosRepository extends JpaRepository<codigos, Long>{

}
