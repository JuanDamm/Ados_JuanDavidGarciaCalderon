package com.sena.carrito.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente extends ABaseEntity{
	
	@Column(name="nombre", length = 50, nullable = false)
	private String nombre;
	
	@Column(name = "correo", length = 50, nullable = false)
	private String correo;
	
	@Column(name = "numero", length = 50, nullable = false)
	private String numero;
	
	@Column(name = "direccion", length = 100, nullable = false)
	private String direccion;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
	
}
