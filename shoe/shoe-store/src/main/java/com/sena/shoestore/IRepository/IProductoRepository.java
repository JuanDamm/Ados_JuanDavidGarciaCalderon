package com.sena.shoestore.IRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.sena.shoestore.Entity.Productos;

@Repository
public interface IProductoRepository extends IBaseRepository<Productos, Long>{
	
	@Query("SELECT c FROM Productos c WHERE c.nombre = :nombre")
    List<Productos> findByNombre(@Param("nombre") String nombre);
	
}
