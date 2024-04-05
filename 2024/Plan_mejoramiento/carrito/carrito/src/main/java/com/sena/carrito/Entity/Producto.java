package com.sena.carrito.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto extends ABaseEntity{
	
	@Column(name="codigo", length = 50, nullable = false)
	private String codigo;
	
	@Column(name="nombre", length = 50, nullable = false)
	private String nombre;
	
	@Column(name="precio", length = 50, nullable = false)
	private Double precio;
	
	@Column(name="cantidad", length = 50, nullable = false)
	private Integer cantidad;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
}
