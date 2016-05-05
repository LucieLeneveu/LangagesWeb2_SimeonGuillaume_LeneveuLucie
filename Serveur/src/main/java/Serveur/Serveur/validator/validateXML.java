package Serveur.Serveur.validator;


import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class validateXML {
	
	public Document should_validate_with_DOM(String contain) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(false);
		factory.setNamespaceAware(true);

		SchemaFactory schemaFactory = 
		    SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

		try {
			factory.setSchema(schemaFactory.newSchema(
			    new Source[] {new StreamSource("stb1.xsd")}));
		} catch (SAXException e) {
			e.printStackTrace();
		}

		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		SimpleErrorHandler error = new SimpleErrorHandler();
		builder.setErrorHandler(error);

		Document document = null;
		try {
			document = builder.parse(new InputSource(new ByteArrayInputStream(contain.getBytes("utf-8"))));
			if(error.hasError()) {
				return null;
			}
		} catch (SAXException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return document;
	}	
}
