package com.sistema.gestion.administracion.producto;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

import com.coreweb.dto.Assembler;
import com.coreweb.dto.DTO;
import com.coreweb.extras.browser.Browser;
import com.coreweb.templateABM.Body;
import com.coreweb.util.MyArray;
import com.coreweb.util.MyPair;
import com.sistema.UtilDTO;
import com.sistema.domain.Familia;
import com.sistema.domain.Presentacion;
import com.sistema.domain.Producto;
import com.sistema.domain.RegisterDomain;

public class ProductoControlBody extends Body {

	ProductoDTO dto = new ProductoDTO();
	private List<MyArray> familias = new ArrayList<MyArray>();
	private List<MyArray> presentaciones = new ArrayList<MyArray>();
	private List<MyPair> unidades = new ArrayList<MyPair>();
	private UtilDTO miUtilDto = (UtilDTO) this.getDtoUtil();
	private MyArray selectedFamilia = new MyArray();
	private MyArray selectedPresentacion = new MyArray();
	private MyPair selectedUnidad = new MyPair();

	public ProductoDTO getDto() {
		return dto;
	}

	public void setDto(ProductoDTO dto) {
		this.dto = dto;
	}

	public UtilDTO getMiUtilDto() {
		return miUtilDto;
	}

	public void setMiUtilDto(UtilDTO miUtilDto) {
		this.miUtilDto = miUtilDto;
	}

	public List<MyArray> getFamilias() {
		return familias;
	}

	public void setFamilias(List<MyArray> familias) {
		this.familias = familias;
	}

	public List<MyArray> getPresentaciones() {
		return presentaciones;
	}

	public void setPresentaciones(List<MyArray> presentaciones) {
		this.presentaciones = presentaciones;
	}

	public List<MyPair> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<MyPair> unidades) {
		this.unidades = unidades;
	}

	public MyArray getSelectedFamilia() {
		return selectedFamilia;
	}

	public void setSelectedFamilia(MyArray selectedFamilia) {
		this.selectedFamilia = selectedFamilia;
	}

	public MyArray getSelectedPresentacion() {
		return selectedPresentacion;
	}

	public void setSelectedPresentacion(MyArray selectedPresentacion) {
		this.selectedPresentacion = selectedPresentacion;
	}

	public MyPair getSelectedUnidad() {
		return selectedUnidad;
	}

	public void setSelectedUnidad(MyPair selectedUnidad) {
		this.selectedUnidad = selectedUnidad;
	}

	@Init(superclass = true)
	public void initOperadorControlBody() {
		// familias = miUtilDto.getFamilias();
		familias = this.getFamiliasFinales();
		unidades = miUtilDto.getUnidades();
	}

	public List<MyArray> getFamiliasFinales() {
		RegisterDomain rr = RegisterDomain.getInstance();
		List<MyArray> familiasFinales = new ArrayList<MyArray>();
		List<Familia> familias = new ArrayList<Familia>();
		try {
			familias = rr.getAllFamilias();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Familia familia : familias) {
			MyArray fa = new MyArray();
			System.out.println("ID Familia " + familia.getId());
			fa.setId(familia.getId());
			fa.setPos1(familia.getNombre());
			fa.setPos2(familia.getDescripcion());
			List<MyArray> presentaciones = new ArrayList<MyArray>();
			for (Presentacion presentacion : familia.getPresentaciones()) {
				MyArray pres = new MyArray();
				pres.setId(presentacion.getId());
				pres.setPos1(presentacion.getNombre());
				pres.setPos2(presentacion.getDescripcion());
				presentaciones.add(pres);
			}
			fa.setPos3(presentaciones);
			System.out.println("ID Familia MA" + fa.getId());
			familiasFinales.add(fa);
		}
		return familiasFinales;
	}

	@Command()
	@NotifyChange("*")
	public void actualizarFamilia() {
		this.dto.setFamilia(this.selectedFamilia);
		this.presentaciones = (ArrayList<MyArray>) this.selectedFamilia
				.getPos3();
	}

	@Command()
	@NotifyChange("*")
	public void actualizarPresentacion() {
		this.dto.setPresentacion(this.selectedPresentacion);
	}
	
	@Command()
	@NotifyChange("*")
	public void actualizarUnidad() {
		this.dto.setUnidadDeMedida(this.selectedUnidad);
	}

	@AfterCompose(superclass = true)
	public void afterComposeOperadorControlBody() {

	}

	@Override
	public boolean verificarAlGrabar() {
		System.out.println("========== datos ============");
		return true;
	}

	@Override
	public String textoErrorVerificarGrabar() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public Assembler getAss() {
		// TODO Auto-generated method stub
		return new ProductoAssembler();
	}

	@Override
	public DTO getDTOCorriente() {
		return dto;
	}

	@Override
	public void setDTOCorriente(DTO dto) {
		this.dto = (ProductoDTO) dto;
	}

	@Override
	public DTO nuevoDTO() throws Exception {
		ProductoDTO dtoNuevo = new ProductoDTO();
		MyArray fam = new MyArray();
		fam.setPos3(new ArrayList<MyArray>());
		dtoNuevo.setFamilia(fam);
		dtoNuevo.setPresentacion(new MyArray());
		dtoNuevo.setUnidadDeMedida(new MyPair());
		return dtoNuevo;
	}

	@Override
	public String getEntidadPrincipal() {
		return Producto.class.getName();
	}

	@Override
	public List<DTO> getAllModel() throws Exception {
		return this.getAllDTOs(this.getEntidadPrincipal());
	}

	public Browser getBrowser() {
		return new ProductoBrowser();
	}

}
