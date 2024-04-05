package com.sena.location.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.location.IRepository.IBaseRepository;
import com.sena.location.IRepository.IDepartamentoRepository;
import com.sena.location.IService.IDepartamentoService;
import com.sena.location.entity.Departamento;

@Service
public class DepartamentoService extends ABaseService<Departamento> implements IDepartamentoService{

	@Override
	protected IBaseRepository<Departamento, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Override
	public void delete(Long id) {
	    repository.deleteById(id);
	}
	
	@Autowired
	private IDepartamentoRepository repository;

}
