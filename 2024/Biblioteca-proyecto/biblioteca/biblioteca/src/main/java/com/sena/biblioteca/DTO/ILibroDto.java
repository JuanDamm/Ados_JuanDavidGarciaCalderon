package com.sena.biblioteca.DTO;

public interface ILibroDto extends IGenericDto{

	String getAutor();
	Integer getAnoPublicacion();
	String getTitulo();
	Integer getCantidad();
}
