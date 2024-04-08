package com.sena.biblioteca.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="libro")
public class Libro extends ABaseEntity {

    @Column(name="titulo", length = 100, nullable = false)
    private String titulo;
    
    @Column(name="autor", length = 100, nullable = false)
    private String autor;
    
    @Column(name="isbn", length = 20, nullable = false, unique = true)
    private String isbn;
    
    @Column(name="ano_publicacion", nullable = false)
    private int anoPublicacion;
    
    @Column(name="genero", length = 50, nullable = false)
    private String genero;
    
    @Column(name="editorial", length = 100, nullable = false)
    private String editorial;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getAnoPublicacion() {
		return anoPublicacion;
	}

	public void setAnoPublicacion(int anoPublicacion) {
		this.anoPublicacion = anoPublicacion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
    
    
    
}
    
