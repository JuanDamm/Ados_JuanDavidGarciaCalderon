package com.sena.seguridadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sena.seguridad.Entity.City;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.ICityRepository;
import com.sena.seguridad.IService.ICityService;

@Service
public class CityService extends ABaseService<City> implements ICityService{

    private final ICityRepository repository;
    
    @Autowired
    public CityService(ICityRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    protected IBaseRepository<City, Long> getRepository() {
        return repository;
    }
}
