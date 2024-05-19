package com.sena.shoestore.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sena.shoestore.Entity.Cliente;
import com.sena.shoestore.IService.IClienteService;
import com.sena.shoestore.Service.ClienteService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/cliente")
public class ClienteController extends ABaseController<Cliente, IClienteService>{
	
	@Autowired
    private ClienteService clienteService;

	
	protected ClienteController(IClienteService service) {
		super(service, "Cliente");
		
	}
	
	@GetMapping("/clientes")
    public List<Cliente> getClientes(@RequestParam(required = false) String nombre, @RequestParam(required = false) String ciudad) {
        return clienteService.getClientesByNombreCiudadEstado(nombre, ciudad);
        
	}
}
