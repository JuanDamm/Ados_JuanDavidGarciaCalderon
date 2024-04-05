package com.sena.seguridadService;

import com.sena.seguridad.DTO.IModuleDto;
import com.sena.seguridad.DTO.IUserDto;
import com.sena.seguridad.DTO.IViewDto;
import com.sena.seguridad.Entity.User;
import com.sena.seguridad.IRepository.IBaseRepository;
import com.sena.seguridad.IRepository.IUserRepository;
import com.sena.seguridad.IService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService extends ABaseService<User> implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    protected IBaseRepository<User, Long> getRepository() {
        return userRepository;
    }

    
}
