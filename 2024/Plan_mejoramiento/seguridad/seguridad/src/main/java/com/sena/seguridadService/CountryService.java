package com.sena.seguridadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.seguridad.Entity.Country;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.ICountryR;
import com.sena.seguridad.IService.ICountryService;

@Service
public class CountryService extends ABaseService<Country> implements ICountryService{

	@Override
	protected IBaseRepository<Country, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Override
	public void delete(Long id) {
	    repository.deleteById(id);
	}
	
	@Autowired
	
	public ICountryR repository;

}
