package com.sistema.domain;

public class Movimiento {

	private String tipoMovimiento; // E = entrada que es compra , S = salida que
									// es venta
	private long cantidad;
	private Producto producto;
	private long idMovimiento;

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public long getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(long idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

}
