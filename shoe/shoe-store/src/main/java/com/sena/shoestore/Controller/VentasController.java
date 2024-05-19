package com.sena.shoestore.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sena.shoestore.Entity.Cliente;
import com.sena.shoestore.Entity.Ventas;
import com.sena.shoestore.IService.IVentasService;
import com.sena.shoestore.Service.ClienteService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/ventas")
public class VentasController extends ABaseController<Ventas, IVentasService>{
	
	@Autowired
	private ClienteService clienteService;
	
	protected VentasController(IVentasService service) {
		super(service, "Ventas");
	}
	

	
	@GetMapping("/ventasPorCliente")
	public List<Ventas> filtrarVentasPorCliente(
	        @RequestParam(required = false) String nombre,
	        @RequestParam(required = false) String apellido
	        
	    ) {
	        // Lógica para filtrar ventas por nombre y apellido
	        return service.findVentasByCliente(nombre, apellido);
	    }
	
}
