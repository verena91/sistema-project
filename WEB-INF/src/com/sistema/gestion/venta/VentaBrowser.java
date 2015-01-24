package com.sistema.gestion.venta;

import java.util.ArrayList;
import java.util.List;

import com.coreweb.extras.browser.Browser;
import com.coreweb.extras.browser.ColumnaBrowser;
import com.sistema.domain.Venta;

public class VentaBrowser extends Browser {

	@Override
	public List<ColumnaBrowser> getColumnasBrowser() {
		ColumnaBrowser col1 = new ColumnaBrowser();
		ColumnaBrowser col2 = new ColumnaBrowser();
		ColumnaBrowser col3 = new ColumnaBrowser();
		ColumnaBrowser col4 = new ColumnaBrowser();

		col1.setCampo("numero");
		col1.setTitulo("Número");

		col2.setCampo("fecha");
		col2.setTitulo("Fecha");

		col3.setCampo("condicionVenta");
		col3.setTitulo("Condición");

		col4.setCampo("clienteSucursal.nombre");
		col4.setTitulo("Cliente");

		List<ColumnaBrowser> columnas = new ArrayList<ColumnaBrowser>();
		columnas.add(col1);
		columnas.add(col2);
		columnas.add(col3);
		columnas.add(col4);

		return columnas;
	}

	@Override
	public Class getEntidadPrincipal() {
		return Venta.class;
	}

	@Override
	public void setingInicial() {
		this.setWidthWindows("850px");
		this.setHigthWindows("75%");
	}

	@Override
	public String getTituloBrowser() {
		return "Ventas";
	}

}
