package com.sena.biblioteca.IRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.biblioteca.Entity.Prestamo;

@Repository
public interface IPrestamoRepository extends IBaseRepository<Prestamo, Long>{
	
	 @Query("SELECT p FROM Prestamo p JOIN p.ejemplar JOIN p.usuario")
	    List<Prestamo> findAllPrestamos();
}
