package Serveur.Serveur.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="stb")
public class STB implements ISTB {
	/**
	 * Le titre de la stb.
	 */
	private String titre;
	/**
	 * La version de la stb.
	 */
	private String version;
	/**
	 * La date de la stb.
	 */
	private String date;
	/**
	 * La description de la stb.
	 */
	private String description;
	
	public STB() {
		
	}
	
	public String getTitre() {
		return titre;
	}
	
	public String getVersion() {
		return version;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
