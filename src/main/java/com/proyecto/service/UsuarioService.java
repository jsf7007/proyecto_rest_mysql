package com.proyecto.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.entity.Rol;
import com.proyecto.entity.Usuario;

public interface UsuarioService {

	public List<Usuario> listaUsuario();
	
	public List<Usuario> listaUsuarioPorId(int id);

	public List<Usuario> listaUsuarioPorEmail(String email);
	
	public Usuario insertaUsuario(Usuario obj);

	public Optional<Usuario> buscaUsuario(int idUsuario);

	public void eliminaUsuario(int idUsuario);

	public abstract List<Usuario> login(String email, String password);

}
