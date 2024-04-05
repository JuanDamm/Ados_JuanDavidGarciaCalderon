package com.sena.seguridad.DTO;

import java.util.List;

public interface IEmployedDto extends IGenericDto{
	
	String getSalary();
	List<IEmployedDto> getList();
}
