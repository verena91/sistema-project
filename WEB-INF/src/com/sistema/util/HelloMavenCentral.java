package com.sistema.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;

import org.docx4j.Docx4J;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

public class HelloMavenCentral {

	public static void xmain(String[] args) throws Exception {

		WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
				.createPackage();

		wordMLPackage.getMainDocumentPart().addStyledParagraphOfText("Title",
				"Hello Maven Central");

		wordMLPackage.getMainDocumentPart().addParagraphOfText("from docx4j!");

		// Now save it
		wordMLPackage.save(new java.io.File(System.getProperty("user.dir")
				+ "/helloMavenCentral.docx"));

	}

	public static void main(String[] args) throws Exception {
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

		//DefaultStreamedContent downFile = new DefaultStreamedContent(input3,
			//	"docx", "CARTA_RECLAMO" + ".docx");

		FileOutputStream fos = new FileOutputStream("/home/verena/financiero/"
				+ "CARTA_RECLAMO_" + new Date() + ".docx");
		fos.write(bytes);
		fos.close();

		//System.out.println("archivo final ==> " + downFile.getName());
	}
}
