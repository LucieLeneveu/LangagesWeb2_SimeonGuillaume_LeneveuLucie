package Serveur.Serveur.model;

import java.util.List;

public interface IList {
	/**
	 * @return
	 * 	La liste des stb.
	 */
	public List<STB> getStbs();

	/**
	 * @param stbs
	 * 	La liste de stb à ajouté.
	 */
	public void setStbs(List<STB> stbs);
}
