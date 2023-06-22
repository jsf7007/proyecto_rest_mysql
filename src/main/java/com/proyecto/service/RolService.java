package com.proyecto.service;

import java.util.List;

import com.proyecto.entity.Rol;

public interface RolService {

	public List<Rol> listaRol();

	public List<Rol> listaRolPorUsuario(int idUsuario);

}
