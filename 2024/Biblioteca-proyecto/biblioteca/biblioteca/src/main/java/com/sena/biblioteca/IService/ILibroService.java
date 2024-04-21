package com.sena.biblioteca.IService;

import java.util.List;

import com.sena.biblioteca.DTO.ILibroDto;
import com.sena.biblioteca.Entity.Libro;

public interface ILibroService extends IBaseService<Libro>{
	
List<ILibroDto> informacionBasica(String titulo);
List<ILibroDto> informacionBasica();
public Integer obtenerCantidadTotalDeLibros();

}
