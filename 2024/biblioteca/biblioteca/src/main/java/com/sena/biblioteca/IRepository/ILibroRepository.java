package com.sena.biblioteca.IRepository;

import org.apache.tomcat.jni.Library;
import org.springframework.stereotype.Repository;

import com.sena.biblioteca.Entity.Libro;

@Repository
public interface ILibroRepository extends IBaseRepository<Libro, Long>{

}
