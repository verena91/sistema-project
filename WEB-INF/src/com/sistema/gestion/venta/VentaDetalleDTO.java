package com.sistema.gestion.venta;

import com.coreweb.dto.DTO;
import com.sistema.gestion.administracion.producto.ProductoDTO;

public class VentaDetalleDTO extends DTO {

	private long cantidad;
	private int descuento;
	private double precioFinal;
	private double montoExentas;
	private double montoGravadasDiez;
	private double montoGravadasCinco;
	private ProductoDTO producto;

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

	public ProductoDTO getProducto() {
		return producto;
	}

	public void setProducto(ProductoDTO producto) {
		this.producto = producto;
	}

}
