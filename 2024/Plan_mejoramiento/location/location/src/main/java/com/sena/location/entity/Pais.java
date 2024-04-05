package com.sena.location.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="pais")
public class Pais extends ABaseEntity{
	
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	
	@Column(name = "capital", length = 100, nullable = false)
	private String capital;

	@Column(name = "poblacion", length = 100, nullable = false)
	private String poblacion;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	
	
}
