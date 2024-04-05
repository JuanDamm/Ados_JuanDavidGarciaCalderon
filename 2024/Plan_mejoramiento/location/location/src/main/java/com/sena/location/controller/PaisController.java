package com.sena.location.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.location.IService.IPaisService;
import com.sena.location.entity.Pais;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/pais")
public class PaisController extends ABaseController<Pais, IPaisService>{

	protected PaisController(IPaisService service) {
		super(service, "Pais");
		// TODO Auto-generated constructor stub
	}

}
