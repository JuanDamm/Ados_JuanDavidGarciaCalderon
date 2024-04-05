package com.sena.location.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.location.IService.ICiudadDepartamentoService;
import com.sena.location.entity.CiudadDepartamento;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/ciudad_departamento")
public class CiudadDepartamentoController extends ABaseController<CiudadDepartamento, ICiudadDepartamentoService>{

	protected CiudadDepartamentoController(ICiudadDepartamentoService service) {
		super(service, "CiudadDepartamento");
		// TODO Auto-generated constructor stub
	}

}
