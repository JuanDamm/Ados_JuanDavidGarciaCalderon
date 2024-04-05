package com.sena.location.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.location.entity.ABaseEntity;

public interface IBaseRepository<T extends ABaseEntity, ID> extends JpaRepository<T, Long>{
	
}
