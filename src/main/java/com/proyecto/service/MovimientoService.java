package com.proyecto.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.entity.Movimiento;

public interface MovimientoService {

	public List<Movimiento> listaMovimiento();

	public List<Movimiento> listaMovimientoPorUsuario(int idUsuario);
	
	public Movimiento insertaMovimiento(Movimiento obj);

	public Optional<Movimiento> buscaMovimiento(int idMovimiento);

	public void eliminaMovimiento(int idMovimiento);

}
