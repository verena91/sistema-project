package com.sistema.gestion.compra;

import com.coreweb.domain.Domain;
import com.coreweb.dto.Assembler;
import com.coreweb.dto.DTO;
import com.sistema.domain.Compra;
import com.sistema.gestion.administracion.proveedor.ProveedorSucursalAssembler;

public class CompraAssembler extends Assembler {
	private static String[] attIguales = { "fecha", "numero", "observacion",
			"plazo", "condicionCompra", "tipoCompra" };

	@Override
	public Domain dtoToDomain(DTO dto) throws Exception {
		Compra domain = (Compra) getDomain(dto, Compra.class);
		this.copiarValoresAtributos(dto, domain, attIguales);
		this.hijoDtoToHijoDomain(dto, domain, "proveedorSucursal",
				new ProveedorSucursalAssembler(), false);
		this.listaDTOToListaDomain(dto, domain, "compraDetalles", true, true,
				new CompraDetalleAssembler());

		return domain;
	}

	@Override
	public DTO domainToDto(Domain domain) throws Exception {
		CompraDTO dto = (CompraDTO) getDTO(domain, CompraDTO.class);
		this.copiarValoresAtributos(domain, dto, attIguales);
		this.hijoDomainToHijoDTO(domain, dto, "proveedorSucursal",
				new ProveedorSucursalAssembler());
		this.listaDomainToListaDTO(domain, dto, "compraDetalles",
				new CompraDetalleAssembler());

		return dto;
	}
}
