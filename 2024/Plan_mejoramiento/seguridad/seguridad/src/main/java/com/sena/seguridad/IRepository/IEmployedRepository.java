package com.sena.seguridad.IRepository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.seguridad.DTO.IEmployedDto;
import com.sena.seguridad.Entity.Employed;

@Repository
public interface IEmployedRepository extends IBaseRepository<Employed, Long>{

	
}
