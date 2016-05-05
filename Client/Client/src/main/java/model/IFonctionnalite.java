package model;

import java.util.List;
/**
 * Définit une fonctionnalité.
 *
 */
public interface IFonctionnalite {
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
	public void setPriorite(int priorite);

	/**
	 * @return the exigences
	 */
	public List<Exigence> getExigences();

	/**
	 * @param exigences the exigences to set
	 */
	public void setExigences(List<Exigence> exigences);

	/**
	 * @return the idFonc
	 */
	public int getIdFonc();

	/**
	 * @param idFonc the idFonc to set
	 */
	public void setIdFonc(int idFonc);
}
