package com.sena.seguridad.IRepository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.seguridad.DTO.ICountryDto;
import com.sena.seguridad.Entity.Country;
@Repository
public interface ICountryRepository extends IBaseRepository<Country, Long> {


}
