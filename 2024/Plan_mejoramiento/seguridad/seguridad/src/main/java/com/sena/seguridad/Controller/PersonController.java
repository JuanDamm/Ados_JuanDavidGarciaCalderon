package com.sena.seguridad.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.seguridad.Entity.Person;
import com.sena.seguridad.IService.IPersonService;

@CrossOrigin (origins = "*")
@RestController
@RequestMapping("v1/api/person")
public class PersonController extends ABaseController<Person, IPersonService>{

	protected PersonController(IPersonService service) {
		super(service, "Person");
		// TODO Auto-generated constructor stub
	}

}
