package com.sena.biblioteca.IService;

import java.util.List;

import com.sena.biblioteca.DTO.IPrestamoDto;
import com.sena.biblioteca.Entity.Prestamo;

public interface IPrestamoService extends IBaseService<Prestamo>{
	
	List<Prestamo> obtenerPrestamosConInformacionCompleta();
}
