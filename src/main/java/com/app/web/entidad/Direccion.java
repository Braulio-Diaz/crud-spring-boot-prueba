package com.app.web.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "direcciones")
public class Direccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "calle", nullable = false, length = 100)
	private String calle;
	
	@Column (name = "numero", nullable = false, length = 100)
	private String numero;
	
    @ManyToOne
    private Usuario usuario;
    
    public Direccion (){}

	public Direccion(Long id, String calle, String numero, Usuario usuario) {
		super();
		this.id = id;
		this.calle = calle;
		this.numero = numero;
		this.usuario = usuario;
	}
	
	public Direccion(String calle, String numero, Usuario usuario) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", calle=" + calle + ", numero=" + numero + ", usuario=" + usuario + "]";
	}
}
