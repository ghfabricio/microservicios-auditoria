package com.fabriciospringcloud.microservicios.app.auditoria.models.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "auditoria")
public class Auditoria implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String tabla;

	@NotEmpty
	private String username;

	@NotEmpty
	private String operacion;

	@NotEmpty
	private String area;

	private String info;

	private LocalDate fecha;
 
	private LocalTime hora;

	@NotEmpty
	private String contexto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTabla() {
		return tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String getContexto() {
		return contexto;
	}

	public void setContexto(String contexto) {
		this.contexto = contexto;
	}

	private static final long serialVersionUID = 1L;
}
