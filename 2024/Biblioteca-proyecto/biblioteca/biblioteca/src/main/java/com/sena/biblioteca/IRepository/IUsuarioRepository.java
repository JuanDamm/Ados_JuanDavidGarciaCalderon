package com.sena.biblioteca.IRepository;

import org.springframework.stereotype.Repository;

import com.sena.biblioteca.Entity.Usuario;

@Repository
public interface IUsuarioRepository extends IBaseRepository<Usuario, Long>{

}
