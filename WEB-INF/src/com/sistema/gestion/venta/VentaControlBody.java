package com.sistema.gestion.venta;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.docx4j.Docx4J;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
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
import com.sistema.domain.Cliente;
import com.sistema.domain.ClienteSucursal;
import com.sistema.domain.RegisterDomain;
import com.sistema.domain.Venta;
import com.sistema.gestion.administracion.cliente.ClienteDTO;
import com.sistema.gestion.administracion.cliente.ClienteSucursalDTO;
import com.sistema.gestion.administracion.producto.BuscarProductoControl;
import com.sistema.gestion.administracion.producto.ProductoDTO;
import com.sistema.util.PlantillasDocX;

public class VentaControlBody extends Body {

	VentaDTO dto = new VentaDTO();
	VentaDetalleDTO dtoDetalle = new VentaDetalleDTO();
	private UtilDTO miUtilDto = (UtilDTO) this.getDtoUtil();
	ClienteDTO selectedCliente = new ClienteDTO();
	List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
	List<ClienteSucursalDTO> sucursales = new ArrayList<ClienteSucursalDTO>();
	ClienteSucursalDTO selectedClienteSucursal;
	String ruc;
	double total = 0;

	MyPair selectedCondicion = new MyPair();

	public MyPair getSelectedCondicion() {
		return selectedCondicion;
	}

	public void setSelectedCondicion(MyPair selectedCondicion) {
		this.selectedCondicion = selectedCondicion;
	}

	public VentaDTO getDto() {
		return dto;
	}

	public void setDto(VentaDTO dto) {
		this.dto = dto;
	}

	public VentaDetalleDTO getDtoDetalle() {
		return dtoDetalle;
	}

	public void setDtoDetalle(VentaDetalleDTO dtoDetalle) {
		this.dtoDetalle = dtoDetalle;
	}

	public UtilDTO getMiUtilDto() {
		return miUtilDto;
	}

	public void setMiUtilDto(UtilDTO miUtilDto) {
		this.miUtilDto = miUtilDto;
	}

	public ClienteDTO getSelectedCliente() {
		return selectedCliente;
	}

	public void setSelectedCliente(ClienteDTO selectedCliente) {
		this.selectedCliente = selectedCliente;
	}

	public List<ClienteDTO> getClientes() {
		return clientes;
	}

	public void setClientes(List<ClienteDTO> clientes) {
		this.clientes = clientes;
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

	public List<ClienteSucursalDTO> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<ClienteSucursalDTO> sucursales) {
		this.sucursales = sucursales;
	}

	public ClienteSucursalDTO getSelectedClienteSucursal() {
		return selectedClienteSucursal;
	}

	public void setSelectedClienteSucursal(
			ClienteSucursalDTO selectedClienteSucursal) {
		this.selectedClienteSucursal = selectedClienteSucursal;
	}

	@Init(superclass = true)
	public void initOperadorControlBody() {
		this.ruc = "";
	}

	@Command
	@NotifyChange("sucursales")
	public void actualizarSucursales() throws Exception {
		RegisterDomain rr = RegisterDomain.getInstance();
		// System.out.println("++++++++++++++ RUC " + ruc);
		Cliente cliente = rr.getClienteByRuc(ruc);
		if (cliente != null) {
			this.convertirClienteDto(cliente);
			// System.out.println("++++++++++++++ Razon Social " +
			// cliente.getRazonSocial());
			Set<ClienteSucursal> list = cliente.getClienteSucursales();
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				ClienteSucursal clienteSucursal = (ClienteSucursal) iterator
						.next();
				ClienteSucursalDTO v = new ClienteSucursalDTO();
				v.setId(clienteSucursal.getId());
				v.setNombre(clienteSucursal.getNombre());
				v.setDireccion(clienteSucursal.getDireccion());
				v.setTelefono(clienteSucursal.getTelefono());
				this.sucursales.add(v);
			}
		}
	}

	public void convertirClienteDto(Cliente cliente) {
		ClienteDTO c = new ClienteDTO();
		c.setId(cliente.getId());
		c.setRazonSocial(cliente.getRazonSocial());
		c.setRuc(cliente.getRuc());
		this.selectedCliente = c;
	}

	@Command
	@NotifyChange("selectedCliente")
	public void actualizarClienteSucursal() {
		this.dto.setClienteSucursal(selectedClienteSucursal);
	}

	@Command
	public void actualizarCondicion() {
		this.dto.setCondicionVenta(selectedCondicion.getText());
	}

	@Command
	@NotifyChange("total")
	public void calcularTotal() {
		total = 0;
		List<VentaDetalleDTO> detalles = this.dto.getVentaDetalles();
		double sumParcial = 0;
		for (VentaDetalleDTO d : detalles) {
			sumParcial = d.getMontoExentas() + d.getMontoGravadasCinco()
					+ d.getMontoGravadasDiez();
			total = total + sumParcial;
		}
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
		return new VentaAssembler();
	}

	@Override
	public DTO getDTOCorriente() {
		return dto;
	}

	@Override
	public void setDTOCorriente(DTO dto) {
		this.dto = (VentaDTO) dto;

	}

	String autoNroKey = Configuracion.NRO_VENTA;

	@Override
	public DTO nuevoDTO() throws Exception {
		VentaDTO dtoNuevo = new VentaDTO();
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
		return Venta.class.getName();
	}

	@Override
	public List<DTO> getAllModel() throws Exception {
		return this.getAllDTOs(this.getEntidadPrincipal());
	}

	public Browser getBrowser() {
		return new VentaBrowser();
	}

	// Eliminar detalles de la venta

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
		for (VentaDetalleDTO d : this.dto.getVentaDetalles()) {
			d.setChecked(this.checked);
		}
	}

	public List<VentaDetalleDTO> itemsParaEliminar() {
		List<VentaDetalleDTO> out = new ArrayList<VentaDetalleDTO>();
		for (VentaDetalleDTO d : this.dto.getVentaDetalles()) {
			if (d.isChecked() == true) {
				out.add(d);
			}
		}
		return out;
	}

	public String codigosItemsParaEliminar() {
		String out = "";
		for (VentaDetalleDTO d : this.itemsParaEliminar()) {
			out = out + d.getProducto().getCodigo() + "\n";
		}
		return out;
	}

	public void removerItem() {
		for (VentaDetalleDTO d : this.itemsParaEliminar()) {
			this.dto.getVentaDetalles().remove(d);
		}
	}

	// Agregar detalles a la venta

	@Command()
	@NotifyChange("*")
	public void insertarItemDetalle() throws Exception {
		// System.out.println("+++++++++++++++++++++ Entro a insertar iteem");
		// Suponiendo que cada factura tiene como maximo 20 detalles
		if (this.dto.getVentaDetalles().size() <= 2) {
			this.buscarProducto();
		} else {
			mensajeError("No se pueden agregar más detalles a la venta.");
		}
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

				for (VentaDetalleDTO det : this.dto.getVentaDetalles()) {
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
					producto.setPrecio((double) selectedArticulo.getPos5());

					// setear el dto detalle
					this.dtoDetalle = new VentaDetalleDTO();
					this.dtoDetalle.setProducto(producto);
					this.dtoDetalle.setPrecioFinal(producto.getPrecio());

					this.dto.getVentaDetalles().add(this.dtoDetalle);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Command
	@NotifyChange("*")
	public void validarCantidadPedida(@BindingParam("d") VentaDetalleDTO det) {
		long stock = det.getProducto().getCantidad();
		long cant = det.getCantidad();
		double precioFinal = det.getPrecioFinal();
		if (cant <= stock) {
			det.setMontoGravadasDiez(cant * precioFinal);
		} else {
			mensajeError("No existe la cantidad pedida.");
		}
	}

	@Command
	@NotifyChange("*")
	public void aplicarDescuento(@BindingParam("d") VentaDetalleDTO det) {
		double precio = det.getPrecioFinal();
		int descuento = det.getDescuento();
		if (descuento > 0) {
			double montoDescuento = precio * (descuento / 100);
			det.setPrecioFinal(precio - montoDescuento);
		} else {
			mensajeError("No existe la cantidad pedida.");
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

	@Command
	public void generarPlantilla() throws Exception {
		HashMap<String, String> flat = new HashMap<String, String>();

		// llenar el map con <tag,valor>

		flat.put("__fechacarta__", "1 de enero de 2014");
		flat.put("__destinatario__", "Destinatario Prueba");
		flat.put("__direccion__", "Direccion Prueba");
		flat.put("__ciudad__", "Asuncion - Paraguay");
		flat.put("__total__", "1500000");
		flat.put("__documentosvencidos__", "vacia");

		System.out.println("======== generando archivo ");

		// InputStream input2 = new ByteArrayInputStream(archivo);
		InputStream input2 = null;
		try {
			input2 = new FileInputStream(new File(
					"/home/verena/financiero/financiero/CartaReclamo.docx"));
		} catch (FileNotFoundException e1) {
			System.out.println("No se puedo cargar el archivo docx");
		}

		// Cargar el archivo docx
		WordprocessingMLPackage wordMLPackage = null;
		try {
			wordMLPackage = Docx4J.load(input2);
		} catch (Docx4JException e) {
			System.out.println("No se puedo cargar el archivo");
		}

		PlantillasDocX.replaceAllWithString(flat.keySet(), flat, wordMLPackage);

		ByteArrayOutputStream os = new ByteArrayOutputStream();

		try {
			wordMLPackage.save(os);
		} catch (Docx4JException e) {
			System.out.println("Error al guardar la plantilla");
		}

		byte[] bytes = os.toByteArray();

		InputStream input3 = new ByteArrayInputStream(bytes);

		// DefaultStreamedContent downFile = new DefaultStreamedContent(input3,
		// "docx", "CARTA_RECLAMO" + ".docx");

		FileOutputStream fos = new FileOutputStream("/home/verena/financiero/"
				+ "CARTA_RECLAMO_" + new Date() + ".docx");
		fos.write(bytes);
		fos.close();

		// System.out.println("archivo final ==> " + downFile.getName());
	}
}
