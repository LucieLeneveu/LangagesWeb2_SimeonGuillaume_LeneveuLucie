package Serveur.Serveur.model;

public interface IExigence {
	/**
	 * @return
	 * 	L'dentifiant de l'exigence.
	 */
	public int getId();

	/**
	 * @param id
	 * 	L'identifiant à ajouté.
	 */
	public void setId(int id);

	/**
	 * @return	
	 * 	La description de l'exigence.
	 */
	public String getDescription();

	/**
	 * @param description
	 * 	La description à ajouté.
	 */
	public void setDescription(String description);
	
	/**
	 * @return
	 * 	La priorité de l'exigence.
	 */
	public int getPriorite();

	/**
	 * @param priorite
	 * 	La priorité à ajouté.
	 */
	public void setPriorite(int priorite);
}
