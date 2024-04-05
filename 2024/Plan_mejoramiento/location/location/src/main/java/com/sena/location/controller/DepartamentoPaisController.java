package com.sena.location.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.location.IService.IDepartamentoPaisService;
import com.sena.location.entity.DepartamentoPais;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/departamento_pais")
public class DepartamentoPaisController extends ABaseController<DepartamentoPais, IDepartamentoPaisService>{

	protected DepartamentoPaisController(IDepartamentoPaisService service) {
		super(service, "DepartamentoPais");
		// TODO Auto-generated constructor stub
	}

}
