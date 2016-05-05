package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="stb")
public class STB {
	private String titre;
	
	private String version;
	
	private String date;
	
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
