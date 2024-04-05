package com.sena.seguridadService;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.seguridad.DTO.IModuleDto;
import com.sena.seguridad.Entity.Module;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.IModuleRepository;
import com.sena.seguridad.IService.IModuleService;

@Service
public class ModuleService extends ABaseService<Module> implements IModuleService{

	@Override
	protected IBaseRepository<Module, Long> getRepository() {
		return repository;
	}
	
	@Autowired
	private IModuleRepository repository;

}