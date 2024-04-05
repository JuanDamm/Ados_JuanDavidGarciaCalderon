package com.sena.location.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.location.IRepository.IBaseRepository;
import com.sena.location.IRepository.IPuebloRepository;
import com.sena.location.IService.IPuebloService;
import com.sena.location.entity.Pueblo;

@Service
public class PuebloService extends ABaseService<Pueblo> implements IPuebloService{

	@Override
	protected IBaseRepository<Pueblo, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Override
	public void delete(Long id) {
	    repository.deleteById(id);
	}
	
	@Autowired
	private IPuebloRepository repository;

}
