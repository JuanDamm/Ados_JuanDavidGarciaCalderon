package com.sena.seguridad.Controller;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.sena.seguridad.DTO.ApiResponseDto;
import com.sena.seguridad.DTO.IDepartmentDto;
import com.sena.seguridad.Entity.Department;
import com.sena.seguridad.IService.IDepartmentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/department")
public class DepartmentController extends ABaseController<Department,IDepartmentService>{
	public DepartmentController(IDepartmentService service) {
        super(service, "Department");
    }
	


}
