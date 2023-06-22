package com.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.entity.Movimiento;
import com.proyecto.repository.MovimientoRepository;

@Service
public class MovimientoServiceImpl implements MovimientoService {

	@Autowired
	private MovimientoRepository repository;

	@Override
	public List<Movimiento> listaMovimiento() {
		return repository.findAll();
	}

	@Override
	public Movimiento insertaMovimiento(Movimiento obj) {
		return repository.save(obj);
	}

	@Override
	public Optional<Movimiento> buscaMovimiento(int idMovimiento) {
		return repository.findById(idMovimiento);
	}

	@Override
	public void eliminaMovimiento(int idMovimiento) {
		repository.deleteById(idMovimiento);
	}

	@Override
	public List<Movimiento> listaMovimientoPorUsuario(int idUsuario) {
		return repository.listaMovimiento(idUsuario);
	}

}