package com.sena.biblioteca.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.biblioteca.Entity.Usuario;
import com.sena.biblioteca.IService.IUsuarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/usuario")
public class UsuarioController extends ABaseController<Usuario, IUsuarioService>{

	protected UsuarioController(IUsuarioService service) {
		super(service, "Usuario");
		// TODO Auto-generated constructor stub
	}

}
