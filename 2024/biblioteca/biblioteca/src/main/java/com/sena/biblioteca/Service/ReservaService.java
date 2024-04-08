package com.sena.biblioteca.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.biblioteca.Entity.Reserva;
import com.sena.biblioteca.IRepository.IBaseRepository;
import com.sena.biblioteca.IRepository.IReservaRepository;
import com.sena.biblioteca.IService.IReservaService;

@Service
public class ReservaService extends ABaseService<Reserva> implements IReservaService{

	@Override
	protected IBaseRepository<Reserva, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Override
	public void delete(Long id) {
	    repository.deleteById(id);
	}

	@Autowired
	private IReservaRepository repository;
}
