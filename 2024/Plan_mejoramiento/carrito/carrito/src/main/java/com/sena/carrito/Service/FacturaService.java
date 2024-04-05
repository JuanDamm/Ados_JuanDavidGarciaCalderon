package com.sena.carrito.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.carrito.Entity.Factura;
import com.sena.carrito.IRepository.IBaseRepository;
import com.sena.carrito.IRepository.IFacturaRepository;
import com.sena.carrito.IService.IFacturaService;


@Service
public class FacturaService extends ABaseService<Factura> implements IFacturaService{


    private final IFacturaRepository repository;

    @Autowired
    public FacturaService(IFacturaRepository repository) {
        this.repository = repository;
    }

    @Override
    protected IBaseRepository<Factura, Long> getRepository() {
        return repository;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
