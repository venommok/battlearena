package battlearena.model;

import java.util.ArrayList;

public class FactoryMosse{
    ArrayList<Mossa> mosse = new ArrayList<Mossa>();

    public FactoryMosse(){
        mosse.add(new Mossa(){
            public int getCosto(){
                return 10;
            }

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
                if(difensore.getTipo() == Personaggio.TipoPersonaggio.FUOCO
                    && attaccante.getTipo() == Personaggio.TipoPersonaggio.ACQUA
                    || difensore.getTipo() == Personaggio.TipoPersonaggio.ERBA
                    && attaccante.getTipo() == Personaggio.TipoPersonaggio.FUOCO){
                    difensore.subisciDanno(getPotenza() * 2);
                }else {
                    difensore.subisciDanno(getPotenza());
                }
                attaccante.setEnergia(attaccante.getEnergia() - getCosto());
                return attaccante.getNome() + " usa " + getNome() + " su " + difensore.getNome();
            }

            @Override
            public String toString() {
                return getNome();
            }
        });

        mosse.add(new Mossa(){
            public int getCosto(){
                return 25;
            }

            @Override
            public String getNome() {
                return "Speciale1";
            }

            @Override
            public int getPotenza() {
                return 20;
            }

            @Override
            public String esegui(Personaggio attaccante, Personaggio difensore) {
                if(difensore.getTipo() == Personaggio.TipoPersonaggio.FUOCO
                        && attaccante.getTipo() == Personaggio.TipoPersonaggio.ACQUA
                        || difensore.getTipo() == Personaggio.TipoPersonaggio.ERBA
                        && attaccante.getTipo() == Personaggio.TipoPersonaggio.FUOCO){
                    difensore.subisciDanno(getPotenza() * 2);
                }else {
                    difensore.subisciDanno(getPotenza());
                }
                attaccante.setEnergia(attaccante.getEnergia() - getCosto());
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
