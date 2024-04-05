package com.sena.carrito.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.carrito.Entity.Producto;
import com.sena.carrito.IRepository.IBaseRepository;
import com.sena.carrito.IRepository.IProductoRepository;
import com.sena.carrito.IService.IProductoService;


@Service
public class ProductoService extends ABaseService<Producto> implements IProductoService{

	@Override
	protected IBaseRepository<Producto, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	@Autowired
	private IProductoRepository repository;

}
