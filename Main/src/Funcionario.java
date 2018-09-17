import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Funcionario {

    private String nome;
    private boolean votouHoje;
    private String restaurante;


    public Funcionario(String nome) {
        this.nome = nome;
        restaurante = " ";
        votouHoje = false;
    }


    public String getName(){
        return nome;
    }

    public void votar(List<Restaurante> arrayRest) {

        Restaurante rest;
        Random random = new Random();
        int aux = random.nextInt(arrayRest.size());

        rest = arrayRest.get(aux);
        rest.addVoto();

        this.restaurante = rest.getName();
        votouHoje = true;
    }

    public String getRestaurant(){
        return restaurante;
    }
}
