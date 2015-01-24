package com.sistema.domain;

import java.util.Date;

import com.coreweb.domain.Domain;

public class Pago extends Domain {

	private Date fecha;
	private double monto;
	private String numero;
	private String observaciones;
	private Compra compraAsociada;

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Compra getCompraAsociada() {
		return compraAsociada;
	}

	public void setCompraAsociada(Compra compraAsociada) {
		this.compraAsociada = compraAsociada;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
