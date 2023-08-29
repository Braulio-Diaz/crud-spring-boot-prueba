package com.app.web.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombres", nullable = false, length = 100)
	private String nombres;
	
	@Column (name = "apellidos", nullable = false, length = 100)
	private String apellidos;
	
	public Usuario (){}

	public Usuario(Long id, String nombres, String apellidos) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
	}
	
	public Usuario(String nombres, String apellidos) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + "]";
	}
	
	
}
