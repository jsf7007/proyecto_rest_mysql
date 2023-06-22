package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.entity.Rol;
import com.proyecto.entity.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {

	@Query("select a from Movimiento a where a.idUsuario = ?1")
	public List<Movimiento>  listaMovimiento(int idUsuario);
	
}
