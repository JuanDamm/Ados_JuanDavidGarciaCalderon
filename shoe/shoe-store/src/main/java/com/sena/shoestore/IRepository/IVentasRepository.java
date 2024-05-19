package com.sena.shoestore.IRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.shoestore.Entity.Cliente;
import com.sena.shoestore.Entity.Ventas;

@Repository
public interface IVentasRepository extends IBaseRepository<Ventas, Long>{


	 @Query("SELECT v FROM Ventas v WHERE v.cliente = :cliente AND v.fecha_venta BETWEEN :startDate AND :endDate")
	    List<Ventas> findVentasByClienteAndFechaVenta(@Param("cliente") Cliente cliente, @Param("startDate") LocalDateTime startDate,
	    @Param("endDate") LocalDateTime endDate);
	 
	   @Query("SELECT v FROM Ventas v WHERE v.cliente.nombre LIKE %:nombre% AND v.cliente.apellido LIKE %:apellido%")
	    List<Ventas> findVentasByCliente(@Param("nombre") String nombre, @Param("apellido") String apellido);

	}
