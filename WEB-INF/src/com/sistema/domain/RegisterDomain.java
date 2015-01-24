package com.sistema.domain;

import java.util.List;
import java.util.Random;

import com.coreweb.domain.Ping;
import com.coreweb.domain.Register;
import com.coreweb.domain.Tipo;
import com.coreweb.util.Misc;

public class RegisterDomain extends Register {

	private static RegisterDomain instance = new RegisterDomain();

	static int pos = 10;
	static RegisterDomain[] list = null;
	static Random r = new Random();

	private RegisterDomain() {
	}

	public synchronized static RegisterDomain NO_getInstance() {
		if (instance == null) {
			list = new RegisterDomain[15];
			for (int i = 0; i < 15; i++) {
				list[i] = new RegisterDomain();
			}
			instance = new RegisterDomain();
		}
		return list[r.nextInt(pos) + 1];
	}

	public synchronized static RegisterDomain getInstance() {
		if (instance == null) {
			instance = new RegisterDomain();
		}
		return instance;
	}

	public List<Familia> getAllFamilias() throws Exception {
		List<Familia> out = super.getObjects(com.sistema.domain.Familia.class
				.getName());
		return out;
	}

	public List<Cliente> getAllClientes() throws Exception {
		List<Cliente> out = super.getObjects(com.sistema.domain.Cliente.class
				.getName());
		return out;
	}

	public List<ClienteSucursal> getAllClienteSucursales() throws Exception {
		List<ClienteSucursal> out = super
				.getObjects(com.sistema.domain.ClienteSucursal.class.getName());
		return out;
	}

	public List<Cobro> getAllCobros() throws Exception {
		List<Cobro> out = super.getObjects(com.sistema.domain.Cobro.class
				.getName());
		return out;
	}

	public List<Compra> getAllCompras() throws Exception {
		List<Compra> out = super.getObjects(com.sistema.domain.Compra.class
				.getName());
		return out;
	}

	public List<CompraDetalle> getAllCompraDetalles() throws Exception {
		List<CompraDetalle> out = super
				.getObjects(com.sistema.domain.CompraDetalle.class.getName());
		return out;
	}

	public List<Devolucion> getAllDevoluciones() throws Exception {
		List<Devolucion> out = super
				.getObjects(com.sistema.domain.Devolucion.class.getName());
		return out;
	}

	public List<DevolucionDetalle> getAllDevolucionDetalles() throws Exception {
		List<DevolucionDetalle> out = super
				.getObjects(com.sistema.domain.DevolucionDetalle.class
						.getName());
		return out;
	}

	public List<Pago> getAllPagos() throws Exception {
		List<Pago> out = super.getObjects(com.sistema.domain.Pago.class
				.getName());
		return out;
	}

	public List<Producto> getAllProductos() throws Exception {
		List<Producto> out = super.getObjects(com.sistema.domain.Producto.class
				.getName());
		return out;
	}

	public List<Proveedor> getAllProveedores() throws Exception {
		List<Proveedor> out = super
				.getObjects(com.sistema.domain.Proveedor.class.getName());
		return out;
	}

	public List<ProveedorSucursal> getAllProveedorSucursales() throws Exception {
		List<ProveedorSucursal> out = super
				.getObjects(com.sistema.domain.ProveedorSucursal.class
						.getName());
		return out;
	}

	public List<Venta> getAllVentas() throws Exception {
		List<Venta> out = super.getObjects(com.sistema.domain.Venta.class
				.getName());
		return out;
	}

	public List<VentaDetalle> getAllVentaDetalles() throws Exception {
		List<VentaDetalle> out = super
				.getObjects(com.sistema.domain.VentaDetalle.class.getName());
		return out;
	}

	/**
	 * Recibe la clave encriptada y la verifica contra la del usuario pasado
	 * como parametro
	 * 
	 * @param clave
	 * @param usuario
	 * @return true si es valdio el login y false de lo contrario
	 * @throws Exception
	 */
	public boolean validarUsuario(String clave, String usuario)
			throws Exception {
		String query = "select u.clave from Usuario u where u.login='"
				+ usuario + "'";
		List<Object> list = null;
		list = this.hql(query);
		if (list.size() > 0 && clave.compareTo((String) list.get(0)) == 0) {
			return true;
		} else {
			return false;
		}

	}

	public List<Tipo> getTipos(String tipoTipoDescripcion) throws Exception {
		List<Tipo> list = null;
		String query = "select t from Tipo t where t.tipoTipo.descripcion = '"
				+ tipoTipoDescripcion + "'";
		list = this.hql(query);
		return list;
	}

	public AccesoApp getAcceso(String login) throws Exception {
		List<AccesoApp> list = null;
		AccesoApp a = new AccesoApp();
		String queryAcceso = "" + " select ac " + " from AccesoApp ac"
				+ " where ac.usuario.login = ? ";
		list = this.hql(queryAcceso, login);
		if (list.size() == 1) {
			a = list.get(0);
		} else {
			throw new Exception(
					"Error: Este usuario no tiene ningun acceso asignado.");
		}
		return a;
	}

	Misc m = new Misc();

	/**
	 * Retorna la Razon Social correspondiente al ruc segun la BD del SET
	 */
	public String getRazonSocialSET(String ruc) throws Exception {
		RucSet set = (RucSet) this.getObject(RucSet.class.getName(), "ruc",
				ruc.trim());
		if (set == null) {
			return "";
		}
		return set.getRazonSocial();
	}

	/**
	 * Retorna el Cliente recibiendo el ruc
	 */
	public Cliente getClienteByRuc(String ruc) throws Exception {
		String query = "select c from Cliente c where c.ruc" + " like '" + ruc
				+ "'";
		List<Cliente> list = this.hql(query);
		if (list.size() == 1) {
			return list.get(0);
		} else {
			return null;
		}
	}

	/**
	 * Retorna el Proveedor recibiendo el ruc
	 */
	public Proveedor getProveedorByRuc(String ruc) throws Exception {
		String query = "select c from Proveedor c where c.ruc" + " like '"
				+ ruc + "'";
		List<Proveedor> list = this.hql(query);
		if (list.size() == 1) {
			return list.get(0);
		} else {
			return null;
		}
	}

	/**
	 * Retorna el Cliente recibiendo la cedula
	 */
	public Cliente getClienteByCedula(String cedula) throws Exception {
		String query = "select c from Cliente c where c.cedula" + " like '"
				+ cedula + "'";
		List<Cliente> list = this.hql(query);
		if (list.size() == 1) {
			return list.get(0);
		} else {
			return null;
		}
	}

	/**
	 * Retorna la Venta recibiendo el numero
	 */
	public Venta getVentaByNumero(String numero) throws Exception {
		String query = "select v from Venta v where v.numero" + " like '"
				+ numero + "'";
		List<Venta> list = this.hql(query);
		if (list.size() == 1) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		try {
			RegisterDomain rr = RegisterDomain.getInstance();
			Ping p = new Ping();

			rr.saveObject(p, "prueba");
			System.out.println("ok!");

			Cliente c = rr.getClienteByRuc("3893208");
			System.out.println(c.getRazonSocial());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
