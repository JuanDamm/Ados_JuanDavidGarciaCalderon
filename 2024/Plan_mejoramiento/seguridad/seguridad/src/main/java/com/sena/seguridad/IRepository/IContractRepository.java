package com.sena.seguridad.IRepository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.seguridad.DTO.IContractDto;
import com.sena.seguridad.Entity.Contract;

@Repository
public interface IContractRepository extends IBaseRepository<Contract, Long>{

	
}
