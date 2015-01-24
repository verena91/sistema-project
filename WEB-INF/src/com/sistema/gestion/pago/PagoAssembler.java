package com.sistema.gestion.pago;

import com.coreweb.domain.Domain;
import com.coreweb.dto.Assembler;
import com.coreweb.dto.DTO;
import com.sistema.domain.Pago;
import com.sistema.gestion.compra.CompraAssembler;

public class PagoAssembler extends Assembler {
	private static String[] attIguales = { "fecha", "monto", "numero",
			"observaciones" };

	@Override
	public Domain dtoToDomain(DTO dto) throws Exception {
		Pago domain = (Pago) getDomain(dto, Pago.class);
		this.copiarValoresAtributos(dto, domain, attIguales);
		this.hijoDtoToHijoDomain(dto, domain, "compraAsociada",
				new CompraAssembler(), false);

		return domain;
	}

	@Override
	public DTO domainToDto(Domain domain) throws Exception {
		PagoDTO dto = (PagoDTO) getDTO(domain, PagoDTO.class);
		this.copiarValoresAtributos(domain, dto, attIguales);
		this.hijoDomainToHijoDTO(domain, dto, "compraAsociada",
				new CompraAssembler());

		return dto;
	}
}
