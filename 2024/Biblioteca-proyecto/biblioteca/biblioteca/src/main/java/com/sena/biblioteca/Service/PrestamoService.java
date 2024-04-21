package com.sena.biblioteca.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.biblioteca.Entity.Prestamo;
import com.sena.biblioteca.IRepository.IBaseRepository;
import com.sena.biblioteca.IRepository.IPrestamoRepository;
import com.sena.biblioteca.IService.IPrestamoService;

@Service
public class PrestamoService extends ABaseService<Prestamo> implements IPrestamoService{

	@Override
	protected IBaseRepository<Prestamo, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Override
	public void delete(Long id) {
	    repository.deleteById(id);
	}
	
	@Autowired
	private IPrestamoRepository repository;
	
	@Override
    public List<Prestamo> obtenerPrestamosConInformacionCompleta() {
        return repository.findAllPrestamos();
    }
}
