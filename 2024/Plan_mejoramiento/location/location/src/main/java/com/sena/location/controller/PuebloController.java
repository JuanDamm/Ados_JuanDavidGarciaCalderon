package com.sena.location.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.location.IService.IPuebloService;
import com.sena.location.entity.Pueblo;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/pueblo")
public class PuebloController extends ABaseController<Pueblo, IPuebloService>{

	protected PuebloController(IPuebloService service) {
		super(service, "Pueblo");
		// TODO Auto-generated constructor stub
	}

}
