package com.sena.seguridad.IRepository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.seguridad.DTO.IRoleDto;
import com.sena.seguridad.Entity.Role;

@Repository
public interface IRoleRepository extends IBaseRepository<Role, Long>{

}
