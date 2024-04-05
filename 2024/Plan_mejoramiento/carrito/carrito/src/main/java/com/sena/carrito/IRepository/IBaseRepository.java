package com.sena.carrito.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.carrito.Entity.ABaseEntity;

public interface IBaseRepository<T extends ABaseEntity, ID> extends JpaRepository<T, Long>{

}
