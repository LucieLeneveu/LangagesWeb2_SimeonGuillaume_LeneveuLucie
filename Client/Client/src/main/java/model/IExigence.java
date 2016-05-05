package model;

/**
 * Définit une exigence.
 *
 */
public interface IExigence {
	/**
	 * @return the id
	 */
	public int getId();

	/**
	 * @param id the id to set
	 */
	public void setId(int id);

	/**
	 * @return the description
	 */
	public String getDescription();

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description);

	/**
	 * @return the priorite
	 */
	public int getPriorite();

	/**
	 * @param priorite the priorite to set
	 */
	public void setPriorite(int priorite) ;
}
