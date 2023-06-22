package com.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Rol;
import com.proyecto.repository.RolRepository;

@Service
public class RolServiceImpl implements RolService {

	@Autowired
	private RolRepository repository;

	@Override
	public List<Rol> listaRol() {
		return repository.findAll();
	}

	@Override
	public List<Rol> listaRolPorUsuario(int idUsuario) {
		return repository.listaRolPorUsuario(idUsuario);
	}


}