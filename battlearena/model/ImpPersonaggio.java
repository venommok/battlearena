package battlearena.model;

public class ImpPersonaggio implements Personaggio {
    FactoryMosse m = new FactoryMosse();

    private static final int MAX_HP = 100;
    private static final int MIN_HP = 0;
    private static final int ENERGIA_MAX = 100;
    private static final int ENERGIA_MIN = 0;

    private int hp = MAX_HP;
    private String nome;
    private TipoPersonaggio tipo;
    private String path;
    private int energia;

    public ImpPersonaggio(String nome, TipoPersonaggio tipo, String path){
        this.setNome(nome);
        this.setTipo(tipo);
        this.setPath(path);
        this.energia = ENERGIA_MAX;
    }

    private void setHp(int hp){ this.hp = hp; }
    private void setNome(String nome){ this.nome = nome; }
    private void setTipo(TipoPersonaggio tipo){ this.tipo = tipo; }
    private void setPath(String path){ this.path = path; }

    @Override
    public void setEnergia(int energia){
        if(energia >= ENERGIA_MIN){
            this.energia = energia;
        }else{
            this.energia = ENERGIA_MIN;
        }
    }

    public int getEnergiaMin(){return ENERGIA_MIN;}

    public int getEnergiaMax(){return ENERGIA_MAX;}

    @Override
    public int getEnergia(){return this.energia;}

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public int getHp() {
        return this.hp;
    }

    @Override
    public int getHpMax() {
        return MAX_HP;
    }

    @Override
    public void subisciDanno(int danno) {
        this.setHp(this.getHp() - danno);
    }

    @Override
    public boolean isVivo() {
        return this.getHp() > 0;
    }

    @Override
    public TipoPersonaggio getTipo() {
        return this.getTipo();
    }

    @Override
    public Mossa[] getMosseDisponibili() {
                    return m.getMosse().toArray(new Mossa[0]);
                }

    @Override
    public String getPercorsoImmagine() {
        return this.path;
    }
};

