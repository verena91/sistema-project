package com.sistema.domain;

import com.coreweb.domain.Domain;

public class VentaDetalle extends Domain {

	private long cantidad;
	private int descuento;
	private double precioFinal;
	private double montoExentas;
	private double montoGravadasDiez;
	private double montoGravadasCinco;
	private Producto producto;

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public double getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(double precioFinal) {
		this.precioFinal = precioFinal;
	}

	public double getMontoExentas() {
		return montoExentas;
	}

	public void setMontoExentas(double montoExentas) {
		this.montoExentas = montoExentas;
	}

	public double getMontoGravadasDiez() {
		return montoGravadasDiez;
	}

	public void setMontoGravadasDiez(double montoGravadasDiez) {
		this.montoGravadasDiez = montoGravadasDiez;
	}

	public double getMontoGravadasCinco() {
		return montoGravadasCinco;
	}

	public void setMontoGravadasCinco(double montoGravadasCinco) {
		this.montoGravadasCinco = montoGravadasCinco;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
