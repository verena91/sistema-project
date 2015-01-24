package com.sistema.domain;

import java.util.HashSet;
import java.util.Set;

import com.coreweb.domain.Domain;

public class Proveedor extends Domain {

	private String razonSocial;
	private String ruc;
	private String contacto;
	private String correo;
	private Set<ProveedorSucursal> proveedorSucursales = new HashSet<ProveedorSucursal>();

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

	public Set<ProveedorSucursal> getProveedorSucursales() {
		return proveedorSucursales;
	}

	public void setProveedorSucursales(
			Set<ProveedorSucursal> proveedorSucursales) {
		this.proveedorSucursales = proveedorSucursales;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
