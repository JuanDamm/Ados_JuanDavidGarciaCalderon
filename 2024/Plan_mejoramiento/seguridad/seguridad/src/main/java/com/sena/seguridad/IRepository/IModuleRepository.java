package com.sena.seguridad.IRepository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;

import com.sena.seguridad.DTO.IModuleDto;
import com.sena.seguridad.Entity.Module;

public interface IModuleRepository extends IBaseRepository<Module, Long>{

	
}
