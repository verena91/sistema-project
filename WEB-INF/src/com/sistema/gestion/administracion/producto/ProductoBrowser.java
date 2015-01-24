package com.sistema.gestion.administracion.producto;

import java.util.ArrayList;
import java.util.List;

import com.coreweb.extras.browser.Browser;
import com.coreweb.extras.browser.ColumnaBrowser;
import com.sistema.domain.Producto;

public class ProductoBrowser extends Browser {

	@Override
	public List<ColumnaBrowser> getColumnasBrowser() {
		ColumnaBrowser col1 = new ColumnaBrowser();
		ColumnaBrowser col2 = new ColumnaBrowser();
		ColumnaBrowser col3 = new ColumnaBrowser();
		ColumnaBrowser col4 = new ColumnaBrowser();
		ColumnaBrowser col5 = new ColumnaBrowser();

		col1.setCampo("codigo");
		col1.setTitulo("Código");

		col2.setCampo("descripcion");
		col2.setTitulo("Descripción");

		col3.setCampo("familia.nombre");
		col3.setTitulo("Familia");

		col4.setCampo("presentacion.nombre");
		col4.setTitulo("Presentación");

		col5.setCampo("precio");
		col5.setTitulo("Precio");

		List<ColumnaBrowser> columnas = new ArrayList<ColumnaBrowser>();
		columnas.add(col1);
		columnas.add(col2);
		columnas.add(col3);
		columnas.add(col4);
		columnas.add(col5);

		return columnas;
	}

	@Override
	public Class getEntidadPrincipal() {
		return Producto.class;
	}

	@Override
	public void setingInicial() {
		this.setWidthWindows("850px");
		this.setHigthWindows("75%");
	}

	@Override
	public String getTituloBrowser() {
		return "Productos";
	}

}
