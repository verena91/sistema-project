package com.sistema.gestion.cobro;

import com.coreweb.domain.Domain;
import com.coreweb.dto.Assembler;
import com.coreweb.dto.DTO;
import com.sistema.domain.Cobro;
import com.sistema.gestion.venta.VentaAssembler;

public class CobroAssembler extends Assembler {
	private static String[] attIguales = { "fecha", "monto", "numero", "observaciones" };

	@Override
	public Domain dtoToDomain(DTO dto) throws Exception {
		Cobro domain = (Cobro) getDomain(dto, Cobro.class);
		this.copiarValoresAtributos(dto, domain, attIguales);
		this.hijoDtoToHijoDomain(dto, domain, "ventaAsociada",
				new VentaAssembler(), false);

		return domain;
	}

	@Override
	public DTO domainToDto(Domain domain) throws Exception {
		CobroDTO dto = (CobroDTO) getDTO(domain, CobroDTO.class);
		this.copiarValoresAtributos(domain, dto, attIguales);
		this.hijoDomainToHijoDTO(domain, dto, "ventaAsociada",
				new VentaAssembler());

		return dto;
	}
}
