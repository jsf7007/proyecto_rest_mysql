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

import com.proyecto.entity.Usuario;
import com.proyecto.service.UsuarioService;

@RestController
@RequestMapping("/rest/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping("/porId/{id}")
	public ResponseEntity<?> listaPorId(@PathVariable("id") int id) {
		List<Usuario> lstSalida = service.listaUsuarioPorId(id);
		return ResponseEntity.ok(lstSalida);
	}

	@GetMapping("/porEmail/{id}")
	public ResponseEntity<?> listaPorEmail(@PathVariable("id") String email) {
		List<Usuario> lstSalida = service.listaUsuarioPorEmail(email);
		return ResponseEntity.ok(lstSalida);
	}
	
	@GetMapping("/porSesion/{email}/{pw}")
	public ResponseEntity<?> listaPorSesion(@PathVariable("email") String email, @PathVariable("pw") String pw) {
		List<Usuario> lstSalida = service.login(email, pw);
		return ResponseEntity.ok(lstSalida);
	}


	@GetMapping()
	public ResponseEntity<?> lista() {
		List<Usuario> lstSalida = service.listaUsuario();
		return ResponseEntity.ok(lstSalida);
	}
	
	@PostMapping
	public ResponseEntity<?> inserta(@RequestBody Usuario obj) {
		Usuario objSalida = service.insertaUsuario(obj);
		return ResponseEntity.ok(objSalida);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminaUsuario(@PathVariable Integer id) {
		service.eliminaUsuario(id);
		Optional<Usuario> optUsuario = service.buscaUsuario(id);
		if (optUsuario.isEmpty()) {
			return ResponseEntity.ok("Eliminación exitosa");
		}
		return ResponseEntity.ok("No existe el id " + id);
	}

	@PutMapping
	public ResponseEntity<?> actualiza(@RequestBody Usuario obj) {
		Optional<Usuario> optUsuario = service.buscaUsuario(obj.getIdUsuario());
		if (optUsuario.isPresent()) {
			Usuario objSalida = service.insertaUsuario(obj);
			return ResponseEntity.ok(objSalida);
		} else {
			return ResponseEntity.ok("El Usuario no existe");
		}
	}
}
