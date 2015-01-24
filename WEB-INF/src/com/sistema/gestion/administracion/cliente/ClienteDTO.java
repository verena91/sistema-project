package com.sistema.gestion.administracion.cliente;

import java.util.ArrayList;
import java.util.List;

import com.coreweb.dto.DTO;

public class ClienteDTO extends DTO {

	private String razonSocial;
	private String ruc;
	private String contacto;
	private String correo;
	private List<ClienteSucursalDTO> clienteSucursales = new ArrayList<ClienteSucursalDTO>();

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

	public List<ClienteSucursalDTO> getClienteSucursales() {
		return clienteSucursales;
	}

	public void setClienteSucursales(List<ClienteSucursalDTO> clienteSucursales) {
		this.clienteSucursales = clienteSucursales;
	}
}
