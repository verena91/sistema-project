package com.sistema.gestion.administracion.cliente;

import com.coreweb.domain.Domain;
import com.coreweb.dto.Assembler;
import com.coreweb.dto.DTO;
import com.sistema.domain.ClienteSucursal;

public class ClienteSucursalAssembler extends Assembler {

	private static String[] attIguales = { "nombre", "direccion", "telefono",
			"correo", "contactoSucursal" };

	@Override
	public Domain dtoToDomain(DTO dto) throws Exception {
		ClienteSucursal domain = (ClienteSucursal) getDomain(dto,
				ClienteSucursal.class);
		this.copiarValoresAtributos(dto, domain, attIguales);

		return domain;
	}

	@Override
	public DTO domainToDto(Domain domain) throws Exception {
		ClienteSucursalDTO dto = (ClienteSucursalDTO) getDTO(domain,
				ClienteSucursalDTO.class);
		this.copiarValoresAtributos(domain, dto, attIguales);

		return dto;
	}

}
