package model;

import java.util.List;

public interface IFonctionnalite {
	/**
	 * @return
	 * 	La description de la fonctionnalité.
	 */
	public String getDescription();

	/**
	 * @param description
	 * 	La description à ajouté.
	 */
	public void setDescription(String description);

	/**
	 * @return
	 * 	La priorité de la fonctionnalité.
	 */
	public int getPriorite();

	/**
	 * @param priorite
	 * 	La priorité à ajouté.
	 */
	public void setPriorite(int priorite);

	/**
	 * @return
	 * 	La liste des exigences de la fonctionnalité.
	 */
	public List<Exigence> getExigences();

	/**
	 * @param exigences
	 * 	La liste des exigences à ajouté.
	 */
	public void setExigences(List<Exigence> exigences);

	/**
	 * @return
	 * 	L'identifiant de la fonctionnalité.
	 */
	public int getIdFonc();

	/**
	 * @param idFonc
	 * 	L'identifiant à ajouté.
	 */
	public void setIdFonc(int idFonc);
}
