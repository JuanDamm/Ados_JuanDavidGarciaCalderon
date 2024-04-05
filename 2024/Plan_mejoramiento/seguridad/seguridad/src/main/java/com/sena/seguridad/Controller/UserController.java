package com.sena.seguridad.Controller;

import java.util.List;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sena.seguridad.DTO.ApiResponseDto;
import com.sena.seguridad.DTO.IUserDto;
import com.sena.seguridad.Entity.User;
import com.sena.seguridad.IService.IUserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/user")
public class UserController extends ABaseController<User,IUserService>{
	public UserController(IUserService service) {
        super(service, "User");
    }
	
	
	
	

	
}
