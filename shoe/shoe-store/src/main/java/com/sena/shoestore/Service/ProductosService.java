package com.sena.shoestore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.shoestore.Entity.Productos;
import com.sena.shoestore.IRepository.IBaseRepository;
import com.sena.shoestore.IRepository.IProductoRepository;
import com.sena.shoestore.IService.IProductoService;

@Service
public class ProductosService extends ABaseService<Productos> implements IProductoService{

	@Autowired 
	private IProductoRepository repository;
	
	@Override
    public void delete(Long id) throws Exception {
        // TODO Auto-generated method stub
        repository.deleteById(id);
    }

	@Override
	public List<Productos> getProductosName(String nombre) {
		return repository.findByNombre(nombre);
	}

	@Override
	protected IBaseRepository<Productos, Long> getRepository() {
		return repository;
	}

}
