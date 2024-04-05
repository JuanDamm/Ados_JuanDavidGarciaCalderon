package com.sena.carrito.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.carrito.Entity.Factura;
import com.sena.carrito.IService.IFacturaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/factura")
public class FacturaController extends ABaseController<Factura, IFacturaService>{

	protected FacturaController(IFacturaService service) {
		super(service, "Factura");
		// TODO Auto-generated constructor stub
	}

}
