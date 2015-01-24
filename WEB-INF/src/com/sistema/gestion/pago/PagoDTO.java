package com.sistema.gestion.pago;

import java.util.Date;

import com.coreweb.dto.DTO;
import com.sistema.gestion.compra.CompraDTO;

public class PagoDTO extends DTO {

	private Date fecha;
	private double monto;
	private String numero;
	private String observaciones;
	private CompraDTO compraAsociada;

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

	public CompraDTO getCompraAsociada() {
		return compraAsociada;
	}

	public void setCompraAsociada(CompraDTO compraAsociada) {
		this.compraAsociada = compraAsociada;
	}

}
