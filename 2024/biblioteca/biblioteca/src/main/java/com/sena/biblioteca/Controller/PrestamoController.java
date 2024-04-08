package com.sena.biblioteca.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.biblioteca.Entity.Prestamo;
import com.sena.biblioteca.IService.IPrestamoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/prestamo")
public class PrestamoController extends ABaseController<Prestamo, IPrestamoService>{

	protected PrestamoController(IPrestamoService service) {
		super(service, "Prestamo");
		// TODO Auto-generated constructor stub
	}

}
