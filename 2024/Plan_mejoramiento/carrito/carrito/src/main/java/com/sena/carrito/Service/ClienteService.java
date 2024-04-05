package com.sena.carrito.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.carrito.Entity.Cliente;
import com.sena.carrito.IRepository.IBaseRepository;
import com.sena.carrito.IRepository.IClienteRepository;
import com.sena.carrito.IService.IClienteService;

@Service
public class ClienteService extends ABaseService<Cliente> implements IClienteService{

	
	
	@Override
	protected IBaseRepository<Cliente, Long> getRepository() {
		return repository;
	}
	
	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	@Autowired
	private IClienteRepository repository;

}
