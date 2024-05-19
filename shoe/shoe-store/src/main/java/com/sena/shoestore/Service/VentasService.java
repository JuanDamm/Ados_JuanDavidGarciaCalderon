package com.sena.shoestore.Service;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.shoestore.Entity.Cliente;
import com.sena.shoestore.Entity.Ventas;
import com.sena.shoestore.IRepository.IBaseRepository;
import com.sena.shoestore.IRepository.IVentasRepository;
import com.sena.shoestore.IService.IVentasService;

@Service
public class VentasService extends ABaseService<Ventas> implements IVentasService{

	@Autowired
	private IVentasRepository repository;
	
	@Override
    public void delete(Long id) throws Exception {
        // TODO Auto-generated method stub
        repository.deleteById(id);
    }

	@Override
	protected IBaseRepository<Ventas, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}

	@Override
	public List<Ventas> findVentasByClienteAndFechaVenta(Cliente cliente, LocalDateTime startDate, LocalDateTime endDate) {
		return repository.findVentasByClienteAndFechaVenta(cliente, startDate, endDate);
	}

	@Override
	  public List<Ventas> findVentasByCliente(String nombre, String apellido) {
	        return repository.findVentasByCliente(nombre, apellido);
	    }
	
}
