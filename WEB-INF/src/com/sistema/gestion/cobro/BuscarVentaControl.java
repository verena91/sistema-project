package com.sistema.gestion.cobro;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

import com.coreweb.componente.WindowPopup;
import com.coreweb.control.SoloViewModel;
import com.sistema.Configuracion;
import com.sistema.ID;
import com.sistema.UtilDTO;
import com.sistema.domain.RegisterDomain;
import com.sistema.domain.Venta;
import com.sistema.gestion.administracion.cliente.ClienteSucursalDTO;
import com.sistema.gestion.venta.VentaDTO;

public class BuscarVentaControl extends SoloViewModel {

	private UtilDTO miUtil = (UtilDTO) this.getDtoUtil();
	private WindowPopup w;

	@AfterCompose(superclass = true)
	public void afterComposeBuscarArticuloControl() {
	}

	@Override
	public String getAliasFormularioCorriente() {
		return ID.F_BUSCAR_VENTA;
	}

	private String filtroNumero = "";
	private String filtroCliente = "";
	private String mensaje = "";

	public String getFiltroNumero() {
		return filtroNumero;
	}

	public void setFiltroNumero(String filtroNumero) {
		this.filtroNumero = filtroNumero;
	}

	public String getFiltroCliente() {
		return filtroCliente;
	}

	public void setFiltroCliente(String filtroCliente) {
		this.filtroCliente = filtroCliente;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	private VentaDTO selectedVenta = new VentaDTO();
	private List<VentaDTO> ventas = new ArrayList<VentaDTO>();

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

	@Init(superclass = true)
	public void initBuscarArticuloControl(
			@ExecutionArgParam(Configuracion.DATO_SOLO_VIEW_MODEL) Object[] datosParam) {
		this.filtroNumero = (String) (datosParam[0]);
		this.filtroCliente = (String) (datosParam[1]);

		this.cargarVentas();
	}

	public void show() {
		try {
			Object[] datosParam = { this.filtroNumero, this.filtroCliente };

			w = new WindowPopup();
			w.setModo(WindowPopup.NUEVO);
			w.setTitulo("Buscar Venta");
			w.setWidth("630px");
			w.setHigth("500px");
			w.setDato(datosParam);
			w.show(Configuracion.BUSCAR_VENTA_ZUL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public VentaDTO getVentaSeleccionada() {
		return ((BuscarVentaControl) this.w.getVm()).getSelectedVenta();
	}

	public boolean isClickAceptar() {
		return w.isClickAceptar();
	}

	/**
	 * Este método realiza la consulta de los productos existentes. Incluye los
	 * filtros para los campos Código Interno y Descripción del Producto.
	 */
	@Command
	@NotifyChange("ventas")
	public void cargarVentas() {
		RegisterDomain rr = RegisterDomain.getInstance();
		// armar el like
		String like = " ";
		if (this.filtroNumero.trim().compareTo("") != 0) {
			like += " and " + " lower( venta.numero ) like  '%"
					+ this.filtroNumero.toLowerCase() + "%' ";
		}
		if (this.filtroCliente.trim().compareTo("") != 0) {
			like += " and " + " lower( venta.clienteSucursal.nombre ) like  '%"
					+ this.filtroCliente.toLowerCase() + "%' ";
		}
		List<VentaDTO> dataFinal = new ArrayList<VentaDTO>();
		try {
			List<Venta> data = new ArrayList<Venta>();
			String query = "select venta from Venta venta where id != 0 "
					+ like;

			data = rr.hql(query);

			if (!data.isEmpty() && data.size() < 100) {
				for (Venta v : data) {
					VentaDTO venta = new VentaDTO();
					venta = this.ventaToDto(v);
					dataFinal.add(venta);
				}
			} else if (data.isEmpty()) {
				mensaje += "No existen ventas";
			} else {
				mensaje += "Existen más de 100 ventas. \n Ingrese un criterio de filtro.";
			}
			this.ventas = dataFinal;

		} catch (Exception e) {
			this.m.mensajeError("Hubo un error en el filtro \n"
					+ e.getMessage());
		}

	}

	/**
	 * 
	 * @param ad
	 *            Clase Venta del dominio
	 * @return VentaDTO venta
	 */
	public VentaDTO ventaToDto(Venta ad) {
		VentaDTO vta = new VentaDTO();
		// el id del producto
		vta.setId(ad.getId());
		vta.setNumero(ad.getNumero());
		ClienteSucursalDTO cs = new ClienteSucursalDTO();
		cs.setId(ad.getClienteSucursal().getId());
		cs.setNombre(ad.getClienteSucursal().getNombre());
		vta.setClienteSucursal(cs);
		vta.setCondicionVenta(ad.getCondicionVenta());
		vta.setFecha(ad.getFecha());
		return vta;
	}
}
