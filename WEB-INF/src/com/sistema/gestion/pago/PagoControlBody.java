package com.sistema.gestion.pago;

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
import com.sistema.gestion.compra.CompraDTO;

public class PagoControlBody extends Body {

	PagoDTO dto = new PagoDTO();
	private UtilDTO miUtilDto = (UtilDTO) this.getDtoUtil();
	CompraDTO selectedCompra = new CompraDTO();
	List<CompraDTO> compras = new ArrayList<CompraDTO>();

	public PagoDTO getDto() {
		return dto;
	}

	public void setDto(PagoDTO dto) {
		this.dto = dto;
	}

	public CompraDTO getSelectedCompra() {
		return selectedCompra;
	}

	public void setSelectedCompra(CompraDTO selectedCompra) {
		this.selectedCompra = selectedCompra;
	}

	public List<CompraDTO> getCompras() {
		return compras;
	}

	public void setCompras(List<CompraDTO> compras) {
		this.compras = compras;
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
		 * try { this.cargarCompras(); } catch (Exception e) {
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
		return new PagoAssembler();
	}

	@Override
	public DTO getDTOCorriente() {
		return dto;
	}

	@Override
	public void setDTOCorriente(DTO dto) {
		this.dto = (PagoDTO) dto;
	}

	String autoNroKey = Configuracion.NRO_PAGO;

	@Override
	public DTO nuevoDTO() throws Exception {
		PagoDTO dtoNuevo = new PagoDTO();
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
		return new PagoBrowser();
	}

	public void cargarCompras() throws Exception {
		RegisterDomain rr = RegisterDomain.getInstance();
		List<Compra> list = rr.getAllCompras();
		for (Compra compra : list) {
			CompraDTO v = new CompraDTO();
			v.setId(compra.getId());
			v.setNumero(compra.getNumero());
			this.compras.add(v);
		}
	}

	@Command()
	@NotifyChange("*")
	public void buscarCompra() {
		try {
			BuscarCompraControl ba = new BuscarCompraControl();
			ba.show();
			boolean ok = true;
			if (ba.isClickAceptar()) {
				CompraDTO selectedCompra = ba.getCompraSeleccionada();
				RegisterDomain rr = RegisterDomain.getInstance();
				this.dto.setCompraAsociada(selectedCompra);

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
