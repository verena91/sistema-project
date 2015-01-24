package com.sistema.gestion.administracion.proveedor;

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
import com.sistema.domain.Proveedor;

public class ProveedorControlBody extends Body {

	ProveedorDTO dto = new ProveedorDTO();
	private UtilDTO miUtilDto = (UtilDTO) this.getDtoUtil();
	private ProveedorSucursalDTO selectedSucursal = new ProveedorSucursalDTO();

	public ProveedorDTO getDto() {
		return dto;
	}

	public void setDto(ProveedorDTO dto) {
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

	public ProveedorSucursalDTO getSelectedSucursal() {
		return selectedSucursal;
	}

	public void setSelectedSucursal(ProveedorSucursalDTO selectedSucursal) {
		this.selectedSucursal = selectedSucursal;
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
		return new ProveedorAssembler();
	}

	@Override
	public DTO getDTOCorriente() {
		return dto;
	}

	@Override
	public void setDTOCorriente(DTO dto) {
		this.dto = (ProveedorDTO) dto;
	}

	@Override
	public DTO nuevoDTO() throws Exception {
		ProveedorDTO dtoNuevo = new ProveedorDTO();
		return dtoNuevo;
	}

	@Override
	public String getEntidadPrincipal() {
		return Proveedor.class.getName();
	}

	@Override
	public List<DTO> getAllModel() throws Exception {
		return this.getAllDTOs(this.getEntidadPrincipal());
	}

	public Browser getBrowser() {
		return new ProveedorBrowser();
	}

	@Command()
	@NotifyChange("*")
	public void eliminarSucursal() {
		if (this.selectedSucursal != null) {
			if (mensajeEliminar("Está seguro que quiere eliminar la sucursal?")) {
				this.getDto().getProveedorSucursales()
						.remove(this.selectedSucursal);
			}
			this.setSelectedSucursal(null);
		}
	}

	@Command()
	@NotifyChange("*")
	public void agregarSucursal() {

		if (mensajeAgregar("Agregar una nueva sucursal?")) {
			ProveedorSucursalDTO nSucu = new ProveedorSucursalDTO();
			nSucu.setNombre("--editar--");
			this.getDto().getProveedorSucursales().add(nSucu);
			this.setSelectedSucursal(nSucu);
		}
	}

}
