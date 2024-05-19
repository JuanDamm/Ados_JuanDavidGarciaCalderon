package com.sena.shoestore.IService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.sena.shoestore.Entity.Cliente;
import com.sena.shoestore.Entity.Ventas;

public interface IVentasService extends IBaseService<Ventas>{
	
	List<Ventas> findVentasByClienteAndFechaVenta(Cliente cliente, LocalDateTime startDate, LocalDateTime endDate);
	
	List<Ventas> findVentasByCliente(String nombre, String apellido);
	
}
