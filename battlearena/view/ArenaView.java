package battlearena.view;

import battlearena.model.Mossa;

// Contratto della vista: nessuna dipendenza dall'implementazione grafica.
public interface ArenaView {
    /** Collega l'azione del turno alla vista. */
    void impostaAzioneTurno(TurnoListener listener);

    /** Aggiorna gli HP del personaggio 1. */
    void aggiornaHpP1(int hpAttuale, int hpMax);

    /** Aggiorna gli HP del personaggio 2. */
    void aggiornaHpP2(int hpAttuale, int hpMax);

    /** Chiede all'utente quale mossa usare. */
    int scegliMossa(String nomeAttaccante, Mossa[] nomiMosse);

    /** Aggiunge una riga al log. */
    void aggiungiTestoLog(String testo);

    /** Disabilita il bottone del turno. */
    void disabilitaBottoneTurno();

    /** Mostra la schermata di fine partita. */
    void mostraSchermataFinePartita(String vincitore);
    
    /** Rende visibile la vista. */
    void mostra();
}