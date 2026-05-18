package battlearena.model;

// Gestisce il salvataggio di log e risultati.
public interface GestoreSalvataggio {
    /** Registra un'azione nel log persistente. */
    void registraAzioneLog(String azione) throws Exception;

    /** Salva il nome del vincitore. */
    void salvaVincitore(String nomePersonaggio) throws Exception;
}