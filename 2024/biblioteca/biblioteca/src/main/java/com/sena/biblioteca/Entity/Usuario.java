package com.sena.biblioteca.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario extends ABaseEntity{

	@Column(name="name", length = 50, nullable = false)
	private String name;
	
	@Column(name="addres", length = 50, nullable = false)
	private String addres;
	
	@Column(name="phone", length = 50, nullable = false)
	private String phone;
	
	@Column(name="email", length = 50, nullable = false)
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
