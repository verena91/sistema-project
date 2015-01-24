package com.sistema.gestion.cobro;

import java.util.ArrayList;
import java.util.List;

import com.coreweb.extras.browser.Browser;
import com.coreweb.extras.browser.ColumnaBrowser;
import com.sistema.domain.Cobro;

public class CobroBrowser extends Browser {

	@Override
	public List<ColumnaBrowser> getColumnasBrowser() {
		ColumnaBrowser col1 = new ColumnaBrowser();
		ColumnaBrowser col2 = new ColumnaBrowser();
		ColumnaBrowser col3 = new ColumnaBrowser();

		col1.setCampo("fecha");
		col1.setTitulo("Fecha");

		col2.setCampo("ventaAsociada.numero");
		col2.setTitulo("Factura Venta");

		col3.setCampo("monto");
		col3.setTitulo("Monto");

		List<ColumnaBrowser> columnas = new ArrayList<ColumnaBrowser>();
		columnas.add(col1);
		columnas.add(col2);
		columnas.add(col3);

		return columnas;
	}

	@Override
	public Class getEntidadPrincipal() {
		return Cobro.class;
	}

	@Override
	public void setingInicial() {
		this.setWidthWindows("850px");
		this.setHigthWindows("75%");
	}

	@Override
	public String getTituloBrowser() {
		return "Cobros";
	}

}
