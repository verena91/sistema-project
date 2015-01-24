package com.sistema.gestion.compra;

import com.coreweb.dto.DTO;
import com.sistema.gestion.administracion.producto.ProductoDTO;

public class CompraDetalleDTO extends DTO {

	private long cantidad;
	private double costoFinal;
	private double montoExentas;
	private double montoGravadasDiez;
	private double montoGravadasCinco;
	private ProductoDTO producto;
	private String descripcion;

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

	public ProductoDTO getProducto() {
		return producto;
	}

	public void setProducto(ProductoDTO producto) {
		this.producto = producto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
