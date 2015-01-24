package com.sistema.gestion.administracion.varios;

import java.util.ArrayList;
import java.util.List;

import com.coreweb.extras.browser.Browser;
import com.coreweb.extras.browser.ColumnaBrowser;
import com.sistema.domain.Familia;

public class FamiliaBrowser extends Browser {

	@Override
	public List<ColumnaBrowser> getColumnasBrowser() {
		ColumnaBrowser col1 = new ColumnaBrowser();
		ColumnaBrowser col2 = new ColumnaBrowser();

		col1.setCampo("nombre");
		col1.setTitulo("Nombre");

		col2.setCampo("descripcion");
		col2.setTitulo("Descripción");

		List<ColumnaBrowser> columnas = new ArrayList<ColumnaBrowser>();
		columnas.add(col1);
		columnas.add(col2);

		return columnas;
	}

	@Override
	public Class getEntidadPrincipal() {
		return Familia.class;
	}

	@Override
	public void setingInicial() {
		this.setWidthWindows("850px");
		this.setHigthWindows("75%");
	}

	@Override
	public String getTituloBrowser() {
		return "Familias de Productos";
	}

}
