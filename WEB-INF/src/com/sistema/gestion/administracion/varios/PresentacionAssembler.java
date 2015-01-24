package com.sistema.gestion.administracion.varios;

import com.coreweb.domain.Domain;
import com.coreweb.dto.Assembler;
import com.coreweb.dto.DTO;
import com.sistema.domain.Presentacion;

public class PresentacionAssembler extends Assembler {

	private static String[] attIguales = { "nombre", "descripcion" };

	@Override
	public Domain dtoToDomain(DTO dto) throws Exception {
		Presentacion domain = (Presentacion) getDomain(dto, Presentacion.class);
		this.copiarValoresAtributos(dto, domain, attIguales);

		return domain;
	}

	@Override
	public DTO domainToDto(Domain domain) throws Exception {
		PresentacionDTO dto = (PresentacionDTO) getDTO(domain,
				PresentacionDTO.class);
		this.copiarValoresAtributos(domain, dto, attIguales);

		return dto;
	}

}
