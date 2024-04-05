package com.sena.seguridad.IRepository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.seguridad.DTO.IModuleDto;
import com.sena.seguridad.DTO.IUserDto;
import com.sena.seguridad.DTO.IViewDto;
import com.sena.seguridad.Entity.User;

@Repository
public interface IUserRepository extends IBaseRepository<User, Long> {

  

    
    

}
