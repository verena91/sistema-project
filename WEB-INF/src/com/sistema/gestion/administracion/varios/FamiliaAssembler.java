package com.sistema.gestion.administracion.varios;

import com.coreweb.domain.Domain;
import com.coreweb.dto.Assembler;
import com.coreweb.dto.DTO;
import com.sistema.domain.Familia;

public class FamiliaAssembler extends Assembler {
	private static String[] attIguales = { "nombre", "descripcion" };

	@Override
	public Domain dtoToDomain(DTO dto) throws Exception {
		Familia domain = (Familia) getDomain(dto, Familia.class);
		this.copiarValoresAtributos(dto, domain, attIguales);
		this.listaDTOToListaDomain(dto, domain, "presentaciones", true, true,
				new PresentacionAssembler());

		return domain;
	}

	@Override
	public DTO domainToDto(Domain domain) throws Exception {
		FamiliaDTO dto = (FamiliaDTO) getDTO(domain, FamiliaDTO.class);
		this.copiarValoresAtributos(domain, dto, attIguales);
		this.listaDomainToListaDTO(domain, dto, "presentaciones",
				new PresentacionAssembler());

		return dto;
	}
}
