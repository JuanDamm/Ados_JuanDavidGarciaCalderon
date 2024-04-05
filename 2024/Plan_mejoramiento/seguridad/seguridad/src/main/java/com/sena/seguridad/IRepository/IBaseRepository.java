package com.sena.seguridad.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.seguridad.Entity.ABaseEntity;

public interface IBaseRepository<T extends ABaseEntity, ID> extends JpaRepository<T, Long>{
	
}
