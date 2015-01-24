package com.sistema;

import java.util.ArrayList;
import java.util.List;

import com.coreweb.domain.Domain;
import com.coreweb.domain.Ping;
import com.coreweb.domain.Tipo;
import com.coreweb.dto.AssemblerCoreUtil;
import com.coreweb.dto.DTO;
import com.coreweb.dto.UtilCoreDTO;
import com.coreweb.util.MyPair;
import com.sistema.domain.RegisterDomain;

public class AssemblerUtil extends AssemblerCoreUtil {

	public static UtilDTO getDTOUtil() {
		AssemblerUtil as = new AssemblerUtil();
		UtilCoreDTO dto = getDTOUtilCore(as);
		return (UtilDTO) dto;
	}

	@Override
	public Domain dtoToDomain(DTO dtoC) throws Exception {
		// TODO Auto-generated method stub
		UtilDTO dto = (UtilDTO) dtoC;

		Ping ping = new Ping();
		ping.setEcho("Configuracion modificada: " + System.currentTimeMillis());

		/*
		 * listaMyPairToListaDomainTipo(dto.getTiposDeTareaFDS(),
		 * Configuracion.ID_TIPO_TAREA_FDS);
		 */

		return ping;
	}

	@Override
	public DTO domainToDto(Domain domain) throws Exception {
		UtilDTO dto = new UtilDTO();
		RegisterDomain rr = RegisterDomain.getInstance();

		List<Tipo> _unidades = rr.getTipos(Configuracion.ID_TIPO_UNIDAD);

		Tipo _unidadGr = rr.getTipoPorSigla(Configuracion.SIGLA_UNIDAD_GR);
		Tipo _unidadMl = rr.getTipoPorSigla(Configuracion.SIGLA_UNIDAD_ML);
		Tipo _unidadCc = rr.getTipoPorSigla(Configuracion.SIGLA_UNIDAD_CC);

		List<MyPair> unidades = this.listaTiposToListaMyPair(_unidades);

		MyPair unidadGr = this.tipoToMyPair(_unidadGr);
		MyPair unidadMl = this.tipoToMyPair(_unidadMl);
		MyPair unidadCc = this.tipoToMyPair(_unidadCc);

		dto.setUnidades(unidades);

		dto.setUnidadGr(unidadGr);
		dto.setUnidadMl(unidadMl);
		dto.setUnidadCc(unidadCc);

		dto.setCondiciones(this.listaCondiciones());

		/*
		 * this.utilDomainToListaMyArray(dto, "puestos", Puesto.class.getName(),
		 * attPuestos);
		 */

		return dto;
	}

	public List<MyPair> listaCondiciones() {
		List<MyPair> lImpo = new ArrayList<MyPair>();

		MyPair cred = new MyPair();
		cred.setId(new Long(1));
		cred.setText("Crédito");
		MyPair cont = new MyPair();
		cont.setId(new Long(2));
		cont.setText("Contado");
		lImpo.add(cred);
		lImpo.add(cont);

		return lImpo;

	}
}
