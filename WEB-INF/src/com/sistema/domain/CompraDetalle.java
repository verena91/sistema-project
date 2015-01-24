package com.sistema.domain;

import com.coreweb.domain.Domain;

public class CompraDetalle extends Domain {

	private long cantidad;
	private double costoFinal;
	private double montoExentas;
	private double montoGravadasDiez;
	private double montoGravadasCinco;
	private Producto producto; // para cuando es proveedor
	private String descripcion; // para cuando es acreedor

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

	public double getCostoFinal() {
		return costoFinal;
	}

	public void setCostoFinal(double costoFinal) {
		this.costoFinal = costoFinal;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
