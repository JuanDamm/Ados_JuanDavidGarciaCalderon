package com.sena.seguridad.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.seguridad.Entity.Department;
import com.sena.seguridad.IService.IDepartmentService;

@CrossOrigin (origins = "*")
@RestController
@RequestMapping("v1/api/department")
public class DepartmentController extends ABaseController<Department, IDepartmentService>{

	protected DepartmentController(IDepartmentService service) {
		super(service, "Deparment");
		// TODO Auto-generated constructor stub
	}

}
