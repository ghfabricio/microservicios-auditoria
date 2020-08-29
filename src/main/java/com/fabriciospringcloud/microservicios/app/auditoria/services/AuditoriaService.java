package com.fabriciospringcloud.microservicios.app.auditoria.services;

import java.util.Optional;

import com.fabriciospringcloud.microservicios.app.auditoria.models.entity.Auditoria;
import com.fabriciospringcloud.microservicios.app.commons.usuarios.models.entity.Usuario;


public interface AuditoriaService {
	
	public Iterable<Auditoria> findAll();
	
	public Optional<Auditoria> findById(Long id);
	
	public Auditoria save(Auditoria entity);
	
	public void deleteById(Long id);
	
	//Feign usuario
	public Usuario findByUsername(String username);


}
