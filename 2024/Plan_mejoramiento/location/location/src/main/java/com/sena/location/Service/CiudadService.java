package com.sena.location.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.location.IRepository.IBaseRepository;
import com.sena.location.IRepository.ICiudadRepository;
import com.sena.location.IService.ICiudadService;
import com.sena.location.entity.Ciudad;

@Service
public class CiudadService extends ABaseService<Ciudad> implements ICiudadService{

	@Override
	protected IBaseRepository<Ciudad, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Override
	public void delete(Long id) {
	    repository.deleteById(id);
	}
	
	@Autowired
	private ICiudadRepository repository;

}
