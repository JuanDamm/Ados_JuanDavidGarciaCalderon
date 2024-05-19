package com.sena.shoestore.IService;

import java.util.List;

import com.sena.shoestore.Entity.Cliente;

public interface IClienteService extends IBaseService<Cliente> {
    List<Cliente> getClientesByNombreCiudadEstado(String nombre, String ciudad);
}

