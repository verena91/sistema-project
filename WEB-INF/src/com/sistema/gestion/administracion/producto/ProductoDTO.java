package com.sistema.gestion.administracion.producto;

import com.coreweb.dto.DTO;
import com.coreweb.util.MyArray;
import com.coreweb.util.MyPair;

public class ProductoDTO extends DTO {

	private String codigo;
	private String descripcion;
	private String imagen = "";
	private MyArray presentacion = new MyArray();
	private MyPair unidadDeMedida = new MyPair();
	private MyArray familia = new MyArray();
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

	public MyPair getUnidadDeMedida() {
		return unidadDeMedida;
	}

	public void setUnidadDeMedida(MyPair unidadDeMedida) {
		this.unidadDeMedida = unidadDeMedida;
	}

	public MyArray getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(MyArray presentacion) {
		this.presentacion = presentacion;
	}

	public MyArray getFamilia() {
		return familia;
	}

	public void setFamilia(MyArray familia) {
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}
