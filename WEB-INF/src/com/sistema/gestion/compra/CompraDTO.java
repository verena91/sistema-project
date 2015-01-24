package com.sistema.gestion.compra;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.coreweb.dto.DTO;
import com.sistema.gestion.administracion.proveedor.ProveedorSucursalDTO;

public class CompraDTO extends DTO {

	private Date fecha;
	private String numero;
	private String observacion;
	private String plazo;
	private String condicionCompra; // contado o credito
	private String tipoCompra;
	private ProveedorSucursalDTO proveedorSucursal;
	private List<CompraDetalleDTO> compraDetalles = new ArrayList<CompraDetalleDTO>();

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

	public String getCondicionCompra() {
		return condicionCompra;
	}

	public void setCondicionCompra(String condicionCompra) {
		this.condicionCompra = condicionCompra;
	}

	public String getTipoCompra() {
		return tipoCompra;
	}

	public void setTipoCompra(String tipoCompra) {
		this.tipoCompra = tipoCompra;
	}

	public ProveedorSucursalDTO getProveedorSucursal() {
		return proveedorSucursal;
	}

	public void setProveedorSucursal(ProveedorSucursalDTO proveedorSucursal) {
		this.proveedorSucursal = proveedorSucursal;
	}

	public List<CompraDetalleDTO> getCompraDetalles() {
		return compraDetalles;
	}

	public void setCompraDetalles(List<CompraDetalleDTO> compraDetalles) {
		this.compraDetalles = compraDetalles;
	}

}
