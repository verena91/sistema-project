package com.sistema;

import java.util.ArrayList;
import java.util.List;

import com.coreweb.dto.UtilCoreDTO;
import com.coreweb.util.MyArray;
import com.coreweb.util.MyPair;

public class UtilDTO extends UtilCoreDTO {

	private List<MyPair> unidades = new ArrayList<MyPair>();
	private MyPair unidadGr = new MyPair();
	private MyPair unidadMl = new MyPair();
	private MyPair unidadCc = new MyPair();
	private List<MyPair> condiciones = new ArrayList<MyPair>();

	private List<MyArray> familias = new ArrayList<MyArray>();

	public List<MyPair> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<MyPair> unidades) {
		this.unidades = unidades;
	}

	public MyPair getUnidadGr() {
		return unidadGr;
	}

	public void setUnidadGr(MyPair unidadGr) {
		this.unidadGr = unidadGr;
	}

	public MyPair getUnidadMl() {
		return unidadMl;
	}

	public void setUnidadMl(MyPair unidadMl) {
		this.unidadMl = unidadMl;
	}

	public MyPair getUnidadCc() {
		return unidadCc;
	}

	public void setUnidadCc(MyPair unidadCc) {
		this.unidadCc = unidadCc;
	}

	public List<MyArray> getFamilias() {
		return familias;
	}

	public void setFamilias(List<MyArray> familias) {
		this.familias = familias;
	}

	public List<MyPair> getCondiciones() {
		return condiciones;
	}

	public void setCondiciones(List<MyPair> condiciones) {
		this.condiciones = condiciones;
	}

}
