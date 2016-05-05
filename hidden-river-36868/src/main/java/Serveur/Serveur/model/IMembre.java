package Serveur.Serveur.model;

public interface IMembre {
	/**
	 * @return
	 * 	Le nom du membre.
	 */
	public String getNom();

	/**
	 * @param nom
	 * 	Le nom à ajouté.
	 */
	public void setNom(String nom);

	/**
	 * @return
	 * 	Le prénom du membre.
	 */
	public String getPrenom();

	/**
	 * @param prenom
	 * 	Le prénom à ajouté.
	 */
	public void setPrenom(String prenom);

	/**
	 * @return
	 * 	Le genre du membre.
	 */
	public boolean isGenre();
	
	/**
	 * @param genre
	 * 	Le genre à ajouté.
	 */
	public void setGenre(boolean genre);
}
