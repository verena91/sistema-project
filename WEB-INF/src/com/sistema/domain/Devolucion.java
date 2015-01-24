package com.sistema.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.coreweb.domain.Domain;

public class Devolucion extends Domain {

	private Date fecha;
	private String numero;
	private String observacion;
	private ClienteSucursal clienteSucursal;
	private Set<DevolucionDetalle> devolucionDetalles = new HashSet<DevolucionDetalle>();

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

	public ClienteSucursal getClienteSucursal() {
		return clienteSucursal;
	}

	public void setClienteSucursal(ClienteSucursal clienteSucursal) {
		this.clienteSucursal = clienteSucursal;
	}

	public Set<DevolucionDetalle> getDevolucionDetalles() {
		return devolucionDetalles;
	}

	public void setDevolucionDetalles(Set<DevolucionDetalle> devolucionDetalles) {
		this.devolucionDetalles = devolucionDetalles;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
