package com.sistema.util.population;

import java.util.HashSet;
import java.util.Set;

import com.coreweb.domain.Domain;
import com.coreweb.domain.Usuario;
import com.coreweb.util.Misc;
import com.sistema.Configuracion;
import com.sistema.domain.AccesoApp;
import com.sistema.domain.Cliente;
import com.sistema.domain.ClienteSucursal;
import com.sistema.domain.Familia;
import com.sistema.domain.Presentacion;
import com.sistema.domain.Producto;
import com.sistema.domain.Proveedor;
import com.sistema.domain.ProveedorSucursal;
import com.sistema.domain.RegisterDomain;

public class DBPopulation {

	private static RegisterDomain rr = RegisterDomain.getInstance();

	private static Misc misc = new Misc();

	private static void grabarDB(Domain d) throws Exception {
		rr.saveObject(d, Configuracion.USER_SYSTEMA);
	}

	public static void main(String[] args) throws Exception {

		rr.dropAllTables();
		DBPopulationTipos tt = new DBPopulationTipos();
		tt.cargarTipos();
		UsuarioPerfilParser.loadMenuConfig();

		// Accesos
		Usuario usr1 = (Usuario) rr.getObject(Usuario.class.getName(),
				new Long(1));

		Usuario usr2 = (Usuario) rr.getObject(Usuario.class.getName(),
				new Long(2));

		Usuario usr3 = (Usuario) rr.getObject(Usuario.class.getName(),
				new Long(3));

		AccesoApp ac1 = new AccesoApp();
		ac1.setDescripcion("acceso 1");
		ac1.setUsuario(usr1);

		grabarDB(ac1);

		AccesoApp ac2 = new AccesoApp();
		ac2.setDescripcion("acceso 2");
		ac2.setUsuario(usr2);

		grabarDB(ac2);

		AccesoApp ac3 = new AccesoApp();
		ac3.setDescripcion("acceso 3");
		ac3.setUsuario(usr3);

		grabarDB(ac3);

		Familia familiaPalmito = new Familia();
		familiaPalmito.setNombre("Palmito");

		Familia familiaMani = new Familia();
		familiaMani.setNombre("Maní");

		Presentacion presPalmitoTrozo = new Presentacion();
		presPalmitoTrozo.setNombre("Trozo 800x24");
		grabarDB(presPalmitoTrozo);

		Presentacion presPalmitoEntero = new Presentacion();
		presPalmitoEntero.setNombre("Entero 800x24");
		grabarDB(presPalmitoEntero);

		Set<Presentacion> presFamiliaPalmito = new HashSet<Presentacion>();
		presFamiliaPalmito.add(presPalmitoTrozo);
		presFamiliaPalmito.add(presPalmitoEntero);

		familiaPalmito.setPresentaciones(presFamiliaPalmito);
		grabarDB(familiaPalmito);

		Presentacion presManiSalado = new Presentacion();
		presManiSalado.setNombre("Salado 100x36");
		grabarDB(presManiSalado);

		Presentacion presManiTostado = new Presentacion();
		presManiTostado.setNombre("Tostado 100x36");
		grabarDB(presManiTostado);

		Presentacion presManiRecubierto = new Presentacion();
		presManiRecubierto.setNombre("Recubierto 170x48");
		grabarDB(presManiRecubierto);

		Presentacion presManiPicante = new Presentacion();
		presManiPicante.setNombre("Picante 170x48");
		grabarDB(presManiPicante);

		Set<Presentacion> presFamiliaMani = new HashSet<Presentacion>();
		presFamiliaMani.add(presManiSalado);
		presFamiliaMani.add(presManiTostado);
		presFamiliaMani.add(presManiRecubierto);
		presFamiliaMani.add(presManiPicante);

		familiaMani.setPresentaciones(presFamiliaMani);
		grabarDB(familiaMani);

		// Carga de dos producto de prueba
		Producto producto1 = new Producto();
		producto1.setCodigo("7840134000018");
		producto1.setDescripcion("Palmito Arandu Tradicional");
		producto1.setFamilia(familiaPalmito);
		producto1.setPresentacion(presPalmitoEntero);
		producto1.setUnidadDeMedida(tt.unidad_gr);
		producto1.setCantidad(10);
		producto1.setPrecio(37000);

		Producto producto2 = new Producto();
		producto2.setCodigo("7840134000018");
		producto2.setDescripcion("Mani Arandu Salado");
		producto2.setFamilia(familiaMani);
		producto2.setPresentacion(presManiSalado);
		producto2.setUnidadDeMedida(tt.unidad_gr);
		producto2.setCantidad(15);
		producto2.setPrecio(7000);

		grabarDB(producto1);
		grabarDB(producto2);

		Cliente cliente = new Cliente();
		cliente.setRuc("3893208-3");
		cliente.setRazonSocial("Verena Ojeda");
		cliente.setCorreo("vereojeda@gmail.com");

		ClienteSucursal clienteSucu = new ClienteSucursal();
		clienteSucu.setNombre("Sucursal 1");
		clienteSucu.setDireccion("Direccion 1");
		clienteSucu.setTelefono("111-111");
		
		ClienteSucursal clienteSucu2 = new ClienteSucursal();
		clienteSucu2.setNombre("Sucursal 2");
		clienteSucu2.setDireccion("Direccion 2");
		clienteSucu2.setTelefono("222-222");
		
		cliente.getClienteSucursales().add(clienteSucu);
		cliente.getClienteSucursales().add(clienteSucu2);
		
		grabarDB(cliente);
		
		Proveedor proveedor = new Proveedor();
		proveedor.setRuc("3893208-3");
		proveedor.setRazonSocial("Verena Ojeda");
		proveedor.setCorreo("vereojeda@gmail.com");

		ProveedorSucursal proveedorSucu = new ProveedorSucursal();
		proveedorSucu.setNombre("Sucursal 1");
		proveedorSucu.setDireccion("Direccion 1");
		proveedorSucu.setTelefono("111-111");
		
		ProveedorSucursal proveedorSucu2 = new ProveedorSucursal();
		proveedorSucu2.setNombre("Sucursal 2");
		proveedorSucu2.setDireccion("Direccion 2");
		proveedorSucu2.setTelefono("222-222");
		
		proveedor.getProveedorSucursales().add(proveedorSucu);
		proveedor.getProveedorSucursales().add(proveedorSucu2);
		
		grabarDB(proveedor);
		

	}
}