package com.sena.seguridad.IRepository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.seguridad.DTO.IViewDto;
import com.sena.seguridad.Entity.View;

@Repository
public interface IViewRepository extends IBaseRepository<View, Long>{


}
