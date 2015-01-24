package com.sistema.gestion.cobro;

import java.util.Date;

import com.coreweb.dto.DTO;
import com.sistema.gestion.venta.VentaDTO;

public class CobroDTO extends DTO {

	private Date fecha;
	private double monto;
	private String numero;
	private String observaciones;
	private VentaDTO ventaAsociada;

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

	public VentaDTO getVentaAsociada() {
		return ventaAsociada;
	}

	public void setVentaAsociada(VentaDTO ventaAsociada) {
		this.ventaAsociada = ventaAsociada;
	}

}
