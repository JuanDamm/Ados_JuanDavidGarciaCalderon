package com.sena.seguridad.Controller;

import java.util.List;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.sena.seguridad.DTO.ApiResponseDto;
import com.sena.seguridad.DTO.IModuleDto;

import com.sena.seguridad.Entity.Module;
import com.sena.seguridad.IService.IModuleService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/module")
public class ModuleController extends ABaseController<Module,IModuleService>{
	public ModuleController(IModuleService service) {
        super(service, "Module");
    }
	
	
}
