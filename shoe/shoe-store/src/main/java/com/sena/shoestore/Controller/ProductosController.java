package com.sena.shoestore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sena.shoestore.Entity.Productos;
import com.sena.shoestore.IService.IProductoService;
import com.sena.shoestore.Service.ProductosService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/producto")
public class ProductosController extends ABaseController<Productos, IProductoService>{

	@Autowired
	private ProductosService service;
	
	protected ProductosController(IProductoService service) {
		super(service, "Productos");
	}
	
	@GetMapping("/productos")
	public List<Productos> getProductos(@RequestParam(required = false) String nombre){
		return service.getProductosName(nombre);
	}

}
