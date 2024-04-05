package com.sena.seguridadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.seguridad.Entity.Department;
import com.sena.seguridad.Entity.Employed;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.IDepartmentR;
import com.sena.seguridad.IRepository.IEmployedR;
import com.sena.seguridad.IService.IEmployedService;

@Service
public class EmployedService extends ABaseService<Employed> implements IEmployedService{
	
private final IEmployedR repository;
	
	@Autowired
	public EmployedService(IEmployedR repository) {
		this.repository = repository;
	}
	
	@Override
	public void delete(Long id) {
	    repository.deleteById(id);
	}
	
	@Override
	protected IBaseRepository<Employed, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
}
