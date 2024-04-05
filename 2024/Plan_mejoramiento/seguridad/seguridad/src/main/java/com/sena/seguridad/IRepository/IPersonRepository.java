package com.sena.seguridad.IRepository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.seguridad.DTO.IPersonDto;
import com.sena.seguridad.Entity.Person;


@Repository
public interface IPersonRepository extends IBaseRepository<Person, Long>{

}
