package com.sena.seguridadService;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.seguridad.DTO.IViewDto;
import com.sena.seguridad.Entity.View;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.IViewRepository;
import com.sena.seguridad.IService.IViewService;

@Service
public class ViewService extends ABaseService<View> implements IViewService{

	@Override
	protected IBaseRepository<View, Long> getRepository() {
		return repository;
	}
	
	@Autowired
	private IViewRepository repository;

	
	
	
}