package com.sistema.gestion.venta;

import com.coreweb.domain.Domain;
import com.coreweb.dto.Assembler;
import com.coreweb.dto.DTO;
import com.sistema.domain.Venta;
import com.sistema.gestion.administracion.cliente.ClienteSucursalAssembler;

public class VentaAssembler extends Assembler {
	private static String[] attIguales = { "fecha", "numero", "observacion",
			"plazo", "condicionVenta" };

	@Override
	public Domain dtoToDomain(DTO dto) throws Exception {
		Venta domain = (Venta) getDomain(dto, Venta.class);
		this.copiarValoresAtributos(dto, domain, attIguales);
		this.hijoDtoToHijoDomain(dto, domain, "clienteSucursal",
				new ClienteSucursalAssembler(), false);
		this.listaDTOToListaDomain(dto, domain, "ventaDetalles", true, true,
				new VentaDetalleAssembler());

		return domain;
	}

	@Override
	public DTO domainToDto(Domain domain) throws Exception {
		VentaDTO dto = (VentaDTO) getDTO(domain, VentaDTO.class);
		this.copiarValoresAtributos(domain, dto, attIguales);
		this.hijoDomainToHijoDTO(domain, dto, "clienteSucursal",
				new ClienteSucursalAssembler());
		this.listaDomainToListaDTO(domain, dto, "ventaDetalles",
				new VentaDetalleAssembler());

		return dto;
	}
}
