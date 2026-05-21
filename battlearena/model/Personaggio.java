package battlearena.model;

// Dati e comportamenti base di un personaggio.
public interface Personaggio {
    enum TipoPersonaggio {
        FUOCO, ACQUA, ERBA
    }

    public void setEnergia(int energia);

    public int getEnergia();
    public int getEnergiaMax();
    public int getEnergiaMin();

    /** Nome visualizzato del personaggio. */
    String getNome();

    /** HP attuali del personaggio. */
    int getHp();

    /** HP massimi del personaggio. */
    int getHpMax();

    /** Applica un danno al personaggio. */
    void subisciDanno(int danno);

    /** Indica se il personaggio e ancora vivo. */
    boolean isVivo();

    TipoPersonaggio getTipo();

    /** Elenco delle mosse disponibili. */
    Mossa[] getMosseDisponibili();

    /** Percorso dell'immagine per l'icona. */
    String getPercorsoImmagine();
}