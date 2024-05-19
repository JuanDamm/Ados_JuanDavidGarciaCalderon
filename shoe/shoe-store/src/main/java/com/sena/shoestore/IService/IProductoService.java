package com.sena.shoestore.IService;

import java.util.List;

import com.sena.shoestore.Entity.Productos;

public interface IProductoService extends IBaseService<Productos>{
	
	List<Productos> getProductosName(String nombre);

}
