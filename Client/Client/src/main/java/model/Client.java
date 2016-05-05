package model;

public class Client {

	private String entite;
	
	private String nom;
	
	private String prenom;
	
	private String pays;
	
	private String ville;
	
	private String rue;
	
	private int cp;

	public Client() {
		
	}
	
	/**
	 * @return the entite
	 */
	public String getEntite() {
		return entite;
	}

	/**
	 * @param entite the entite to set
	 */
	public void setEntite(String entite) {
		this.entite = entite;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
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
