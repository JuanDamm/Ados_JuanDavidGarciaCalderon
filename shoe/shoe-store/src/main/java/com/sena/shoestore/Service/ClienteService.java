package com.sena.shoestore.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.shoestore.Entity.Cliente;
import com.sena.shoestore.IRepository.IBaseRepository;
import com.sena.shoestore.IRepository.IClienteRepository;
import com.sena.shoestore.IService.IClienteService;

@Service
public class ClienteService extends ABaseService<Cliente> implements IClienteService{

	@Autowired
	private IClienteRepository repository;
	
	@Override
	protected IBaseRepository<Cliente, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}

	public Optional<Cliente> findById(Long id) {
        return repository.findById(id);
    }
	
	@Override
    public void delete(Long id) throws Exception {
        // TODO Auto-generated method stub
        repository.deleteById(id);
    }

	@Override
	public List<Cliente> getClientesByNombreCiudadEstado(String nombre, String ciudad) {
		// TODO Auto-generated method stub
		return repository.findByNombreCiudadEstado(nombre, ciudad);
	}
	
}
