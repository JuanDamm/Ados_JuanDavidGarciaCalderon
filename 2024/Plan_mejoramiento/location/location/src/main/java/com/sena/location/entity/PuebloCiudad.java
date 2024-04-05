package com.sena.location.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pueblo_ciudad")
public class PuebloCiudad extends ABaseEntity{
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ciudad_id", nullable = false)
    private Ciudad ciudad;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "pueblo_id", nullable = false)
    private Pueblo pueblo;

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Pueblo getPueblo() {
		return pueblo;
	}

	public void setPueblo(Pueblo pueblo) {
		this.pueblo = pueblo;
	}
	
	
}
