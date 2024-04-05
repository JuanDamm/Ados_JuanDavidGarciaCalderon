package com.sena.seguridadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.seguridad.Entity.Contract;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.ICompanyR;
import com.sena.seguridad.IRepository.IContractR;
import com.sena.seguridad.IService.IContractService;

@Service
public class ContractService extends ABaseService<Contract> implements IContractService{
	
	
private final IContractR repository;
	
	@Autowired
	public ContractService(IContractR repository) {
		this.repository = repository;
	}
	
	@Override
	public void delete(Long id) {
	    repository.deleteById(id);
	}
	
	@Override
	protected IBaseRepository<Contract, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}

}
