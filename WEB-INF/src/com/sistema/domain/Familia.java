package com.sistema.domain;

import java.util.HashSet;
import java.util.Set;

import com.coreweb.domain.Domain;

public class Familia extends Domain {

	private String nombre;
	private String descripcion;
	private Set<Presentacion> presentaciones = new HashSet<Presentacion>();

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

	public Set<Presentacion> getPresentaciones() {
		return presentaciones;
	}

	public void setPresentaciones(Set<Presentacion> presentaciones) {
		this.presentaciones = presentaciones;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
