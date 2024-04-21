package com.sena.biblioteca.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.biblioteca.Entity.Usuario;
import com.sena.biblioteca.IRepository.IBaseRepository;
import com.sena.biblioteca.IRepository.IUsuarioRepository;
import com.sena.biblioteca.IService.IUsuarioService;

@Service
public class UsuarioService extends ABaseService<Usuario> implements IUsuarioService{

	@Override
	protected IBaseRepository<Usuario, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Override
	public void delete(Long id) {
	    repository.deleteById(id);
	}
	
	@Autowired
	private IUsuarioRepository repository;

}
