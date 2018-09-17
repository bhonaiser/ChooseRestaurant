import java.util.List;
import java.util.ArrayList;

public class Empresa {

    public static List<Restaurante> restaurantes;
    ;
    public static List<Funcionario> funcionarios;
    public static List<Restaurante> votadosNaSemana;

    private final int diasUteis = 5;

    public Empresa() {

        restaurantes = new ArrayList();
        funcionarios = new ArrayList();
        votadosNaSemana = new ArrayList(diasUteis);

        restaurantes.add(new Restaurante("daEsquina"));
        restaurantes.add(new Restaurante("doJoao"));
        restaurantes.add(new Restaurante("aLaMinuta"));
        restaurantes.add(new Restaurante("Sushi"));
        restaurantes.add(new Restaurante("24h"));
        restaurantes.add(new Restaurante("indianFood"));
        restaurantes.add(new Restaurante("arabe"));

        funcionarios.add(new Funcionario("Joao"));
        funcionarios.add(new Funcionario("Maria"));
        funcionarios.add(new Funcionario("Pedro"));
        funcionarios.add(new Funcionario("Luiza"));
        funcionarios.add(new Funcionario("Allan"));
        funcionarios.add(new Funcionario("Arthur"));
        funcionarios.add(new Funcionario("Gabriela"));
        funcionarios.add(new Funcionario("Marcela"));
        funcionarios.add(new Funcionario("Joao Pedro"));
    }



    public static String votarRestaurante() {

        Funcionario employee;
        Restaurante  rest2, maisVotado;

        if (restaurantes.size() > 0) {
            maisVotado = restaurantes.get(0);
        } else {return "Lista de Restaurantes Vazia";}

        for (int i = 0; i < funcionarios.size(); i++) {
            employee = funcionarios.get(i);
            employee.votar(restaurantes);

            System.out.println(" ");
            System.out.println("O Funcionario " + employee.getName() + " votou no restaurante : " + employee.getRestaurant());
        }


        System.out.println(" ");
        System.out.println("Acabada a votação..... ");
        System.out.println(" ");

        if(restaurantes.size()>1){

            for (int i = 1; i < restaurantes.size(); i++) {
                rest2 = restaurantes.get(i);

                System.out.println(maisVotado.getName() + " "+ maisVotado.getVotos() + "    VS   " + rest2.getName() + " " + rest2.getVotos());

                if (rest2.getVotos() >= maisVotado.getVotos()) {
                    maisVotado = rest2;}
            }
        }

        if (votadosNaSemana.size() < 5) {
            votadosNaSemana.add(maisVotado);
            restaurantes.remove(maisVotado);
        }
        else {
            for (int i = 0; i < votadosNaSemana.size(); i++) {
                restaurantes.add(votadosNaSemana.get(i));
            }
            votadosNaSemana.clear();
            votadosNaSemana.add(maisVotado);

            restaurantes.remove(maisVotado);
        }

        for (int i=0; i<restaurantes.size();i++){
             rest2 = restaurantes.get(i);
             rest2.resetVotos();
        }

        return maisVotado.getName();
    }
}