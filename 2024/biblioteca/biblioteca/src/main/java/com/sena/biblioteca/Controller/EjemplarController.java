package com.sena.biblioteca.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.biblioteca.Entity.Ejemplar;
import com.sena.biblioteca.IService.IEjemplarService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/ejemplar")
public class EjemplarController extends ABaseController<Ejemplar, IEjemplarService>{

	protected EjemplarController(IEjemplarService service) {
		super(service, "Ejemplar");
		// TODO Auto-generated constructor stub
	}

}
