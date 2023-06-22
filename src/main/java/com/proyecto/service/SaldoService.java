package com.proyecto.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.entity.Saldo;

public interface SaldoService {

	public List<Saldo> listaSaldo();

	public List<Saldo> listaSaldoPorUsuario(int idUsuario);
	
	public Saldo insertaSaldo(Saldo obj);

	public Optional<Saldo> buscaSaldo(int idUsuario);

}
