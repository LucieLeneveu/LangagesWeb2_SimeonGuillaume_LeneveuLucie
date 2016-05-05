package Serveur.Serveur.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="stb")
public class STBComplete implements ISTBComplete {
	/**
	 * Identifiant de la stb.
	 */
	private int id;
	/**
	 * Titre de la stb.
	 */
	private String titre;
	/**
	 * Version de la stb.
	 */
	private String version;
	/**
	 * Date de la stb.
	 */
	private String date;
	/**
	 * Description de la stb.
	 */
	private String description;
	/**
	 * Eventuel commentaire de la stb.
	 */
	private String commentaire;
	/**
	 * Cleint de l'entreprise.
	 */
	private Client client;
	/**
	 * Liste des membres de la stb.
	 */
	private List<Membre> membres;
	/**
	 * Liste des focntionnalités de la stb.
	 */
	private List<Fonctionnalite> fonctionnalites;
	
	public STBComplete() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Membre> getMembres() {
		return membres;
	}

	public void setMembres(List<Membre> membres) {
		this.membres = membres;
	}

	public List<Fonctionnalite> getFonctionnalites() {
		return fonctionnalites;
	}

	public void setFonctionnalites(List<Fonctionnalite> fonctionnalites) {
		this.fonctionnalites = fonctionnalites;
	}
}
