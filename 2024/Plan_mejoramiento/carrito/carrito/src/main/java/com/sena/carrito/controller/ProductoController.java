package com.sena.carrito.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.carrito.Entity.Producto;
import com.sena.carrito.IService.IProductoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/producto")
public class ProductoController extends ABaseController<Producto, IProductoService>{

	protected ProductoController(IProductoService service) {
		super(service, "Producto");
		// TODO Auto-generated constructor stub
	}

}
