package battlearena.app;

import battlearena.model.GestoreSalvataggio;
import battlearena.model.ImpPersonaggio;
import battlearena.model.Mossa;
import battlearena.model.Personaggio;
import battlearena.controller.ArenaController;
import battlearena.view.ArenaFrame;
import battlearena.view.ArenaView;

public class Main {
    public static void main(String[] args) {
        try {
            // TODO: Studente 1
            Personaggio p1 = new ImpPersonaggio("Hammon", Personaggio.TipoPersonaggio.FUOCO, "BattleArena/assets/fighter_red.png");

            // TODO: Studente 2
            Personaggio p2 = new ImpPersonaggio("Tony", Personaggio.TipoPersonaggio.ACQUA, "BattleArena/assets/fighter_blue.png");

            // TODO: Studente 3
            GestoreSalvataggio salvataggio = new GestoreSalvataggio() {
                @Override
                public void registraAzioneLog(String azione) {
                    // Implementazione temporanea
                }

                @Override
                public void salvaVincitore(String nomePersonaggio) {
                    // Implementazione temporanea
                }
            };

            // Dopo il merge dei branch, sostituire le istanze di esempio con le classi concrete.
            ArenaView vista = new ArenaFrame(p1.getNome(), p1.getPercorsoImmagine(),p2.getNome(), p2.getPercorsoImmagine());
            ArenaController controller = new ArenaController(vista, p1, p2, salvataggio);
            controller.avviaGioco();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
