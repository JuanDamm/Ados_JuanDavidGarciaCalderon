package com.sena.seguridad.IRepository;

import org.springframework.stereotype.Repository;

import com.sena.seguridad.Entity.User;


@Repository
public interface IUserR extends IBaseRepository<User, Long>{

	
}
