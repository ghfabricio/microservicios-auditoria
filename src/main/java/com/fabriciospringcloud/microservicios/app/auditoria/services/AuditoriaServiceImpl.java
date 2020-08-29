package com.fabriciospringcloud.microservicios.app.auditoria.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fabriciospringcloud.microservicios.app.auditoria.clients.UsuarioFeignClient;
import com.fabriciospringcloud.microservicios.app.auditoria.models.entity.Auditoria;
import com.fabriciospringcloud.microservicios.app.auditoria.models.repository.AuditoriaRepository;
import com.fabriciospringcloud.microservicios.app.commons.usuarios.models.entity.Usuario;


@Service
public class AuditoriaServiceImpl implements AuditoriaService{

	
	@Autowired
	private AuditoriaRepository repository;
	
	@Autowired
	private UsuarioFeignClient clientUsuario;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Auditoria> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Auditoria> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Auditoria save(Auditoria entity) {
		return repository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findByUsername(String username) {
		return clientUsuario.findByUsername(username);
	}

}//end class
