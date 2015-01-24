package com.sistema.domain;

import com.coreweb.domain.Domain;
import com.coreweb.domain.Tipo;

public class Producto extends Domain {

	private String codigo;
	private String descripcion;
	private String imagen;
	private Presentacion presentacion;
	private Tipo unidadDeMedida;
	private Familia familia;
	private double costo;
	private double precio;
	private long cantidad;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Tipo getUnidadDeMedida() {
		return unidadDeMedida;
	}

	public void setUnidadDeMedida(Tipo unidadDeMedida) {
		this.unidadDeMedida = unidadDeMedida;
	}

	public Presentacion getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(Presentacion presentacion) {
		this.presentacion = presentacion;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
