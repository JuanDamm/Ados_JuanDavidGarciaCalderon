package com.sena.location.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.location.IRepository.IBaseRepository;
import com.sena.location.IRepository.IPuebloCiudadRepository;
import com.sena.location.IService.IPuebloCiudadService;
import com.sena.location.entity.PuebloCiudad;

@Service
public class PuebloCiudadService extends ABaseService<PuebloCiudad> implements IPuebloCiudadService{

	 private final IPuebloCiudadRepository repository;

	    @Autowired
	    public PuebloCiudadService(IPuebloCiudadRepository repository) {
	        this.repository = repository;
	    }

	    @Override
		public void delete(Long id) {
		    repository.deleteById(id);
		}
	    
	    @Override
	    protected IBaseRepository<PuebloCiudad, Long> getRepository() {
	        return repository;
	    }
	}
