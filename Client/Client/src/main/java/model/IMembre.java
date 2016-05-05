package model;

public interface IMembre {
	/**
	 * @return the nom
	 */
	public String getNom();

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom);

	/**
	 * @return the prenom
	 */
	public String getPrenom();

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom);

	/**
	 * @return the genre
	 */
	public boolean isGenre();

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(boolean genre);
}
