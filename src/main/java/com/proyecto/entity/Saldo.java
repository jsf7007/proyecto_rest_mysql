package com.proyecto.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "saldo")
public class Saldo {

	private double saldo;
	
	@Id
	@Column(name = "usuario_id")
	private int idUsuario;
}
