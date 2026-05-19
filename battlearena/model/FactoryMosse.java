package battlearena.model;

import java.util.ArrayList;

public class FactoryMosse{
    ArrayList<Mossa> mosse = new ArrayList<Mossa>();

    public FactoryMosse(){
        mosse.add(new Mossa(){
            @Override
            public String getNome() {
                return "Default";
            }

            @Override
            public int getPotenza() {
                return 10;
            }

            @Override
            public String esegui(Personaggio attaccante, Personaggio difensore) {
                difensore.subisciDanno(getPotenza());
                return attaccante.getNome() + " usa " + getNome() + " su " + difensore.getNome();
            }

            @Override
            public String toString() {
                return getNome();
            }
        });

        mosse.add(new Mossa(){
            @Override
            public String getNome() {
                return "Speciale1";
            }

            @Override
            public int getPotenza() {
                return 25;
            }

            @Override
            public String esegui(Personaggio attaccante, Personaggio difensore) {
                difensore.subisciDanno(getPotenza());
                return attaccante.getNome() + " usa " + getNome() + " su " + difensore.getNome();
            }

            @Override
            public String toString() {
                return getNome();
            }
        });
    }

    public ArrayList<Mossa> getMosse(){
        return mosse;
    }
}
