package com.sena.biblioteca.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.biblioteca.DTO.ILibroDto;
import com.sena.biblioteca.Entity.Libro;
import com.sena.biblioteca.IRepository.IBaseRepository;
import com.sena.biblioteca.IRepository.ILibroRepository;
import com.sena.biblioteca.IService.ILibroService;
@Service
public class LibroService extends ABaseService<Libro> implements ILibroService{

	@Override
	protected IBaseRepository<Libro, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Override
	public void delete(Long id) {
	    repository.deleteById(id);
	}
	
	@Autowired
	private ILibroRepository repository;

	 @Override
	    public List<ILibroDto> informacionBasica(String titulo) {
	        if (titulo != null && !titulo.isEmpty()) {
	            return repository.getInformacionBasica(titulo);
	        } else {
	            // Aquí implementa la lógica para manejar el caso en el que no se proporciona ningún título
	            // Por ejemplo, podrías devolver la información básica de todos los libros
	            return repository.getInformacionBasicaTodos();
	        }
	    }

	    // Este método es opcional, puedes usar el que se proporciona en ILibroRepository
	    public List<ILibroDto> informacionBasica() {
	        return repository.getInformacionBasicaTodos();
	    }

	    @Override
	    public Integer obtenerCantidadTotalDeLibros() {
	        // Utiliza el repositorio para obtener la cantidad total de libros
	        return repository.getTotalLibrosDisponibles();
	       
	    }
	}


