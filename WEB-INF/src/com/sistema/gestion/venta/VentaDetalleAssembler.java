package com.sistema.gestion.venta;

import com.coreweb.domain.Domain;
import com.coreweb.dto.Assembler;
import com.coreweb.dto.DTO;
import com.sistema.domain.VentaDetalle;
import com.sistema.gestion.administracion.producto.ProductoAssembler;

public class VentaDetalleAssembler extends Assembler {

	private static String[] attIguales = { "cantidad", "descuento",
			"precioFinal", "montoExentas", "montoGravadasDiez",
			"montoGravadasDiez" };

	@Override
	public Domain dtoToDomain(DTO dto) throws Exception {
		VentaDetalle domain = (VentaDetalle) getDomain(dto, VentaDetalle.class);
		this.copiarValoresAtributos(dto, domain, attIguales);
		this.hijoDtoToHijoDomain(dto, domain, "producto",
				new ProductoAssembler(), false);
		return domain;
	}

	@Override
	public DTO domainToDto(Domain domain) throws Exception {
		VentaDetalleDTO dto = (VentaDetalleDTO) getDTO(domain,
				VentaDetalleDTO.class);
		this.copiarValoresAtributos(domain, dto, attIguales);
		this.hijoDomainToHijoDTO(domain, dto, "producto",
				new ProductoAssembler());
		return dto;
	}
}
