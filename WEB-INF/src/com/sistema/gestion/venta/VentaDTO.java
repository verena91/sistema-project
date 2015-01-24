package com.sistema.gestion.venta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.coreweb.dto.DTO;
import com.sistema.gestion.administracion.cliente.ClienteSucursalDTO;

public class VentaDTO extends DTO {

	private Date fecha;
	private String numero;
	private String observacion;
	private String plazo;
	private String condicionVenta; // contado o credito
	private ClienteSucursalDTO clienteSucursal;
	private List<VentaDetalleDTO> ventaDetalles = new ArrayList<VentaDetalleDTO>();

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

	public String getCondicionVenta() {
		return condicionVenta;
	}

	public void setCondicionVenta(String condicionVenta) {
		this.condicionVenta = condicionVenta;
	}

	public ClienteSucursalDTO getClienteSucursal() {
		return clienteSucursal;
	}

	public void setClienteSucursal(ClienteSucursalDTO clienteSucursal) {
		this.clienteSucursal = clienteSucursal;
	}

	public List<VentaDetalleDTO> getVentaDetalles() {
		return ventaDetalles;
	}

	public void setVentaDetalles(List<VentaDetalleDTO> ventaDetalles) {
		this.ventaDetalles = ventaDetalles;
	}
}
