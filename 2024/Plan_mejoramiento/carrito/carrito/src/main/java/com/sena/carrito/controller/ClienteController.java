package com.sena.carrito.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.carrito.Entity.Cliente;
import com.sena.carrito.IService.IClienteService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/cliente")
public class ClienteController extends ABaseController<Cliente, IClienteService>{

	protected ClienteController(IClienteService service) {
		super(service, "Cliente");
		// TODO Auto-generated constructor stub
	}
	
	

}
