package com.sena.shoestore.Entity;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente extends ABaseEntity{
	
	@Column(name = "tipo_id", nullable = false)
	private String tipo_id;
	
	@Column(name = "identificacion", nullable = false)
	private String identificacion;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "apellido", nullable = false)
	private String apellido;
	
	@Column(name = "telefono", nullable = false)
	private BigInteger telefono;
	
	@Column(name = "ciudad", nullable = false)
	private String ciudad;
	
	@Column(name = "direccion", nullable = false)
	private String direccion;

	public String getTipo_id() {
		return tipo_id;
	}

	public void setTipo_id(String tipo_id) {
		this.tipo_id = tipo_id;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public BigInteger getTelefono() {
		return telefono;
	}

	public void setTelefono(BigInteger telefono) {
		this.telefono = telefono;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
