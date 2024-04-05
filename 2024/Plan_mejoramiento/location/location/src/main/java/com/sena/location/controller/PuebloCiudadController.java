package com.sena.location.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.location.IService.IPuebloCiudadService;
import com.sena.location.entity.PuebloCiudad;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/pueblo_ciudad")
public class PuebloCiudadController extends ABaseController<PuebloCiudad, IPuebloCiudadService>{

	protected PuebloCiudadController(IPuebloCiudadService service) {
		super(service, "PuebloCiudad");
		// TODO Auto-generated constructor stub
	}

}
