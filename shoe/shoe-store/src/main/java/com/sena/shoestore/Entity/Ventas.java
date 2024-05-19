package com.sena.shoestore.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ventas")
public class Ventas extends ABaseEntity{

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
	
	@Column(name = "total", nullable = false)
	private Double total;
	
	@Column(name = "fecha_venta", nullable = false)
	private LocalDate fecha_venta;
	
	@Column(name = "estado", nullable = false)
	private String estado;
	

	

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public LocalDate getFecha_venta() {
		return fecha_venta;
	}

	public void setFecha_venta(LocalDate fecha_venta) {
		this.fecha_venta = fecha_venta;
	}

	
	
	
}
