package com.sena.seguridadService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.seguridad.DTO.UserDto;
import com.sena.seguridad.Entity.User;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.IUserR;
import com.sena.seguridad.IService.IUserService;

@Service
public class UserServicee extends ABaseService<User> implements IUserService{

    private final IUserR repository;

    @Autowired
    public UserServicee(IUserR repository) {
        this.repository = repository;
    }
    
    @Override
    public void delete(Long id) {
    	repository.deleteById(id);
    }

    @Override
    protected IBaseRepository<User, Long> getRepository() {
        return repository;
    }

    /*
	@Override
	public Optional<UserDto> getUserWithViews(String username, String password) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
*/
	
}
