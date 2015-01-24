package com.sistema.gestion.administracion.varios;

import java.util.List;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

import com.coreweb.dto.Assembler;
import com.coreweb.dto.DTO;
import com.coreweb.extras.browser.Browser;
import com.coreweb.templateABM.Body;
import com.sistema.UtilDTO;
import com.sistema.domain.Familia;

public class VariosControlBody extends Body {

	FamiliaDTO dto = new FamiliaDTO();
	private UtilDTO miUtilDto = (UtilDTO) this.getDtoUtil();
	private PresentacionDTO selectedPresentacion = new PresentacionDTO();

	public FamiliaDTO getDto() {
		return dto;
	}

	public void setDto(FamiliaDTO dto) {
		this.dto = dto;
	}

	public UtilDTO getMiUtilDto() {
		return miUtilDto;
	}

	public void setMiUtilDto(UtilDTO miUtilDto) {
		this.miUtilDto = miUtilDto;
	}

	@Init(superclass = true)
	public void initOperadorControlBody() {

	}

	public PresentacionDTO getSelectedPresentacion() {
		return selectedPresentacion;
	}

	public void setSelectedPresentacion(PresentacionDTO selectedPresentacion) {
		this.selectedPresentacion = selectedPresentacion;
	}

	@Command()
	@NotifyChange("*")
	public void actualizar() {

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
		return new FamiliaAssembler();
	}

	@Override
	public DTO getDTOCorriente() {
		return dto;
	}

	@Override
	public void setDTOCorriente(DTO dto) {
		this.dto = (FamiliaDTO) dto;
	}

	@Override
	public DTO nuevoDTO() throws Exception {
		FamiliaDTO dtoNuevo = new FamiliaDTO();
		return dtoNuevo;
	}

	@Override
	public String getEntidadPrincipal() {
		return Familia.class.getName();
	}

	@Override
	public List<DTO> getAllModel() throws Exception {
		return this.getAllDTOs(this.getEntidadPrincipal());
	}

	public Browser getBrowser() {
		return new FamiliaBrowser();
	}

	@Command()
	@NotifyChange("*")
	public void eliminarPresentacion() {
		if (this.selectedPresentacion != null) {
			if (mensajeEliminar("Está seguro que quiere eliminar la presentación?")) {
				this.getDto().getPresentaciones()
						.remove(this.selectedPresentacion);
			}
			this.setSelectedPresentacion(null);
		}
	}

	@Command()
	@NotifyChange("*")
	public void agregarPresentacion() {

		if (mensajeAgregar("Agregar una nueva presentación?")) {
			PresentacionDTO nSucu = new PresentacionDTO();
			nSucu.setNombre("--editar--");
			this.getDto().getPresentaciones().add(nSucu);
			this.setSelectedPresentacion(nSucu);
		}
	}

}
