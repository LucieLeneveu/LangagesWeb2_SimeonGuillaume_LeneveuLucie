package Serveur.Serveur.model;


public class Membre implements IMembre {
	/**
	 * Le nom du membre.
	 */
	private String nom;
	/**
	 * Le prénom du membre.
	 */
	private String prenom;
	/**
	 * Le genre du membre.
	 */
	private boolean genre;
	
	public Membre() {
		
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

	public boolean isGenre() {
		return genre;
	}

	public void setGenre(boolean genre) {
		this.genre = genre;
	}
}
