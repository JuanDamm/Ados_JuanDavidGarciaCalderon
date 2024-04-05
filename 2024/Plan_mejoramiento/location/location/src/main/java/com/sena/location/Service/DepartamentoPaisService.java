package com.sena.location.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.location.IRepository.IBaseRepository;
import com.sena.location.IRepository.IDepartamentoPaisRepository;
import com.sena.location.IService.IDepartamentoPaisService;
import com.sena.location.entity.DepartamentoPais;

@Service
public class DepartamentoPaisService extends ABaseService<DepartamentoPais> implements IDepartamentoPaisService{

	 private final IDepartamentoPaisRepository repository;

	    @Autowired
	    public DepartamentoPaisService(IDepartamentoPaisRepository repository) {
	        this.repository = repository;
	    }

	    @Override
		public void delete(Long id) {
		    repository.deleteById(id);
		}
	    
	    @Override
	    protected IBaseRepository<DepartamentoPais, Long> getRepository() {
	        return repository;
	    }
	}
