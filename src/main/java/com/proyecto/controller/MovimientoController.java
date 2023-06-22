package com.proyecto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entity.Movimiento;
import com.proyecto.service.MovimientoService;

@RestController
@RequestMapping("/rest/movimiento")
public class MovimientoController {

	@Autowired
	private MovimientoService service;

	@GetMapping("/porUsuario/{id}")
	public ResponseEntity<?> listaPorUsuario(@PathVariable("id") int idUsuario) {
		List<Movimiento> lstSalida = service.listaMovimientoPorUsuario(idUsuario);
		return ResponseEntity.ok(lstSalida);
	}

	@GetMapping()
	public ResponseEntity<?> lista() {
		List<Movimiento> lstSalida = service.listaMovimiento();
		return ResponseEntity.ok(lstSalida);
	}
	
	@PostMapping
	public ResponseEntity<?> inserta(@RequestBody Movimiento obj) {
		Movimiento objSalida = service.insertaMovimiento(obj);
		return ResponseEntity.ok(objSalida);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminaMovimiento(@PathVariable Integer id) {
		service.eliminaMovimiento(id);
		Optional<Movimiento> optMovimiento = service.buscaMovimiento(id);
		if (optMovimiento.isEmpty()) {
			return ResponseEntity.ok("Eliminación exitosa");
		}
		return ResponseEntity.ok("No existe el id " + id);
	}

	@PutMapping
	public ResponseEntity<?> actualiza(@RequestBody Movimiento obj) {
		Optional<Movimiento> optMovimiento = service.buscaMovimiento(obj.getIdMovimiento());
		if (optMovimiento.isPresent()) {
			Movimiento objSalida = service.insertaMovimiento(obj);
			return ResponseEntity.ok(objSalida);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
