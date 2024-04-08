package com.sena.biblioteca.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.biblioteca.Entity.Libro;
import com.sena.biblioteca.IRepository.IBaseRepository;
import com.sena.biblioteca.IRepository.ILibroRepository;
import com.sena.biblioteca.IService.ILibroService;
@Service
public class LibroService extends ABaseService<Libro> implements ILibroService{

	@Override
	protected IBaseRepository<Libro, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Override
	public void delete(Long id) {
	    repository.deleteById(id);
	}
	
	@Autowired
	private ILibroRepository repository;

}
