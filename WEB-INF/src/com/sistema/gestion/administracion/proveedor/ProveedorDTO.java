package com.sistema.gestion.administracion.proveedor;

import java.util.ArrayList;
import java.util.List;

import com.coreweb.dto.DTO;

public class ProveedorDTO extends DTO {

	private String razonSocial;
	private String ruc;
	private String contacto;
	private String correo;
	private List<ProveedorSucursalDTO> proveedorSucursales = new ArrayList<ProveedorSucursalDTO>();

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public List<ProveedorSucursalDTO> getProveedorSucursales() {
		return proveedorSucursales;
	}

	public void setProveedorSucursales(
			List<ProveedorSucursalDTO> proveedorSucursales) {
		this.proveedorSucursales = proveedorSucursales;
	}

}
