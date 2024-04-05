package com.sena.seguridad.Controller;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.sena.seguridad.DTO.ApiResponseDto;
import com.sena.seguridad.DTO.ICityDto;
import com.sena.seguridad.DTO.IPersonDto;
import com.sena.seguridad.Entity.City;
import com.sena.seguridad.IService.ICityService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/city")
public class CityController extends ABaseController<City,ICityService>{
	public CityController(ICityService service) {
        super(service, "City");
    }

	

}
