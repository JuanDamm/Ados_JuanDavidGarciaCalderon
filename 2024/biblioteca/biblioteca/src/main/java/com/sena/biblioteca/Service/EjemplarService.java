package com.sena.biblioteca.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.biblioteca.Entity.Ejemplar;
import com.sena.biblioteca.IRepository.EjemplarRepository;
import com.sena.biblioteca.IRepository.IBaseRepository;
import com.sena.biblioteca.IService.IEjemplarService;

@Service
public class EjemplarService extends ABaseService<Ejemplar> implements IEjemplarService{

	@Override
	protected IBaseRepository<Ejemplar, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Override
	public void delete(Long id) {
	    repository.deleteById(id);
	}
	
	@Autowired
	private EjemplarRepository repository;
}
