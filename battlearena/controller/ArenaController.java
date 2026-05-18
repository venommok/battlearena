package battlearena.controller;

import battlearena.model.GestoreSalvataggio;
import battlearena.model.Personaggio;
import battlearena.model.Mossa;
import battlearena.view.ArenaView;
import battlearena.view.TurnoListener;

public class ArenaController {
    private final ArenaView view;
    private final Personaggio p1;
    private final Personaggio p2;
    @SuppressWarnings("unused")
    private final GestoreSalvataggio salvataggio;
    private boolean turnoP1;

    public ArenaController(ArenaView view, Personaggio p1, Personaggio p2, GestoreSalvataggio salvataggio) {
        this.view = view;
        this.p1 = p1;
        this.p2 = p2;
        this.salvataggio = salvataggio;
        this.turnoP1 = true;

        view.impostaAzioneTurno(new TurnoListener() {
            @Override
            public void onTurno() {
                gestisciTurno();
            }
        });

        view.aggiornaHpP1(p1.getHp(), p1.getHpMax());
        view.aggiornaHpP2(p2.getHp(), p2.getHpMax());
    }

    private void gestisciTurno() {
        Personaggio attaccante = turnoP1 ? p1 : p2;
        Mossa[] mosse = attaccante.getMosseDisponibili();
        if (mosse == null || mosse.length == 0) {
            view.aggiungiTestoLog("Nessuna mossa disponibile per " + attaccante.getNome());
            return;
        }

        int scelta = view.scegliMossa(attaccante.getNome(), mosse);
        if (scelta < 0 || scelta >= mosse.length) {
            view.aggiungiTestoLog("Turno annullato.");
            return;
        }

        if (partitaTerminata()) {
            view.aggiungiTestoLog("Partita gia terminata.");
            view.aggiornaHpP1(Math.max(0, p1.getHp()), p1.getHpMax());
            view.aggiornaHpP2(Math.max(0, p2.getHp()), p2.getHpMax());
            gestisciFinePartita();
            return;
        }

        Personaggio difensore = turnoP1 ? p2 : p1;
        turnoP1 = !turnoP1;

        Mossa mossa = mosse[scelta];
        String log;
        if (mossa == null) {
            log = "Nessuna mossa selezionata per " + attaccante.getNome();
        } else {
            log = mossa.esegui(attaccante, difensore);
        }

        view.aggiungiTestoLog(log);

        //TODO: gestisci qui il salvataggio azione

        view.aggiornaHpP1(Math.max(0, p1.getHp()), p1.getHpMax());
        view.aggiornaHpP2(Math.max(0, p2.getHp()), p2.getHpMax());

        if (partitaTerminata()) {
            gestisciFinePartita();
        }
    }

    private void gestisciFinePartita() {
        view.disabilitaBottoneTurno();
        //TODO: gestisci qui il salvataggio fine partita
        view.mostraSchermataFinePartita(getNomeVincitore());
    }

    private boolean partitaTerminata() {
        return !p1.isVivo() || !p2.isVivo();
    }

    private String getNomeVincitore() {
        return p1.isVivo() ? p1.getNome() : p2.getNome();
    }

    public void avviaGioco() {
        view.mostra();
    }
}
