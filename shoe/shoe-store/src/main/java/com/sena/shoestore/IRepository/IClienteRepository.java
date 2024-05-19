package com.sena.shoestore.IRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.shoestore.Entity.Cliente;

@Repository
public interface IClienteRepository extends IBaseRepository<Cliente, Long>{
	
	 @Query("SELECT c FROM Cliente c WHERE c.nombre = :nombre OR c.ciudad = :ciudad")
	    List<Cliente> findByNombreCiudadEstado(@Param("nombre") String nombre, @Param("ciudad") String ciudad);
}
	