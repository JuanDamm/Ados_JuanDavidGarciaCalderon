package com.sena.seguridad.Controller;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.sena.seguridad.DTO.ApiResponseDto;
import com.sena.seguridad.DTO.ICountryDto;
import com.sena.seguridad.DTO.IRoleDto;
import com.sena.seguridad.Entity.Country;
import com.sena.seguridad.IService.ICountryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/country")
public class CountryController extends ABaseController<Country,ICountryService>{
	public CountryController(ICountryService service) {
        super(service, "Country");
    }

	
	
}
