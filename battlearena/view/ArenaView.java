package battlearena.view;

import battlearena.model.Mossa;

public interface ArenaView {
    void impostaAzioneTurno(TurnoListener listener);

    void aggiornaHpP1(int hpAttuale, int hpMax);
    void aggiornaHpP2(int hpAttuale, int hpMax);

    // Aggiungi queste due righe qui nel contratto:
    void aggiornaEnergyP1(int energiaAttuale, int energiaMax);
    void aggiornaEnergyP2(int energiaAttuale, int energiaMax);

    int scegliMossa(String nomeAttaccante, Mossa[] nomiMosse);
    void aggiungiTestoLog(String testo);
    void disabilitaBottoneTurno();
    void mostraSchermataFinePartita(String vincitore);
    void mostra();
}