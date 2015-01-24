package com.sistema.util.population;

import com.coreweb.domain.Domain;
import com.coreweb.domain.Tipo;
import com.coreweb.domain.TipoTipo;
import com.sistema.Configuracion;
import com.sistema.domain.RegisterDomain;

public class DBPopulationTipos {

	private RegisterDomain rr = RegisterDomain.getInstance();

	private void grabarDB(Domain d) throws Exception {
		rr.saveObject(d, Configuracion.USER_SYSTEMA);
	}

	// Unidades de medida
	TipoTipo unidad = new TipoTipo();
	Tipo unidad_gr = new Tipo();
	Tipo unidad_ml = new Tipo();
	Tipo unidad_cc = new Tipo();

	// Alertas..
	TipoTipo tipoAlerta = new TipoTipo();
	Tipo alertaMuchos = new Tipo();
	Tipo alertaUno = new Tipo();
	Tipo alertaComunitaria = new Tipo();

	TipoTipo nivelAlerta = new TipoTipo();
	Tipo alertaInformativa = new Tipo();
	Tipo alertaError = new Tipo();

	TipoTipo sucursales = new TipoTipo();
	Tipo sucursal1 = new Tipo();

	public void cargarTipos() throws Exception {

		// Sucursales
		sucursales.setDescripcion(Configuracion.ID_TIPO_SUCURSAL);
		grabarDB(sucursales);

		sucursal1.setDescripcion("S1");
		sucursal1.setSigla(Configuracion.SIGLA_SUCURSAL);
		sucursal1.setTipoTipo(sucursales);
		grabarDB(sucursal1);

		// Estado Turno
		unidad.setDescripcion(Configuracion.ID_TIPO_UNIDAD);
		grabarDB(unidad);

		unidad_gr.setDescripcion("GR");
		unidad_gr.setSigla(Configuracion.SIGLA_UNIDAD_GR);
		unidad_gr.setTipoTipo(unidad);
		grabarDB(unidad_gr);

		unidad_ml.setDescripcion("ML");
		unidad_ml.setSigla(Configuracion.SIGLA_UNIDAD_ML);
		unidad_ml.setTipoTipo(unidad);
		grabarDB(unidad_ml);

		unidad_cc.setDescripcion("CC");
		unidad_cc.setSigla(Configuracion.SIGLA_UNIDAD_CC);
		unidad_cc.setTipoTipo(unidad);
		grabarDB(unidad_cc);

		// Tipo y Nivel de Alerta
		tipoAlerta.setDescripcion(Configuracion.ID_TIPO_TIPO_ALERTA);
		grabarDB(tipoAlerta);

		alertaMuchos.setDescripcion("Muchos destinos, muchos canceladores");
		alertaMuchos.setSigla("DESTINO-MUCHOS");
		alertaMuchos.setTipoTipo(tipoAlerta);
		grabarDB(alertaMuchos);

		alertaUno.setDescripcion("Un destino, un cancelador");
		alertaUno.setSigla("DESTINO-UNO");
		alertaUno.setTipoTipo(tipoAlerta);
		grabarDB(alertaUno);

		alertaComunitaria.setDescripcion("Muchos destinos, algun cancelador");
		alertaComunitaria.setSigla("DESTINO-COMUN");
		alertaComunitaria.setTipoTipo(tipoAlerta);
		grabarDB(alertaComunitaria);

		nivelAlerta.setDescripcion(Configuracion.ID_TIPO_NIVEL_ALERTA);
		grabarDB(nivelAlerta);

		alertaInformativa.setDescripcion("Alerta informativa");
		alertaInformativa.setSigla("ALER-INFO");
		alertaInformativa.setTipoTipo(nivelAlerta);
		grabarDB(alertaInformativa);

		alertaError.setDescripcion("Alerta error");
		alertaError.setSigla("ALER-ERROR");
		alertaError.setTipoTipo(nivelAlerta);
		grabarDB(alertaError);
	}
}
