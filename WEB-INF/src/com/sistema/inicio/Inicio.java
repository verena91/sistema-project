	package com.sistema.inicio;

import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;

import com.coreweb.Config;
import com.coreweb.control.Control;
import com.coreweb.login.LoginUsuarioDTO;
import com.sistema.AssemblerUtil;
import com.sistema.Configuracion;

public class Inicio {

	public synchronized static void init() {
		// Para setear cualquier cosa antes de empezar

		// ver si tiene un UtilDTO seteado
		if (Control.existDtoUtil() == false) {
			System.out.println("==== INICIO de la Aplicacion SISTEMA =========");
			System.err.println("========sistema err ==========================");
			Control.setEmpresa(Configuracion.EMPRESA);
			Control.setInicialDtoUtil(new AssemblerUtil().getDTOUtil());
		}
	}

	public void afterLogin() throws Exception {
		// asi se recupera la session
		Session s = Sessions.getCurrent();

		//System.out.println("======== after login ======");

		LoginUsuarioDTO uDto = (LoginUsuarioDTO) s.getAttribute(Config.USUARIO);
		String login = uDto.getLogin();

		AssemblerAcceso as = new AssemblerAcceso();
		AccesoDTO aDto = (AccesoDTO) as.obtenerAccesoDTO(login);
		s.setAttribute(Configuracion.ACCESO, aDto);

	}

}
