class Restaurante {

    String nome;
    int votos = 0;

    public Restaurante(String nome){
        this.nome = nome;
        this.votos = 0;
    }

    public void addVoto(){
        this.votos++;
    }

    public int getVotos(){
        return votos;
    }

    public String getName(){
        return nome;
    }

    public void resetVotos(){
        this.votos = 0;
    }

}