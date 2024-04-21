package com.sena.biblioteca.IRepository;

import org.apache.tomcat.jni.Library;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.biblioteca.Entity.Libro;
import com.sena.biblioteca.DTO.ILibroDto;
import java.util.List;


@Repository
public interface ILibroRepository extends IBaseRepository<Libro, Long>{

	@Query(value = "SELECT titulo, autor, ano_publicacion AS anoPublicacion FROM libro WHERE titulo = :titulo", nativeQuery = true)
    List<ILibroDto> getInformacionBasica(String titulo);
    
    @Query(value = "SELECT titulo, autor, ano_publicacion AS anoPublicacion FROM libro", nativeQuery = true)
    List<ILibroDto> getInformacionBasicaTodos();
	
    @Query(value = "SELECT SUM(cantidad_disponible) AS totalDisponible FROM libro", nativeQuery = true)
    Integer getTotalLibrosDisponibles();
	
}
