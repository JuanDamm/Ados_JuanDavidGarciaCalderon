package com.sena.seguridad.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.seguridad.Entity.User;
import com.sena.seguridad.IService.IUserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/user")
public class UserController extends ABaseController<User, IUserService> {
	
	protected UserController(IUserService service) {
		super(service, "User");
	}
	
	

}
