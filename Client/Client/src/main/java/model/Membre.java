package model;


public class Membre {
	
	private String nom;
	
	private String prenom;
	
	private boolean genre;
	
	public Membre() {
		
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

	/**
	 * @return the genre
	 */
	public boolean isGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(boolean genre) {
		this.genre = genre;
	}
}
