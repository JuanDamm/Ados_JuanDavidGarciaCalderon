package com.sena.seguridad.IService;

import java.util.Optional;

import com.sena.seguridad.DTO.UserDto;
import com.sena.seguridad.Entity.User;

public interface IUserService extends IbaseService<User> {

	// Optional<UserDto> getUserWithViews(String username, String password);
}

