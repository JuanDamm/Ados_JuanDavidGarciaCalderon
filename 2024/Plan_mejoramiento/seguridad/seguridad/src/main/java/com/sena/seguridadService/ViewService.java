package com.sena.seguridadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.seguridad.Entity.View;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.IViewR;
import com.sena.seguridad.IService.IViewService;

@Service
public class ViewService extends ABaseService<View> implements IViewService{

	@Override
	protected IBaseRepository<View, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Override
    public void delete(Long id) {
    	repository.deleteById(id);
    }
	
	@Autowired
	
	public IViewR repository;

}
