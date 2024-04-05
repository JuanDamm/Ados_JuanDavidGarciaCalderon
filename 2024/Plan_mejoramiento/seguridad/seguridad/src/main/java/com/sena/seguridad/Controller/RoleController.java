package com.sena.seguridad.Controller;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.seguridad.DTO.ApiResponseDto;
import com.sena.seguridad.DTO.IRoleDto;
import com.sena.seguridad.Entity.Role;
import com.sena.seguridad.IService.IRoleService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/role")
public class RoleController extends ABaseController<Role,IRoleService>{
	public RoleController(IRoleService service) {
        super(service, "Role");
    }
	
	
}
