package com.sistema.gestion.administracion.varios;

import java.util.ArrayList;
import java.util.List;

import com.coreweb.dto.DTO;

public class FamiliaDTO extends DTO {

	private String nombre;
	private String descripcion;
	private List<PresentacionDTO> presentaciones = new ArrayList<PresentacionDTO>();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<PresentacionDTO> getPresentaciones() {
		return presentaciones;
	}

	public void setPresentaciones(List<PresentacionDTO> presentaciones) {
		this.presentaciones = presentaciones;
	}

}
