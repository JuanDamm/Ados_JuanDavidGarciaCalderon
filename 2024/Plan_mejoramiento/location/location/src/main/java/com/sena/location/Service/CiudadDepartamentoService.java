package com.sena.location.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.location.IRepository.IBaseRepository;
import com.sena.location.IRepository.ICiudadDepartamentoRepository;
import com.sena.location.IService.ICiudadDepartamentoService;
import com.sena.location.entity.CiudadDepartamento;

@Service
public class CiudadDepartamentoService extends ABaseService<CiudadDepartamento> implements ICiudadDepartamentoService{

	 private final ICiudadDepartamentoRepository repository;

	    @Autowired
	    public CiudadDepartamentoService(ICiudadDepartamentoRepository repository) {
	        this.repository = repository;
	    }

	    @Override
		public void delete(Long id) {
		    repository.deleteById(id);
		}
	    
	    @Override
	    protected IBaseRepository<CiudadDepartamento, Long> getRepository() {
	        return repository;
	    }
	}
