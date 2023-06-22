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

import com.proyecto.entity.Rol;
import com.proyecto.service.RolService;

@RestController
@RequestMapping("/rest/rol")
public class RolController {

	@Autowired
	private RolService service;

	@GetMapping("/porUsuario/{id}")
	public ResponseEntity<?> listaPorUsuario(@PathVariable("id") int idUsuario) {
		List<Rol> lstSalida = service.listaRolPorUsuario(idUsuario);
		return ResponseEntity.ok(lstSalida);
	}

	@GetMapping()
	public ResponseEntity<?> lista() {
		List<Rol> lstSalida = service.listaRol();
		return ResponseEntity.ok(lstSalida);
	}
	
}
