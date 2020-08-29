package com.fabriciospringcloud.microservicios.app.auditoria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
//@EntityScan({"com.fabriciospringcloud.microservicios.app.commons.usuarios.models.entity"})
public class MicroserviciosAuditoriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosAuditoriaApplication.class, args);
	}

}
