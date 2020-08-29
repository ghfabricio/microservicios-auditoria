package com.fabriciospringcloud.microservicios.app.auditoria.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fabriciospringcloud.microservicios.app.commons.usuarios.models.entity.Usuario;

@FeignClient(name="microservicios-usuarios")
public interface UsuarioFeignClient {

	@GetMapping("/buscar-usuario")
	public Usuario findByUsername(@RequestParam String username);
	

}
