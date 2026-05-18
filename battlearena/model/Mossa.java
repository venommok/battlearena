package battlearena.model;

// Descrive una mossa eseguibile in combattimento.
public interface Mossa {
    /** Nome della mossa. */
    String getNome();

    /** Potenza della mossa. */
    int getPotenza();

    /** Esegue la mossa e restituisce il testo di log. */
    String esegui(Personaggio attaccante, Personaggio difensore);

    @Override
    String toString();
}