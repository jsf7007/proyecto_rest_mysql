package com.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Rol;
import com.proyecto.entity.Usuario;
import com.proyecto.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public List<Usuario> listaUsuario() {
		return repository.findAll();
	}

	@Override
	public Usuario insertaUsuario(Usuario obj) {
		return repository.save(obj);
	}

	@Override
	public Optional<Usuario> buscaUsuario(int idUsuario) {
		return repository.findById(idUsuario);
	}

	@Override
	public void eliminaUsuario(int idUsuario) {
		repository.deleteById(idUsuario);
	}

	@Override
	public List<Usuario> listaUsuarioPorEmail(String email) {
		return repository.listaUsuario(email);
	}
	
	@Override
	public List<Usuario> listaUsuarioPorId(int id){
		return repository.listaUsuarioPorId(id);
	}

	@Override
	public List<Usuario> login(String email, String password) {
		return repository.login(email, password);
	}
	
}