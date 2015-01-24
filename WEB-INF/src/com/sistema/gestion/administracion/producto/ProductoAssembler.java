package com.sistema.gestion.administracion.producto;

import com.coreweb.domain.Domain;
import com.coreweb.dto.Assembler;
import com.coreweb.dto.DTO;
import com.coreweb.util.MyArray;
import com.coreweb.util.MyPair;
import com.sistema.domain.Producto;
import com.sistema.domain.RegisterDomain;

public class ProductoAssembler extends Assembler {

	private static String[] attIguales = { "codigo", "descripcion", "imagen",
			"costo", "precio", "cantidad" };

	private static String[] attFamilia = { "nombre", "descripcion" };
	private static String[] attPresentacion = { "nombre", "descripcion" };

	@Override
	public Domain dtoToDomain(DTO dtoA) throws Exception {
		ProductoDTO dto = (ProductoDTO) dtoA;
		Producto domain = (Producto) getDomain(dto, Producto.class);

		this.copiarValoresAtributos(dto, domain, attIguales);
		this.myArrayToDomain(dto, domain, "familia", false);
		this.myArrayToDomain(dto, domain, "presentacion", false);
		this.myPairToDomain(dto, domain, "unidadDeMedida");

		return domain;
	}

	@Override
	public DTO domainToDto(Domain dom) throws Exception {
		Producto domain = (Producto) dom;
		ProductoDTO dto = (ProductoDTO) getDTO(domain, ProductoDTO.class);

		this.copiarValoresAtributos(domain, dto, attIguales);
		this.domainToMyArray(domain, dto, "familia", attFamilia);
		this.domainToMyArray(domain, dto, "presentacion", attPresentacion);
		this.domainToMyPair(domain, dto, "unidadDeMedida");

		return dto;
	}

	public static void main(String[] args) throws Exception {
		ProductoDTO dto = new ProductoDTO();
		dto.setCodigo("00001");
		dto.setDescripcion("aaa");

		MyArray maFamilia = new MyArray();
		maFamilia.setId(1l);
		MyArray maPres = new MyArray();
		maPres.setId(1l);
		MyPair unidMed = new MyPair();
		unidMed.setId(1l);

		dto.setFamilia(maFamilia);
		dto.setPresentacion(maPres);
		dto.setUnidadDeMedida(unidMed);

		dto.setPrecio(15000);
		dto.setCantidad(10);
		dto.setImagen("");

		ProductoAssembler as = new ProductoAssembler();
		Producto dom = (Producto) as.dtoToDomain(dto);

		RegisterDomain rr = RegisterDomain.getInstance();
		rr.saveObject(dom, "verenaa");
	}

}
