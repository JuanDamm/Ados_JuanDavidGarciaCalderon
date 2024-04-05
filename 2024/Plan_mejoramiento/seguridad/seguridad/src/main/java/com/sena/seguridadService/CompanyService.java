package com.sena.seguridadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.seguridad.Entity.Company;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.ICompanyR;
import com.sena.seguridad.IService.ICompanyService;

@Service
public class CompanyService extends ABaseService<Company> implements ICompanyService{

	private final ICompanyR repository;
	
	@Autowired
	public CompanyService(ICompanyR repository) {
		this.repository = repository;
	}
	
	@Override
	public void delete(Long id) {
	    repository.deleteById(id);
	}

	@Override
	protected IBaseRepository<Company, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
}
