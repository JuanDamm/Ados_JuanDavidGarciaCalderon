package com.sena.seguridad.Entity;


import jakarta.persistence.JoinColumn;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "module")
public class Module extends ABaseEntity{

	@Column (name= "nombre", length = 50, nullable = false)
	private String nombre;
	
	@Column (name= "ruta", length = 50, nullable = false)
	private String ruta;
	
	@Column (name= "descripcion", length = 50, nullable = false)
	private String descripcion;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "module_view", joinColumns = @JoinColumn(name = "module_id"), inverseJoinColumns = @JoinColumn(name = "view_id"))
	private Set<View> view = new HashSet();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<View> getView() {
		return view;
	}

	public void setView(Set<View> view) {
		this.view = view;
	}
	
	
	
}
