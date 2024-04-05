package com.sena.seguridad.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public class Person extends ABaseEntity{
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	
	@Column(name = "email", length = 100, nullable = false)
	private String email;

	@Column(name = "phone", length = 100, nullable = false)
	private String phone;
	
	@Column(name = "birth", length = 100, nullable = false)
	private LocalDate birth;
	
	@Column(name = "gender", length = 100, nullable = false)
	private String gender;
	
	@Column(name = "address", length = 100, nullable = false)
	private String address;
	
	@Column(name = "document", length = 100, nullable = false)
	private String document;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "city_id", nullable = false)
	private City city;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	
	
	
	 
}
