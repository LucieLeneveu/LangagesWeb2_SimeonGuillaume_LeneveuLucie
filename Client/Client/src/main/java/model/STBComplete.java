package model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="stb")
public class STBComplete {
	
	private int id;
	
	private String titre;
	
	private String version;
	
	private String date;
	
	private String description;
	
	private String commentaire;
	
	private Client client;
	
	private List<Membre> membres;
	
	private List<Fonctionnalite> fonctionnalites;
	
	public STBComplete() {
		
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the commentaire
	 */
	public String getCommentaire() {
		return commentaire;
	}

	/**
	 * @param commentaire the commentaire to set
	 */
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the membres
	 */
	public List<Membre> getMembres() {
		return membres;
	}

	/**
	 * @param membres the membres to set
	 */
	public void setMembres(List<Membre> membres) {
		this.membres = membres;
	}

	/**
	 * @return the fonctionnalites
	 */
	public List<Fonctionnalite> getFonctionnalites() {
		return fonctionnalites;
	}

	/**
	 * @param fonctionnalites the fonctionnalites to set
	 */
	public void setFonctionnalites(List<Fonctionnalite> fonctionnalites) {
		this.fonctionnalites = fonctionnalites;
	}
}
