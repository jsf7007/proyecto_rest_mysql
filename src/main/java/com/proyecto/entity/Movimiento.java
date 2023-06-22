package com.proyecto.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "movimiento")
public class Movimiento {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_movimiento")
	private int idMovimiento;

	@Column(name = "fecha_movimiento")
	private Date fechaMovimiento;

	@Column(name = "id")
	private int idUsuario;

	@Column(name = "id_cuenta_bancaria")
	private int idCuentaBancaria;

	@Column(name = "monto")
	private double monto;

	@Column(name = "tipo_movimiento")
	private String tipoMovimiento;
	
}
