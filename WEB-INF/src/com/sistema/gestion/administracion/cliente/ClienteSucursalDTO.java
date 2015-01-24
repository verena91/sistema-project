package com.sistema.gestion.administracion.cliente;

import com.coreweb.dto.DTO;

public class ClienteSucursalDTO extends DTO {

	private String nombre;
	private String direccion;
	private String telefono;
	private String correo;
	private String contactoSucursal;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContactoSucursal() {
		return contactoSucursal;
	}

	public void setContactoSucursal(String contactoSucursal) {
		this.contactoSucursal = contactoSucursal;
	}

}
