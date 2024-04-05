package com.sena.seguridadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.seguridad.Entity.Role;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.IRoleR;
import com.sena.seguridad.IService.IRoleService;

@Service
public class RoleService extends ABaseService<Role> implements IRoleService{

	@Override
	protected IBaseRepository<Role, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	 @Override
	    public void delete(Long id) {
	    	repository.deleteById(id);
	    }
	
	@Autowired
	public IRoleR repository;

}
