package Serveur.Serveur.validator;


import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class SimpleErrorHandler implements ErrorHandler{
	private boolean errorOccured=false;
	public void warning(SAXParseException exception) throws SAXException {
		 errorOccured=true;
		 exception.getMessage();
	}

	public void error(SAXParseException exception) throws SAXException {
		 errorOccured=true;
		 exception.getMessage();
	}

	public void fatalError(SAXParseException exception) throws SAXException {
		 errorOccured=true;
		exception.getMessage();
	}
	public boolean hasError() {
		return errorOccured;
		
	}
}
