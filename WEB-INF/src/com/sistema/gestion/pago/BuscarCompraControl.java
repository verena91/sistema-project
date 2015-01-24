package com.sistema.gestion.pago;

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
import com.sistema.domain.Compra;
import com.sistema.domain.RegisterDomain;
import com.sistema.gestion.administracion.proveedor.ProveedorSucursalDTO;
import com.sistema.gestion.compra.CompraDTO;

public class BuscarCompraControl extends SoloViewModel {

	private UtilDTO miUtil = (UtilDTO) this.getDtoUtil();
	private WindowPopup w;

	@AfterCompose(superclass = true)
	public void afterComposeBuscarArticuloControl() {
	}

	@Override
	public String getAliasFormularioCorriente() {
		return ID.F_BUSCAR_COMPRA;
	}

	private String filtroNumero = "";
	private String filtroProveedor = "";
	private String mensaje = "";

	public String getFiltroNumero() {
		return filtroNumero;
	}

	public void setFiltroNumero(String filtroNumero) {
		this.filtroNumero = filtroNumero;
	}

	public String getFiltroProveedor() {
		return filtroProveedor;
	}

	public void setFiltroProveedor(String filtroProveedor) {
		this.filtroProveedor = filtroProveedor;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	private CompraDTO selectedCompra = new CompraDTO();
	private List<CompraDTO> compras = new ArrayList<CompraDTO>();

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

	@Init(superclass = true)
	public void initBuscarArticuloControl(
			@ExecutionArgParam(Configuracion.DATO_SOLO_VIEW_MODEL) Object[] datosParam) {
		this.filtroNumero = (String) (datosParam[0]);
		this.filtroProveedor = (String) (datosParam[1]);

		this.cargarCompras();
	}

	public void show() {
		try {
			Object[] datosParam = { this.filtroNumero, this.filtroProveedor };

			w = new WindowPopup();
			w.setModo(WindowPopup.NUEVO);
			w.setTitulo("Buscar Compra");
			w.setWidth("630px");
			w.setHigth("500px");
			w.setDato(datosParam);
			w.show(Configuracion.BUSCAR_COMPRA_ZUL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CompraDTO getCompraSeleccionada() {
		return ((BuscarCompraControl) this.w.getVm()).getSelectedCompra();
	}

	public boolean isClickAceptar() {
		return w.isClickAceptar();
	}

	/**
	 * Este método realiza la consulta de los productos existentes. Incluye los
	 * filtros para los campos Código Interno y Descripción del Producto.
	 */
	@Command
	@NotifyChange("compras")
	public void cargarCompras() {
		RegisterDomain rr = RegisterDomain.getInstance();
		// armar el like
		String like = " ";
		if (this.filtroNumero.trim().compareTo("") != 0) {
			like += " and " + " lower( compra.numero ) like  '%"
					+ this.filtroNumero.toLowerCase() + "%' ";
		}
		if (this.filtroNumero.trim().compareTo("") != 0) {
			like += " and "
					+ " lower( compra.proveedorSucursal.nombre ) like  '%"
					+ this.filtroProveedor.toLowerCase() + "%' ";
		}
		List<CompraDTO> dataFinal = new ArrayList<CompraDTO>();
		try {
			List<Compra> data = new ArrayList<Compra>();
			String query = "select compra from Compra compra where id != 0 "
					+ like;

			data = rr.hql(query);

			if (!data.isEmpty() && data.size() < 100) {
				for (Compra c : data) {
					CompraDTO compra = new CompraDTO();
					compra = this.compraToDto(c);
					dataFinal.add(compra);
				}
			} else if (data.isEmpty()) {
				mensaje += "No existen compras";
			} else {
				mensaje += "Existen más de 100 compras. \n Ingrese un criterio de filtro.";
			}
			this.compras = dataFinal;

		} catch (Exception e) {
			this.m.mensajeError("Hubo un error en el filtro \n"
					+ e.getMessage());
		}

	}

	/**
	 * 
	 * @param ad
	 *            Clase Compra del dominio
	 * @return CompraDTO compra
	 * 
	 */
	public CompraDTO compraToDto(Compra ad) {
		CompraDTO com = new CompraDTO();
		// el id del producto
		com.setId(ad.getId());
		com.setNumero(ad.getNumero());
		ProveedorSucursalDTO cs = new ProveedorSucursalDTO();
		cs.setId(ad.getProveedorSucursal().getId());
		cs.setNombre(ad.getProveedorSucursal().getNombre());
		com.setProveedorSucursal(cs);
		com.setCondicionCompra(ad.getCondicionCompra());
		com.setFecha(ad.getFecha());
		return com;
	}
}
