package com.sistema.gestion.administracion.proveedor;

import com.coreweb.domain.Domain;
import com.coreweb.dto.Assembler;
import com.coreweb.dto.DTO;
import com.sistema.domain.ProveedorSucursal;

public class ProveedorSucursalAssembler extends Assembler {

	private static String[] attIguales = { "nombre", "direccion", "telefono",
			"correo", "contactoSucursal" };

	@Override
	public Domain dtoToDomain(DTO dto) throws Exception {
		ProveedorSucursal domain = (ProveedorSucursal) getDomain(dto,
				ProveedorSucursal.class);
		this.copiarValoresAtributos(dto, domain, attIguales);

		return domain;
	}

	@Override
	public DTO domainToDto(Domain domain) throws Exception {
		ProveedorSucursalDTO dto = (ProveedorSucursalDTO) getDTO(domain,
				ProveedorSucursalDTO.class);
		this.copiarValoresAtributos(domain, dto, attIguales);

		return dto;
	}

}
