package Serveur.Serveur.model;

public class Client implements IClient {
	// ATTRIBUTS
	/**
	 * Nom de l'entreprise.
	 */
	private String entite;
	/**
	 * Nom du client de l'entreprise.
	 */
	private String nom;
	/**
	 * Prénom du client de l'entreprise.
	 */
	private String prenom;
	/**
	 * Pays de l'entreprise.
	 */
	private String pays;
	/** 
	 * Ville de l'entreprise.
	 */
	private String ville;
	/**
	 * Rue de l'entreprise.
	 */
	private String rue;
	/**
	 * Code postal de l'entreprise.
	 */
	private int cp;

	public Client() {
		
	}
	
	public String getEntite() {
		return entite;
	}

	public void setEntite(String entite) {
		this.entite = entite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}
}
