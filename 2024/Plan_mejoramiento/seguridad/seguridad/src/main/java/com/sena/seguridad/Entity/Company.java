package com.sena.seguridad.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "company")
public class Company extends ABaseEntity{
	
	@Column(name = "nit", length = 50, nullable = false)
	private String nit;
	
	@Column(name = "direccion", length = 100, nullable = false)
	private String direccion;
	
	@Column(name = "telefono", length = 50, nullable = false)
	private String telefono;
	
	@Column(name = "correo", length = 50, nullable = false)
	private String correo;
	
	@Column(name = "web", length = 100, nullable = false)
	private String web;
	
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "city_id", nullable = false)
	private City city;

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}


	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	

}
