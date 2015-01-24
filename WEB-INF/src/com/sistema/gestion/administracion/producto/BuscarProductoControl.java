package com.sistema.gestion.administracion.producto;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

import com.coreweb.componente.WindowPopup;
import com.coreweb.control.SoloViewModel;
import com.coreweb.util.MyArray;
import com.sistema.Configuracion;
import com.sistema.ID;
import com.sistema.UtilDTO;
import com.sistema.domain.Producto;
import com.sistema.domain.RegisterDomain;

public class BuscarProductoControl extends SoloViewModel {

	private UtilDTO miUtil = (UtilDTO) this.getDtoUtil();
	private WindowPopup w;

	@AfterCompose(superclass = true)
	public void afterComposeBuscarArticuloControl() {
	}

	@Override
	public String getAliasFormularioCorriente() {
		return ID.F_BUSCAR_PRODUCTO;
	}

	private String filtroCodigo = "";
	private String filtroDescripcion = "";
	private String mensaje = "";

	public String getFiltroCodigo() {
		return filtroCodigo;
	}

	public void setFiltroCodigo(String filtroCodigo) {
		this.filtroCodigo = filtroCodigo;
	}

	public String getFiltroDescripcion() {
		return filtroDescripcion;
	}

	public void setFiltroDescripcion(String filtroDescripcion) {
		this.filtroDescripcion = filtroDescripcion;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	private MyArray selectedProducto = new MyArray();
	private List<MyArray> productos = new ArrayList<MyArray>();

	public MyArray getSelectedProducto() {
		return selectedProducto;
	}

	public void setSelectedProducto(MyArray selectedProducto) {
		this.selectedProducto = selectedProducto;
	}

	public List<MyArray> getProductos() {
		return productos;
	}

	public void setProductos(List<MyArray> productos) {
		this.productos = productos;
	}

	@Init(superclass = true)
	public void initBuscarArticuloControl(
			@ExecutionArgParam(Configuracion.DATO_SOLO_VIEW_MODEL) Object[] datosParam) {
		this.filtroCodigo = (String) (datosParam[0]);
		this.filtroDescripcion = (String) (datosParam[1]);

		this.cargarProductos();
	}

	public void show() {
		try {
			Object[] datosParam = { this.filtroCodigo, this.filtroDescripcion };

			w = new WindowPopup();
			w.setModo(WindowPopup.NUEVO);
			w.setTitulo("Buscar Artículo");
			w.setWidth("630px");
			w.setHigth("500px");
			w.setDato(datosParam);
			w.show(Configuracion.BUSCAR_PRODUCTO_ZUL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MyArray getProductoSeleccionado() {
		return ((BuscarProductoControl) this.w.getVm()).getSelectedProducto();
	}

	public boolean isClickAceptar() {
		return w.isClickAceptar();
	}

	/**
	 * Este método realiza la consulta de los productos existentes. Incluye los
	 * filtros para los campos Código Interno y Descripción del Producto.
	 */
	@Command
	@NotifyChange("productos")
	public void cargarProductos() {
		RegisterDomain rr = RegisterDomain.getInstance();
		// armar el like
		String like = " ";
		if (this.filtroCodigo.trim().compareTo("") != 0) {
			like += " and " + " lower( producto.codigo ) like  '%"
					+ this.filtroCodigo.toLowerCase() + "%' ";
		}
		if (this.filtroDescripcion.trim().compareTo("") != 0) {
			like += " and " + " lower( producto.descripcion ) like  '%"
					+ this.filtroDescripcion.toLowerCase() + "%' ";
		}
		List<MyArray> dataFinal = new ArrayList<MyArray>();
		try {
			List<Producto> data = new ArrayList<Producto>();
			String query = "select producto from Producto producto where precio >= 0 "
					+ like;

			data = rr.hql(query);

			if (!data.isEmpty() && data.size() < 100) {
				for (Producto p : data) {
					MyArray produc = new MyArray();
					produc = this.productoToMyArray(p);
					dataFinal.add(produc);
				}
			} else if (data.isEmpty()) {
				mensaje += "No existen productos";
			} else {
				mensaje += "Existen más de 100 productos. \n Ingrese un criterio de filtro.";
			}
			this.productos = dataFinal;

		} catch (Exception e) {
			this.m.mensajeError("Hubo un error en el filtro \n"
					+ e.getMessage());
		}

	}

	/**
	 * 
	 * @param ad
	 *            Clase Producto del dominio
	 * @return MyArray producto id: id del producto pos1: Codigo del producto
	 *         pos2: Descripcion del producto pos3: Stock disponible pos5: Costo
	 *         del producto pos5: Precio del producto
	 * 
	 */
	public MyArray productoToMyArray(Producto ad) {
		MyArray produc = new MyArray();
		// el id del producto
		produc.setId(ad.getId());
		produc.setPos1(ad.getCodigo());
		produc.setPos2(ad.getDescripcion());
		// cantidad -- esto probablemente haya que cambiar despues
		produc.setPos3(ad.getCantidad());
		produc.setPos4(ad.getCosto());
		produc.setPos5(ad.getPrecio());
		return produc;
	}
}
