package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.entity.Rol;
import com.proyecto.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query("select a from Usuario a where a.email = ?1")
	public List<Usuario> listaUsuario(String email);

	@Query("select a from Usuario a where a.idUsuario = ?1")
	public List<Usuario> listaUsuarioPorId(int id);
	
	@Query("Select x from Usuario x where x.email = ?1 and x.password = ?2")
	public abstract List<Usuario> login(String email, String password);
	
}
