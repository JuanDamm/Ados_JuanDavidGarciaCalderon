package com.sena.seguridad.IRepository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.seguridad.DTO.IDepartmentDto;
import com.sena.seguridad.Entity.Department;
 @Repository
public interface IDepartmentRepository extends IBaseRepository<Department, Long>{


}
