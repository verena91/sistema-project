package com.sistema.gestion.administracion.proveedor;

import com.coreweb.domain.Domain;
import com.coreweb.dto.Assembler;
import com.coreweb.dto.DTO;
import com.sistema.domain.Proveedor;

public class ProveedorAssembler extends Assembler {
	private static String[] attIguales = { "razonSocial", "ruc", "contacto",
			"correo" };

	@Override
	public Domain dtoToDomain(DTO dto) throws Exception {
		Proveedor domain = (Proveedor) getDomain(dto, Proveedor.class);
		this.copiarValoresAtributos(dto, domain, attIguales);
		this.listaDTOToListaDomain(dto, domain, "proveedorSucursales", true,
				true, new ProveedorSucursalAssembler());

		return domain;
	}

	@Override
	public DTO domainToDto(Domain domain) throws Exception {
		ProveedorDTO dto = (ProveedorDTO) getDTO(domain, ProveedorDTO.class);
		this.copiarValoresAtributos(domain, dto, attIguales);
		this.listaDomainToListaDTO(domain, dto, "proveedorSucursales",
				new ProveedorSucursalAssembler());

		return dto;
	}
}
