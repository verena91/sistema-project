package com.sistema.gestion.administracion.cliente;

import com.coreweb.domain.Domain;
import com.coreweb.dto.Assembler;
import com.coreweb.dto.DTO;
import com.sistema.domain.Cliente;

public class ClienteAssembler extends Assembler {
	private static String[] attIguales = { "razonSocial", "ruc", "contacto",
			"correo" };

	@Override
	public Domain dtoToDomain(DTO dto) throws Exception {
		Cliente domain = (Cliente) getDomain(dto, Cliente.class);
		this.copiarValoresAtributos(dto, domain, attIguales);
		this.listaDTOToListaDomain(dto, domain, "clienteSucursales", true,
				true, new ClienteSucursalAssembler());

		return domain;
	}

	@Override
	public DTO domainToDto(Domain domain) throws Exception {
		ClienteDTO dto = (ClienteDTO) getDTO(domain, ClienteDTO.class);
		this.copiarValoresAtributos(domain, dto, attIguales);
		this.listaDomainToListaDTO(domain, dto, "clienteSucursales",
				new ClienteSucursalAssembler());

		return dto;
	}
}
