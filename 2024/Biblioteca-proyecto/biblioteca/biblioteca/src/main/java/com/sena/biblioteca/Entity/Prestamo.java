package com.sena.biblioteca.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="prestamo")
public class Prestamo extends ABaseEntity {

    @OneToOne
    @JoinColumn(name = "ejemplar_id", nullable = false)
    private Ejemplar ejemplar;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    
    @Column(name="fecha_prestamo", nullable = false)
    private Date fechaPrestamo;
    
    @Column(name="fecha_devolucion_estimada", nullable = false)
    private Date fechaDevolucionEstimada;

	public Ejemplar getEjemplar() {
		return ejemplar;
	}

	public void setEjemplar(Ejemplar ejemplar) {
		this.ejemplar = ejemplar;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public Date getFechaDevolucionEstimada() {
		return fechaDevolucionEstimada;
	}

	public void setFechaDevolucionEstimada(Date fechaDevolucionEstimada) {
		this.fechaDevolucionEstimada = fechaDevolucionEstimada;
	}

    
}
