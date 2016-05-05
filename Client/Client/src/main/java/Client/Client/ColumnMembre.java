package Client.Client;

public enum ColumnMembre {
    
    NOM("Description", String.class) {
        @Override public String value(String v) { return v; }
        @Override public String defaultValue() { return ""; }
    },
    
    PRENOM("Priorité", Integer.class) {
        @Override public Integer value(String v) {
            return Integer.parseInt(v.trim());
        }
        @Override public Double defaultValue() { return NoteTableModel.ZERO; }
    },
    
    GENRE("Genre", Boolean.class) {
		@Override
		public Double defaultValue() {
			return NoteTableModel.ZERO;
		}
		@Override
		public Object value(String v) {
			return Boolean.parseBoolean(v.trim());
		}
    	
    };

    // ATTRIBUTS
    private String header;
    private Class<?> cellType;

    // CONSTRUCTEURS
    ColumnMembre(String n, Class<?> c) {
        header = n;
        cellType = c;
    }

    // REQUETES
    /**
     * Valeur par défaut pour cette colonne.
     */
    public abstract Object defaultValue();
    
    /**
     * Valeur pour cette colonne.
     */
    public abstract Object value(String v);
    
    /**
     * Entête de cette colonne.
     */
    public String header() {
        return header;
    }
    
    /**
     * Type des cellules constituant cette colonne.
     */
    Class<?> type() {
        return cellType;
    }
}
