package com.sistema.gestion.compra;

import com.coreweb.domain.Domain;
import com.coreweb.dto.Assembler;
import com.coreweb.dto.DTO;
import com.sistema.domain.CompraDetalle;
import com.sistema.gestion.administracion.producto.ProductoAssembler;

public class CompraDetalleAssembler extends Assembler {

	private static String[] attIguales = { "cantidad", "descripcion",
			"costoFinal", "montoExentas", "montoGravadasDiez",
			"montoGravadasDiez" };

	@Override
	public Domain dtoToDomain(DTO dto) throws Exception {
		CompraDetalle domain = (CompraDetalle) getDomain(dto,
				CompraDetalle.class);
		this.copiarValoresAtributos(dto, domain, attIguales);
		this.hijoDtoToHijoDomain(dto, domain, "producto",
				new ProductoAssembler(), false);
		return domain;
	}

	@Override
	public DTO domainToDto(Domain domain) throws Exception {
		CompraDetalleDTO dto = (CompraDetalleDTO) getDTO(domain,
				CompraDetalleDTO.class);
		this.copiarValoresAtributos(domain, dto, attIguales);
		this.hijoDomainToHijoDTO(domain, dto, "producto",
				new ProductoAssembler());
		return dto;
	}
}
