package model;

import java.util.List;

/**
 * Définit une liste de STBs
 *
 */

public interface IListe {
	/**
	 * @return stb list
	 */
	public List<STB> getStbs();

	/**
	 * @param stbs : set stb list
	 */
	public void setStbs(List<STB> stbs);
}
