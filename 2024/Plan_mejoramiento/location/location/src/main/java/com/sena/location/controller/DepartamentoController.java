package com.sena.location.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.location.IService.IDepartamentoService;
import com.sena.location.entity.Departamento;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/departamento")
public class DepartamentoController extends ABaseController<Departamento, IDepartamentoService>{

	protected DepartamentoController(IDepartamentoService service) {
		super(service, "Departamento");
		// TODO Auto-generated constructor stub
	}
	

}
