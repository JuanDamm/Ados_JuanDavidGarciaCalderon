package com.sena.seguridadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.seguridad.Entity.Contract;
import com.sena.seguridad.Entity.Department;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.IContractR;
import com.sena.seguridad.IRepository.IDepartmentR;
import com.sena.seguridad.IService.IDepartmentService;

@Service
public class DepartmentService extends ABaseService<Department> implements IDepartmentService{

private final IDepartmentR repository;
	
	@Autowired
	public DepartmentService(IDepartmentR repository) {
		this.repository = repository;
	}
	
	@Override
	public void delete(Long id) {
	    repository.deleteById(id);
	}
	
	@Override
	protected IBaseRepository<Department, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
}
