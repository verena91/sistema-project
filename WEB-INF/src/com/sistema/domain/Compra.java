package com.sistema.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.coreweb.domain.Domain;

public class Compra extends Domain {

	private Date fecha;
	private String numero;
	private String observacion;
	private String plazo;
	private String condicionCompra; // contado o credito
	private String tipoCompra; // proveedor o acreedor
	private ProveedorSucursal proveedorSucursal;
	private Set<CompraDetalle> compraDetalles = new HashSet<CompraDetalle>();

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getPlazo() {
		return plazo;
	}

	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}

	public String getTipoCompra() {
		return tipoCompra;
	}

	public void setTipoCompra(String tipoCompra) {
		this.tipoCompra = tipoCompra;
	}

	public String getCondicionCompra() {
		return condicionCompra;
	}

	public void setCondicionCompra(String condicionCompra) {
		this.condicionCompra = condicionCompra;
	}

	public ProveedorSucursal getProveedorSucursal() {
		return proveedorSucursal;
	}

	public void setProveedorSucursal(ProveedorSucursal proveedorSucursal) {
		this.proveedorSucursal = proveedorSucursal;
	}

	public Set<CompraDetalle> getCompraDetalles() {
		return compraDetalles;
	}

	public void setCompraDetalles(Set<CompraDetalle> compraDetalles) {
		this.compraDetalles = compraDetalles;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
