package com.sena.seguridadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.seguridad.Entity.Module;
import com.sena.seguridad.Entity.Person;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.IModuleR;
import com.sena.seguridad.IRepository.IPersonR;
import com.sena.seguridad.IService.IPersonService;

@Service
public class PersonService extends ABaseService<Person> implements IPersonService{

	private final IPersonR repository;

    @Autowired
    public PersonService(IPersonR repository) {
        this.repository = repository;
    }

    @Override
    public void delete(Long id) {
    	repository.deleteById(id);
    }

    @Override
    protected IBaseRepository<Person, Long> getRepository() {
        return repository;
    }
}
