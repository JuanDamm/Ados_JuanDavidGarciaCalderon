package com.sena.seguridadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.seguridad.Entity.Module;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.IModuleR;
import com.sena.seguridad.IService.IModuleService;

@Service
public class ModuleService extends ABaseService<Module> implements IModuleService {

    private final IModuleR moduleRepository;

    @Autowired
    public ModuleService(IModuleR moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    @Override
    public void delete(Long id) {
        moduleRepository.deleteById(id);
    }

    @Override
    protected IBaseRepository<Module, Long> getRepository() {
        return moduleRepository;
    }
}
