package com.sena.seguridad.IRepository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.seguridad.DTO.ICityDto;
import com.sena.seguridad.Entity.City;

@Repository
public interface ICityRepository extends IBaseRepository<City, Long> {


}
