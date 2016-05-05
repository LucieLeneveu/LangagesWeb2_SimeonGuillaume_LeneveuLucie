package Client.Client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class FonctionnaliteTableModel extends AbstractTableModel 
	implements NoteTableModel {
	
	// ATTRIBUTS
	/**
	 * Contiendra les lignes de la table.
	 */
	private List<List<Object>> list;
	
	// CONSTRUCTEUR
	public FonctionnaliteTableModel() {
		list = new ArrayList<List<Object>>();
	}
	
	// REQUETES
	@Override
	public Class<?> getColumnClass(int index) {
		return ColumnFonctionnalite.values()[index].type();
	}

	/**
	 * @return 
	 * 	Le nombre de colonne.
	 */
	public int getColumnCount() {
		return ColumnFonctionnalite.values().length;
	}

	@Override
	public String getColumnName(int index) {
		return ColumnFonctionnalite.values()[index].header();
	}

	/**
	 * @return 
	 * 	Permet de renvoyer une liste d'objets représentant une liste 
	 * type.
	 */
	public List<Object> getEmptyDataRow() {
		List<Object> emptyRow = new ArrayList<Object>();
		emptyRow.addAll(Arrays.asList("", ZERO, ZERO));
		return emptyRow;
	}

	/**
	 * @return
	 * 	Permet de renvoyer le nombre de ligne de la table.
	 */
	public int getRowCount() {
		return list.size();
	}

	/**
	 * @param row
	 * 	ligne sur laquel on récupère la valeur
	 * @param column 
	 * 	colonne sur laquel on récupère al valeur
	 * @return 
	 * 	L'objet situé à la ligne row et la colonne column
	 */
	public Object getValueAt(int row, int column) {
		return list.get(row).get(column);
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return column != getColumnCount() - 1;
	}
	
	// COMMANDES
	/**
	 * Permet d'ajouter la ligne line à la fin de la table.
	 * @param line 
	 * 	ligne que l'on doit ajouter à la table
	 */
	public void addRow(List<Object> line) {
		list.add(line);
		fireTableRowsInserted(list.size() - 1, list.size() - 1);
	}

	/**
	 * Permet de supprimer toutes les lignes de la table.
	 */
	public void clearRows() {
		list.clear();
		fireTableStructureChanged();
	}

	/**
	 * Permet d'ajouter une ligne à une position précise dans la table.
	 * @param line
	 * 	ligne que l'on doit insérer
	 * @param index
	 * 	index où l'on doit insérer la ligne
	 */
	public void insertRow(List<Object> line, int index) {
		list.add(index, line);
		fireTableRowsInserted(index, index);
	}
	/**
	 * Permet de supprimer une ligne de la table.
	 * @param index
	 * 	index de l'objet que l'on doit supprimer
	 */
	public void removeRow(int index) {
		list.remove(index);
		fireTableRowsDeleted(index, index);
	}

	@Override
	public void setValueAt(Object value, int row, int column) {
		list.get(row).set(column, value);
		if (column == 0) {
			fireTableCellUpdated(row, column);
		} else {
			fireTableRowsUpdated(row, row);
		}
	}
}
