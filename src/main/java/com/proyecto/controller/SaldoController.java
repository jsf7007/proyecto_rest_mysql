package com.proyecto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entity.Saldo;
import com.proyecto.service.SaldoService;

@RestController
@RequestMapping("/rest/saldo")
public class SaldoController {

	@Autowired
	private SaldoService service;

	@GetMapping("/porUsuario/{id}")
	public ResponseEntity<?> listaPorUsuario(@PathVariable("id") int idUsuario) {
		List<Saldo> lstSalida = service.listaSaldoPorUsuario(idUsuario);
		return ResponseEntity.ok(lstSalida);
	}

	@GetMapping()
	public ResponseEntity<?> lista() {
		List<Saldo> lstSalida = service.listaSaldo();
		return ResponseEntity.ok(lstSalida);
	}
	
	@PostMapping
	public ResponseEntity<?> inserta(@RequestBody Saldo obj) {
		Saldo objSalida = service.insertaSaldo(obj);
		return ResponseEntity.ok(objSalida);
	}

	@PutMapping
	public ResponseEntity<?> actualiza(@RequestBody Saldo obj) {
		Optional<Saldo> optSaldo = service.buscaSaldo(obj.getIdUsuario());
		if (optSaldo.isPresent()) {
			Saldo objSalida = service.insertaSaldo(obj);
			return ResponseEntity.ok(objSalida);
		} else {
			return ResponseEntity.ok("El Saldo no existe");
		}
	}
}
