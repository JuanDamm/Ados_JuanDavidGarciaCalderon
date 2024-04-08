package com.sena.biblioteca.IRepository;

import org.springframework.stereotype.Repository;

import com.sena.biblioteca.Entity.Prestamo;

@Repository
public interface IPrestamoRepository extends IBaseRepository<Prestamo, Long>{

}
