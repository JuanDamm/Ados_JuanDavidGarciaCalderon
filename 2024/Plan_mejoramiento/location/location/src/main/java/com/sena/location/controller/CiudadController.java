package com.sena.location.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.location.IService.ICiudadService;
import com.sena.location.entity.Ciudad;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/ciudad")
public class CiudadController extends ABaseController<Ciudad, ICiudadService>{

	protected CiudadController(ICiudadService service) {
		super(service, "Ciudad");
		// TODO Auto-generated constructor stub
	}

}
