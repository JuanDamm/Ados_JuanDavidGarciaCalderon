package com.sena.seguridad.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contract")
public class Contract extends ABaseEntity{
	
	@Column(name = "codigo", length = 50, nullable = false)
	private String codigo;
	
	@Column(name = "fecha_inicio", length = 50, nullable = false)
	private String fechaInicio;
	
	@Column(name = "fecha_final", length = 50, nullable = false)
	private String fechaFinal;
	
	@Column(name = "Salario", length = 50, nullable = false)
	private String salario;
	
	@Column(name = "objeto", length = 50, nullable = false)
	private String objeto;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "employed_id", nullable = false)
	private Employed employed;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;
	
	
}
