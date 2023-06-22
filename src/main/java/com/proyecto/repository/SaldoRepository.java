package com.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entity.Saldo;

public interface SaldoRepository extends JpaRepository<Saldo, Integer> {

	@Query("select a from Saldo a where a.idUsuario = ?1")
	public List<Saldo> listaSaldoPorUsuario(int idUsuario);
	
}
