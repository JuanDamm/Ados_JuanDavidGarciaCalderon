package com.sena.biblioteca.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sena.biblioteca.DTO.ILibroDto;
import com.sena.biblioteca.Entity.Libro;
import com.sena.biblioteca.IService.ILibroService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/libro")
public class LibroController extends ABaseController<Libro, ILibroService>{

	protected LibroController(ILibroService service) {
		super(service, "Libro");
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/cantidad")
	 public Integer cantidad() {
		 return service.obtenerCantidadTotalDeLibros();
	 }
	
	
	 @GetMapping("/libros")
	    public List<ILibroDto> obtenerInformacionBasica(@RequestParam(required = false) String titulo) {
	        if (titulo != null && !titulo.isEmpty()) {
	            return service.informacionBasica(titulo);
	        } else {
	            return service.informacionBasica(); 
	        }
	    }
	 
	 

}
