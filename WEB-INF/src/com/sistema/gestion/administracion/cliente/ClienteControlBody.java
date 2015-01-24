package com.sistema.gestion.administracion.cliente;

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
import com.sistema.domain.Cliente;

public class ClienteControlBody extends Body {

	ClienteDTO dto = new ClienteDTO();
	private UtilDTO miUtilDto = (UtilDTO) this.getDtoUtil();
	private ClienteSucursalDTO selectedSucursal = new ClienteSucursalDTO();

	public ClienteDTO getDto() {
		return dto;
	}

	public void setDto(ClienteDTO dto) {
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

	public ClienteSucursalDTO getSelectedSucursal() {
		return selectedSucursal;
	}

	public void setSelectedSucursal(ClienteSucursalDTO selectedSucursal) {
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
		return new ClienteAssembler();
	}

	@Override
	public DTO getDTOCorriente() {
		return dto;
	}

	@Override
	public void setDTOCorriente(DTO dto) {
		this.dto = (ClienteDTO) dto;
	}

	@Override
	public DTO nuevoDTO() throws Exception {
		ClienteDTO dtoNuevo = new ClienteDTO();
		return dtoNuevo;
	}

	@Override
	public String getEntidadPrincipal() {
		return Cliente.class.getName();
	}

	@Override
	public List<DTO> getAllModel() throws Exception {
		return this.getAllDTOs(this.getEntidadPrincipal());
	}

	public Browser getBrowser() {
		return new ClienteBrowser();
	}

	@Command()
	@NotifyChange("*")
	public void eliminarSucursal() {
		if (this.selectedSucursal != null) {
			if (mensajeEliminar("Está seguro que quiere eliminar la sucursal?")) {
				this.getDto().getClienteSucursales()
						.remove(this.selectedSucursal);
			}
			this.setSelectedSucursal(null);
		}
	}

	@Command()
	@NotifyChange("*")
	public void agregarSucursal() {

		if (mensajeAgregar("Agregar una nueva sucursal?")) {
			ClienteSucursalDTO nSucu = new ClienteSucursalDTO();
			nSucu.setNombre("--editar--");
			this.getDto().getClienteSucursales().add(nSucu);
			this.setSelectedSucursal(nSucu);
		}
	}

}
