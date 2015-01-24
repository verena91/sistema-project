package com.sistema.gestion.cobro;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

import com.coreweb.dto.Assembler;
import com.coreweb.dto.DTO;
import com.coreweb.extras.agenda.ControlAgendaEvento;
import com.coreweb.extras.browser.Browser;
import com.coreweb.templateABM.Body;
import com.coreweb.util.AutoNumeroControl;
import com.sistema.Configuracion;
import com.sistema.UtilDTO;
import com.sistema.domain.Compra;
import com.sistema.domain.RegisterDomain;
import com.sistema.domain.Venta;
import com.sistema.gestion.venta.VentaDTO;

public class CobroControlBody extends Body {

	CobroDTO dto = new CobroDTO();
	private UtilDTO miUtilDto = (UtilDTO) this.getDtoUtil();
	VentaDTO selectedVenta = new VentaDTO();
	List<VentaDTO> ventas = new ArrayList<VentaDTO>();

	public CobroDTO getDto() {
		return dto;
	}

	public void setDto(CobroDTO dto) {
		this.dto = dto;
	}

	public VentaDTO getSelectedVenta() {
		return selectedVenta;
	}

	public void setSelectedVenta(VentaDTO selectedVenta) {
		this.selectedVenta = selectedVenta;
	}

	public List<VentaDTO> getVentas() {
		return ventas;
	}

	public void setVentas(List<VentaDTO> ventas) {
		this.ventas = ventas;
	}

	public UtilDTO getMiUtilDto() {
		return miUtilDto;
	}

	public void setMiUtilDto(UtilDTO miUtilDto) {
		this.miUtilDto = miUtilDto;
	}

	@Init(superclass = true)
	public void initOperadorControlBody() {
		/*
		 * try { this.cargarVentas(); } catch (Exception e) {
		 * e.printStackTrace(); }
		 */
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
		return new CobroAssembler();
	}

	@Override
	public DTO getDTOCorriente() {
		return dto;
	}

	@Override
	public void setDTOCorriente(DTO dto) {
		this.dto = (CobroDTO) dto;
	}

	String autoNroKey = Configuracion.NRO_COBRO;

	@Override
	public DTO nuevoDTO() throws Exception {
		CobroDTO dtoNuevo = new CobroDTO();
		try {
			dtoNuevo.setNumero(AutoNumeroControl
					.getAutoNumeroKey(autoNroKey, 7));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoNuevo;
	}

	@Override
	public String getEntidadPrincipal() {
		return Compra.class.getName();
	}

	@Override
	public List<DTO> getAllModel() throws Exception {
		return this.getAllDTOs(this.getEntidadPrincipal());
	}

	public Browser getBrowser() {
		return new CobroBrowser();
	}

	public void cargarVentas() throws Exception {
		RegisterDomain rr = RegisterDomain.getInstance();
		List<Venta> list = rr.getAllVentas();
		for (Venta venta : list) {
			VentaDTO v = new VentaDTO();
			v.setId(venta.getId());
			v.setNumero(venta.getNumero());
			this.ventas.add(v);
		}
	}

	@Command()
	@NotifyChange("*")
	public void buscarVenta() {
		try {
			BuscarVentaControl ba = new BuscarVentaControl();
			ba.show();
			boolean ok = true;
			if (ba.isClickAceptar()) {
				VentaDTO selectedVenta = ba.getVentaSeleccionada();
				RegisterDomain rr = RegisterDomain.getInstance();
				this.dto.setVentaAsociada(selectedVenta);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Agenda

	@Override
	public int getCtrAgendaTipo() {
		return ControlAgendaEvento.COTIZACION;
	}

	@Override
	public String getCtrAgendaKey() {
		return this.dto.getNumero();
	}

	@Override
	public String getCtrAgendaTitulo() {
		return "[Pedido: " + this.getCtrAgendaKey() + "]";
	}

	private List<Object[]> eventosAgenda = new ArrayList<Object[]>();

	public List<Object[]> getEventosAgenda() {
		return eventosAgenda;
	}

	public void setEventosAgenda(List<Object[]> eventosAgenda) {
		this.eventosAgenda = eventosAgenda;
	}

	// Crear eventos en la agenda y poder cargarlos a la lista eventosAgenda
	public void addEventoAgenda(String texto, String link) {

		Object[] evento = new Object[5];
		evento[0] = ControlAgendaEvento.NORMAL;
		evento[1] = this.dto.getNumero();
		evento[2] = 0;
		evento[3] = texto;
		evento[4] = link;
		this.eventosAgenda.add(evento);
	}

	
}
