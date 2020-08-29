package com.fabriciospringcloud.microservicios.app.auditoria.controllers;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fabriciospringcloud.microservicios.app.auditoria.models.entity.Auditoria;
import com.fabriciospringcloud.microservicios.app.auditoria.services.AuditoriaService;
import com.fabriciospringcloud.microservicios.app.commons.usuarios.models.entity.Usuario;


@RestController
public class AuditoriaController {
	
	private Logger log = LoggerFactory.getLogger(AuditoriaController.class);
	
	@Autowired
	private AuditoriaService service;
	
	private String getUser(Authentication authentication) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		  
		} else {
		  username = principal.toString();
		}
		
		return username;
	}
	
	
    private String getUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.isAuthenticated())
            return auth.getName();
        else
            return "no autenticado";
    }
    
    @ResponseBody
    public String helloWorld(Principal principal) {
        return "Hello " + principal.getName();
    }
    
    public Optional<User> getCurrentAuditor() {

        return Optional.ofNullable(SecurityContextHolder.getContext())
    			  .map(SecurityContext::getAuthentication)
    			  .filter(Authentication::isAuthenticated)
    			  .map(Authentication::getPrincipal)
    			  .map(User.class::cast);
      }
    
//	public String getUser2(HttpServletRequest request) {
//	     Principal userPrincipal =  request.getUserPrincipal();
//	     return  userPrincipal.getName();
//	 }

	
	@GetMapping
	public ResponseEntity<?> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}	
	
	@PostMapping("/login-success")
	public void loginSuccess(@RequestBody Usuario entity, @RequestParam String referencia){
		Auditoria usuarioAuditoria = new Auditoria();
		usuarioAuditoria.setContexto("admin-user");
		usuarioAuditoria.setArea("session");
		usuarioAuditoria.setTabla("usuarios");
		usuarioAuditoria.setUsername(entity.getUsername());
		usuarioAuditoria.setOperacion("login success");
		usuarioAuditoria.setInfo(referencia);
		usuarioAuditoria.setFecha(LocalDate.now());
		usuarioAuditoria.setHora(LocalTime.now());
		service.save(usuarioAuditoria);
	}
	
	@PostMapping("/login-failure")
	public void loginFailure(@RequestBody Usuario entity, @RequestParam String referencia){
		Auditoria usuarioAuditoria = new Auditoria();
		usuarioAuditoria.setContexto("admin-user");
		usuarioAuditoria.setArea("session");
		usuarioAuditoria.setTabla("usuarios");
		usuarioAuditoria.setUsername(entity.getUsername());
		usuarioAuditoria.setOperacion("login failure");
		usuarioAuditoria.setInfo(referencia);
		usuarioAuditoria.setFecha(LocalDate.now());
		usuarioAuditoria.setHora(LocalTime.now());
		service.save(usuarioAuditoria);
	}

	@PostMapping("/editar-usuario")
	public void actualizarUsuario(String referencia, Authentication authentication, Principal principal){
		if (authentication == null) {
			log.info(this.getUser(authentication));
			log.info(this.getUsername());
			log.info(helloWorld(principal));
			//log.info(this.getCurrentAuditor().get().getUsername()); 
			
		}
		//UserDetails user = (UserDetails) authentication.getPrincipal();
		//log.info("authentication.getName: "+user.getUsername()+"...");
		Auditoria usuarioAuditoria = new Auditoria();
		usuarioAuditoria.setContexto("admin-user");
		usuarioAuditoria.setArea("usuario");
		usuarioAuditoria.setTabla("usuarios");
		usuarioAuditoria.setUsername("aca va el usuario");
		usuarioAuditoria.setOperacion("editar usuario");
		usuarioAuditoria.setInfo(referencia);
		usuarioAuditoria.setFecha(LocalDate.now());
		usuarioAuditoria.setHora(LocalTime.now());
		service.save(usuarioAuditoria);
	}
	
}
