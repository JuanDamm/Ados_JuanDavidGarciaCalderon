package com.sena.biblioteca.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.biblioteca.Entity.Reserva;
import com.sena.biblioteca.IService.IReservaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/reserva")
public class ReservaController extends ABaseController<Reserva, IReservaService>{

	protected ReservaController(IReservaService service) {
		super(service, "Reserva");
		// TODO Auto-generated constructor stub
	}

}
