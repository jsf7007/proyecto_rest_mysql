package com.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Saldo;
import com.proyecto.repository.SaldoRepository;

@Service
public class SaldoServiceImpl implements SaldoService {

	@Autowired
	private SaldoRepository repository;

	@Override
	public List<Saldo> listaSaldo() {
		return repository.findAll();
	}

	@Override
	public Saldo insertaSaldo(Saldo obj) {
		return repository.save(obj);
	}

	@Override
	public Optional<Saldo> buscaSaldo(int idSaldo) {
		return repository.findById(idSaldo);
	}

	@Override
	public List<Saldo> listaSaldoPorUsuario(int idUsuario) {
		return repository.listaSaldoPorUsuario(idUsuario);
	}


}