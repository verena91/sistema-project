package com.sistema.gestion.compra;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

import com.coreweb.dto.Assembler;
import com.coreweb.dto.DTO;
import com.coreweb.extras.agenda.ControlAgendaEvento;
import com.coreweb.extras.browser.Browser;
import com.coreweb.templateABM.Body;
import com.coreweb.util.AutoNumeroControl;
import com.coreweb.util.MyArray;
import com.coreweb.util.MyPair;
import com.sistema.Configuracion;
import com.sistema.UtilDTO;
import com.sistema.domain.Compra;
import com.sistema.domain.Proveedor;
import com.sistema.domain.ProveedorSucursal;
import com.sistema.domain.RegisterDomain;
import com.sistema.gestion.administracion.producto.BuscarProductoControl;
import com.sistema.gestion.administracion.producto.ProductoDTO;
import com.sistema.gestion.administracion.proveedor.ProveedorDTO;
import com.sistema.gestion.administracion.proveedor.ProveedorSucursalDTO;

public class CompraControlBody extends Body {

	CompraDTO dto = new CompraDTO();
	CompraDetalleDTO dtoDetalle = new CompraDetalleDTO();
	private UtilDTO miUtilDto = (UtilDTO) this.getDtoUtil();
	ProveedorDTO selectedProveedor = new ProveedorDTO();
	List<ProveedorDTO> proveedores = new ArrayList<ProveedorDTO>();
	List<ProveedorSucursalDTO> sucursales = new ArrayList<ProveedorSucursalDTO>();
	ProveedorSucursalDTO selectedProveedorSucursal;
	String ruc = "";
	double total = 0;

	MyPair selectedCondicion = new MyPair();

	public MyPair getSelectedCondicion() {
		return selectedCondicion;
	}

	public void setSelectedCondicion(MyPair selectedCondicion) {
		this.selectedCondicion = selectedCondicion;
	}

	public CompraDTO getDto() {
		return dto;
	}

	public void setDto(CompraDTO dto) {
		this.dto = dto;
	}

	public CompraDetalleDTO getDtoDetalle() {
		return dtoDetalle;
	}

	public void setDtoDetalle(CompraDetalleDTO dtoDetalle) {
		this.dtoDetalle = dtoDetalle;
	}

	public UtilDTO getMiUtilDto() {
		return miUtilDto;
	}

	public void setMiUtilDto(UtilDTO miUtilDto) {
		this.miUtilDto = miUtilDto;
	}

	public ProveedorDTO getSelectedProveedor() {
		return selectedProveedor;
	}

	public void setSelectedProveedor(ProveedorDTO selectedProveedor) {
		this.selectedProveedor = selectedProveedor;
	}

	public List<ProveedorDTO> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<ProveedorDTO> proveedores) {
		this.proveedores = proveedores;
	}

	public List<ProveedorSucursalDTO> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<ProveedorSucursalDTO> sucursales) {
		this.sucursales = sucursales;
	}

	public ProveedorSucursalDTO getSelectedProveedorSucursal() {
		return selectedProveedorSucursal;
	}

	public void setSelectedProveedorSucursal(
			ProveedorSucursalDTO selectedProveedorSucursal) {
		this.selectedProveedorSucursal = selectedProveedorSucursal;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Init(superclass = true)
	public void initOperadorControlBody() {

	}

	@Command
	@NotifyChange("sucursales")
	public void actualizarSucursales() throws Exception {
		RegisterDomain rr = RegisterDomain.getInstance();
		// System.out.println("++++++++++++++ RUC " + ruc);
		Proveedor proveedor = rr.getProveedorByRuc(ruc);
		if (proveedor != null) {
			this.convertirProveedorDto(proveedor);
			// System.out.println("++++++++++++++ Razon Social " +
			// cliente.getRazonSocial());
			Set<ProveedorSucursal> list = proveedor.getProveedorSucursales();
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				ProveedorSucursal proveedorSucursal = (ProveedorSucursal) iterator
						.next();
				ProveedorSucursalDTO p = new ProveedorSucursalDTO();
				p.setId(proveedorSucursal.getId());
				p.setNombre(proveedorSucursal.getNombre());
				p.setDireccion(proveedorSucursal.getDireccion());
				p.setTelefono(proveedorSucursal.getTelefono());
				this.sucursales.add(p);
			}
		}
	}

	public void convertirProveedorDto(Proveedor proveedor) {
		ProveedorDTO p = new ProveedorDTO();
		p.setId(proveedor.getId());
		p.setRazonSocial(proveedor.getRazonSocial());
		p.setRuc(proveedor.getRuc());
		this.selectedProveedor = p;
	}

	@Command
	@NotifyChange("selectedProveedor")
	public void actualizarProveedorSucursal() {
		this.dto.setProveedorSucursal(selectedProveedorSucursal);
	}

	@Command
	public void actualizarCondicion() {
		this.dto.setCondicionCompra(selectedCondicion.getText());
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
		return new CompraAssembler();
	}

	@Override
	public DTO getDTOCorriente() {
		return dto;
	}

	@Override
	public void setDTOCorriente(DTO dto) {
		this.dto = (CompraDTO) dto;
	}

	String autoNroKey = Configuracion.NRO_COMPRA;

	@Override
	public DTO nuevoDTO() throws Exception {
		CompraDTO dtoNuevo = new CompraDTO();
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
		return new CompraBrowser();
	}

	// Eliminar detalles de la compra

	private boolean checked = false;

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	@Command("eliminarItem")
	@NotifyChange("*")
	public void eliminarItem() {
		if (this.itemsParaEliminar().isEmpty()) {
			mensajeError(Configuracion.TEXTO_ERROR_ITEM_NO_SELECCIONADO);
		} else {
			if (mensajeEliminar(Configuracion.TEXTO_BORRAR_ITEM_SELECCIONADO
					+ codigosItemsParaEliminar())) {
				this.removerItem();
			} else {
				return;
			}
		}
	}

	@Command
	@NotifyChange("*")
	public void seleccionarTodosDetalle() {
		for (CompraDetalleDTO d : this.dto.getCompraDetalles()) {
			d.setChecked(this.checked);
		}
	}

	public List<CompraDetalleDTO> itemsParaEliminar() {
		List<CompraDetalleDTO> out = new ArrayList<CompraDetalleDTO>();
		for (CompraDetalleDTO d : this.dto.getCompraDetalles()) {
			if (d.isChecked() == true) {
				out.add(d);
			}
		}
		return out;
	}

	public String codigosItemsParaEliminar() {
		String out = "";
		for (CompraDetalleDTO d : this.itemsParaEliminar()) {
			out = out + d.getProducto().getCodigo() + "\n";
		}
		return out;
	}

	public void removerItem() {
		for (CompraDetalleDTO d : this.itemsParaEliminar()) {
			this.dto.getCompraDetalles().remove(d);
		}
	}

	// Agregar detalles a la compra

	@Command()
	@NotifyChange("*")
	public void insertarItemDetalle() throws Exception {
		// System.out.println("+++++++++++++++++++++ Entro a insertar iteem");
		this.buscarProducto();
	}

	@Command()
	@NotifyChange("*")
	public void buscarProducto() {
		try {
			BuscarProductoControl ba = new BuscarProductoControl();
			ba.show();
			boolean ok = true;
			if (ba.isClickAceptar()) {
				MyArray selectedArticulo = ba.getProductoSeleccionado();

				for (CompraDetalleDTO det : this.dto.getCompraDetalles()) {
					if ((long) selectedArticulo.getId() == det.getProducto()
							.getId()) {
						mensajeError("El producto "
								+ det.getProducto().getCodigo()
								+ " ya ha sido agregado al detalle.");
						ok = false;
					}
				}
				if ((long) selectedArticulo.getPos3() <= 0) {
					mensajeError("No puede seleccionar un item con stock menos o igual a 0 (cero).");
				} else if (ok) {
					ProductoDTO producto = new ProductoDTO();
					producto.setId(selectedArticulo.getId());
					producto.setCodigo((String) selectedArticulo.getPos1());
					producto.setDescripcion((String) selectedArticulo.getPos2());
					producto.setCantidad((long) selectedArticulo.getPos3());
					producto.setCosto((double) selectedArticulo.getPos4());

					// setear el dto detalle
					this.dtoDetalle = new CompraDetalleDTO();
					this.dtoDetalle.setProducto(producto);
					this.dtoDetalle.setCostoFinal(producto.getCosto());
					this.dto.getCompraDetalles().add(this.dtoDetalle);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Command
	@NotifyChange("*")
	public void validarCantidadPedida(@BindingParam("d") CompraDetalleDTO det) {
		long cant = det.getCantidad();
		double costoFinal = det.getCostoFinal();
		det.setMontoGravadasDiez(cant * costoFinal);
	}

	@Command
	@NotifyChange("total")
	public void calcularTotal() {
		total = 0;
		List<CompraDetalleDTO> detalles = this.dto.getCompraDetalles();
		double sumParcial = 0;
		for (CompraDetalleDTO d : detalles) {
			sumParcial = d.getMontoExentas() + d.getMontoGravadasCinco()
					+ d.getMontoGravadasDiez();
			total = total + sumParcial;
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
