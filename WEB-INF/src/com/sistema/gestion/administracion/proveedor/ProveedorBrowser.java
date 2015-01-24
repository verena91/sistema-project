package com.sistema.gestion.administracion.proveedor;

import java.util.ArrayList;
import java.util.List;

import com.coreweb.extras.browser.Browser;
import com.coreweb.extras.browser.ColumnaBrowser;
import com.sistema.domain.Proveedor;

public class ProveedorBrowser extends Browser {

	@Override
	public List<ColumnaBrowser> getColumnasBrowser() {
		ColumnaBrowser col1 = new ColumnaBrowser();
		ColumnaBrowser col2 = new ColumnaBrowser();
		ColumnaBrowser col3 = new ColumnaBrowser();
		ColumnaBrowser col4 = new ColumnaBrowser();

		col1.setCampo("razonSocial");
		col1.setTitulo("Razón Social");

		col2.setCampo("ruc");
		col2.setTitulo("RUC");

		col3.setCampo("contacto");
		col3.setTitulo("Contacto");

		col4.setCampo("correo");
		col4.setTitulo("Correo");

		List<ColumnaBrowser> columnas = new ArrayList<ColumnaBrowser>();
		columnas.add(col1);
		columnas.add(col2);
		columnas.add(col3);
		columnas.add(col4);

		return columnas;
	}

	@Override
	public Class getEntidadPrincipal() {
		return Proveedor.class;
	}

	@Override
	public void setingInicial() {
		this.setWidthWindows("850px");
		this.setHigthWindows("75%");
	}

	@Override
	public String getTituloBrowser() {
		return "Proveedores";
	}

}
