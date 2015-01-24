package com.sistema.domain;

import java.util.HashSet;
import java.util.Set;

import com.coreweb.domain.Domain;

public class Cliente extends Domain {

	private String razonSocial;
	private String ruc;
	private String contacto;
	private String correo;
	private Set<ClienteSucursal> clienteSucursales = new HashSet<ClienteSucursal>();

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

	public Set<ClienteSucursal> getClienteSucursales() {
		return clienteSucursales;
	}

	public void setClienteSucursales(Set<ClienteSucursal> clienteSucursales) {
		this.clienteSucursales = clienteSucursales;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
