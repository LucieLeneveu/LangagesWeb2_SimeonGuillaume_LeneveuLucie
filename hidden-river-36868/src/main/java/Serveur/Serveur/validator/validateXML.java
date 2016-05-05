package Serveur.Serveur.validator;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;

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
			URL url = getClass().getClassLoader().getResource("stb1.xsd");
			System.out.println(url);
			factory.setSchema(schemaFactory.newSchema(
			    new Source[] {new StreamSource(url.getFile())}));
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
		} catch (SAXException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		if(error.hasError()) {
			return null;
		}
		return document;
	}	
}
