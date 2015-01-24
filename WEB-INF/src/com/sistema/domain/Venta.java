package com.sistema.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.coreweb.domain.Domain;

public class Venta extends Domain {

	private Date fecha;
	private String numero;
	private String observacion;
	private String plazo;
	private String condicionVenta; // contado o credito
	private ClienteSucursal clienteSucursal;
	private Set<VentaDetalle> ventaDetalles = new HashSet<VentaDetalle>();

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

	public Set<VentaDetalle> getVentaDetalles() {
		return ventaDetalles;
	}

	public void setVentaDetalles(Set<VentaDetalle> ventaDetalles) {
		this.ventaDetalles = ventaDetalles;
	}

	public String getPlazo() {
		return plazo;
	}

	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}

	public String getCondicionVenta() {
		return condicionVenta;
	}

	public void setCondicionVenta(String condicionVenta) {
		this.condicionVenta = condicionVenta;
	}

	public ClienteSucursal getClienteSucursal() {
		return clienteSucursal;
	}

	public void setClienteSucursal(ClienteSucursal clienteSucursal) {
		this.clienteSucursal = clienteSucursal;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
