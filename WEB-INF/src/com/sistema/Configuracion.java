package com.sistema;

import org.zkoss.zk.ui.Sessions;

import com.coreweb.Config;

public class Configuracion extends Config {

	//
	public static boolean USA_SUCURSALES = false;

	// Aplicación
	public static String EMPRESA = "Sistema de Gestión";
	public static String ACCESO = "AccesoDTO";
	public static String PATH_SESSION = ".";

	public static String URL_TIMBRE = "";

	static {
		try {

			URL_TIMBRE = Sessions.getCurrent().getWebApp()
					.getRealPath("/recursos/timbre.wav");

		} catch (Exception e) {
			System.err.println("Sin session..");
		}
	}

	// ID's de Tipos
	public static String ID_TIPO_SUCURSAL = "Sucursal";
	public static String ID_TIPO_TIPO_ALERTA = "Tipo Alerta";
	public static String ID_TIPO_NIVEL_ALERTA = "Nivel Alerta";

	public static String ID_TIPO_UNIDAD = "Unidad de medida";

	// Siglas de Tipos
	public static String SIGLA_SUCURSAL = "SUCURSAL";

	public static String SIGLA_UNIDAD_GR = "UN-GR";
	public static String SIGLA_UNIDAD_ML = "UN-ML";
	public static String SIGLA_UNIDAD_CC = "UN-CC";

	public static String TEXTO_ERROR_ITEM_NO_SELECCIONADO = "No se ha seleccionado ningún ítem";
	public static String TEXTO_BORRAR_ITEM_SELECCIONADO = "Esta seguro de borrar los siguientes items: ";
	public static String TEXTO_ELIMINAR_ITEM_SELECCIONADO = "Si continua se eliminaran los siguientes items: \n";

	public static String BUSCAR_PRODUCTO_ZUL = "/sistema/gestion/administracion/buscarProducto.zul";
	public static String BUSCAR_VENTA_ZUL = "/sistema/gestion/cobro/buscarVenta.zul";
	public static String BUSCAR_COMPRA_ZUL = "/sistema/gestion/pago/buscarCompra.zul";

	public static String NRO_VENTA = "VTA";
	public static String NRO_COMPRA = "COM";
	public static String NRO_PAGO = "PAG";
	public static String NRO_COBRO = "COB";

}
