package battlearena.app;

import battlearena.model.GestoreSalvataggio;
import battlearena.model.Mossa;
import battlearena.model.Personaggio;
import battlearena.controller.ArenaController;
import battlearena.view.ArenaFrame;
import battlearena.view.ArenaView;

public class Main {
    public static void main(String[] args) {
        try {
            // TODO: Studente 1
            Personaggio p1 = new Personaggio() {
                @Override
                public String getNome() {
                    return "Hammon";
                }

                @Override
                public int getHp() {
                    return 100;
                }

                @Override
                public int getHpMax() {
                    return 100;
                }

                @Override
                public void subisciDanno(int danno) {
                    // Implementazione temporanea
                }

                @Override
                public boolean isVivo() {
                    return true;
                }

                @Override
                public TipoPersonaggio getTipo() {
                    return TipoPersonaggio.FUOCO;
                }

                @Override
                public Mossa[] getMosseDisponibili() {
                    return new Mossa[] {
                            new Mossa() {
                                @Override
                                public String getNome() {
                                    return "Colpo Base";
                                }

                                @Override
                                public int getPotenza() {
                                    return 10;
                                }

                                @Override
                                public String esegui(Personaggio attaccante, Personaggio difensore) {
                                    return attaccante.getNome() + " usa " + getNome() + " su " + difensore.getNome();
                                }

                                @Override
                                public String toString() {
                                    return getNome();
                                }
                            }
                    };
                }

                @Override
                public String getPercorsoImmagine() {
                    return "assets/fighter_red.png";
                }
            };

            // TODO: Studente 2
            Personaggio p2 = new Personaggio() {
                @Override
                public String getNome() {
                    return "Glasond";
                }

                @Override
                public int getHp() {
                    return 100;
                }

                @Override
                public int getHpMax() {
                    return 100;
                }

                @Override
                public void subisciDanno(int danno) {
                    // Implementazione temporanea
                }

                @Override
                public boolean isVivo() {
                    return true;
                }

                @Override
                public TipoPersonaggio getTipo() {
                    return TipoPersonaggio.FUOCO;
                }

                @Override
                public Mossa[] getMosseDisponibili() {
                    return new Mossa[] {
                            new Mossa() {
                                @Override
                                public String getNome() {
                                    return "Colpo Base";
                                }

                                @Override
                                public int getPotenza() {
                                    return 10;
                                }

                                @Override
                                public String esegui(Personaggio attaccante, Personaggio difensore) {
                                    return attaccante.getNome() + " usa " + getNome() + " su " + difensore.getNome();
                                }

                                @Override
                                public String toString() {
                                    return getNome();
                                }
                            }
                    };
                }

                @Override
                public String getPercorsoImmagine() {
                    return "assets/fighter_blue.png";
                }
            };

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
