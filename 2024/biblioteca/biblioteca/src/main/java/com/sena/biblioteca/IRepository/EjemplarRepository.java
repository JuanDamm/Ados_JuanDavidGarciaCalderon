package com.sena.biblioteca.IRepository;

import org.springframework.stereotype.Repository;

import com.sena.biblioteca.Entity.Ejemplar;

@Repository
public interface EjemplarRepository extends IBaseRepository<Ejemplar, Long>{

}
