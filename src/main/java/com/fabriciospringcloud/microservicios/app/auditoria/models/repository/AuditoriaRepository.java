package com.fabriciospringcloud.microservicios.app.auditoria.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.fabriciospringcloud.microservicios.app.auditoria.models.entity.Auditoria;


public interface AuditoriaRepository extends CrudRepository<Auditoria, Long>{

}
