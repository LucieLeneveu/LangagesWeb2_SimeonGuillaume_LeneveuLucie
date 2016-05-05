package Client.Client;

public enum ColumnFonctionnalite {
    
    FONCTIONNALITES("Description", String.class) {
        @Override public String value(String v) { return v; }
        @Override public String defaultValue() { return ""; }
    },
    
    PRIORITE("Priorité", Integer.class) {
        @Override public Integer value(String v) {
            return Integer.parseInt(v.trim());
        }
        @Override public Double defaultValue() { return NoteTableModel.ZERO; }
    };

    // ATTRIBUTS
    
    private String header;
    private Class<?> cellType;

    // CONSTRUCTEURS
    
    ColumnFonctionnalite(String n, Class<?> c) {
        header = n;
        cellType = c;
    }

    // REQUETES
    
    /**
     * Valeur par d�faut pour cette colonne.
     */
    public abstract Object defaultValue();
    
    /**
     * Valeur pour cette colonne.
     */
    public abstract Object value(String v);
    
    /**
     * Ent�te de cette colonne.
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
