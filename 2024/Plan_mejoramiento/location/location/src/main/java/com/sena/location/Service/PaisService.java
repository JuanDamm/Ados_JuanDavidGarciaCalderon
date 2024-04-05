package com.sena.location.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.location.IRepository.IBaseRepository;
import com.sena.location.IRepository.IPaisRepository;
import com.sena.location.IService.IPaisService;
import com.sena.location.entity.Pais;

@Service
public class PaisService extends ABaseService<Pais> implements IPaisService{

	@Override
	protected IBaseRepository<Pais, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Override
	public void delete(Long id) {
	    repository.deleteById(id);
	}
	
	@Autowired
	private IPaisRepository repository;

	

}
