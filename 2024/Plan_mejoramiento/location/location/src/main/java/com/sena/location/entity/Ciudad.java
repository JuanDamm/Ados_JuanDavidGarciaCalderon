package com.sena.location.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ciudad")
public class Ciudad extends ABaseEntity{

	@Column(name = "name", length = 100, nullable = false)
	private String name;
	
	@Column(name = "description", length = 500, nullable = false)
	private String description;
	
	@Column(name = "poblacion", nullable = false)
	private Double poblacion;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(Double poblacion) {
		this.poblacion = poblacion;
	}
	
	
}
