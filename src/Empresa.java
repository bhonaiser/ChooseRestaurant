import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Empresa {

    private List<Restaurante> restaurantes;
    private List<Funcionario> funcionarios;
    private List<Restaurante> votadosNaSemana;

    private final int diasUteis = 5;

    public Empresa() {

        restaurantes = new ArrayList<>(Arrays.asList(
                new Restaurante("daEsquina"),
                new Restaurante("hotDog"),
                new Restaurante("aLaMinuta"),
                new Restaurante("Sushi"),
                new Restaurante("24h"),
                new Restaurante("indianFood"),
                new Restaurante("arabe")
        ));
        funcionarios = new ArrayList<>(Arrays.asList(
                new Funcionario("Joao"),
                new Funcionario("Maria"),
                new Funcionario("Pedro"),
                new Funcionario("Luiza"),
                new Funcionario("Allan"),
                new Funcionario("Arthur"),
                new Funcionario("Gabriela"),
                new Funcionario("Marcela")
        ));
        votadosNaSemana = new ArrayList<>(diasUteis);
    }


    public String votarRestaurante() {

        if (restaurantes.isEmpty()) {
            return "Lista de Restaurantes Vazia";
        }

        Restaurante maisVotado = restaurantes.get(0);

        for (Funcionario funcionario : funcionarios) {
            funcionario.votar(restaurantes);

            System.out.println("\nO Funcionario " + funcionario.getName() + " votou no restaurante : " + funcionario.getRestaurant());
        }

        System.out.println("\nAcabada a votação.....\n");

        if (restaurantes.size() > 1) {

            for (Restaurante restaurante : restaurantes) {
                System.out.println(maisVotado.getName() + " " + maisVotado.getVotos() + "    VS   " + restaurante.getName() + " " + restaurante.getVotos());

                if (restaurante.getVotos() >= maisVotado.getVotos()) {
                    maisVotado = restaurante;
                }
            }
        }

        if (votadosNaSemana.size() >= diasUteis) {
            restaurantes.addAll(votadosNaSemana);
            votadosNaSemana.clear();
        }

        votadosNaSemana.add(maisVotado);
        restaurantes.remove(maisVotado);

        for (Restaurante restaurante : restaurantes) {
            restaurante.resetVotos();
        }

        return maisVotado.getName();
    }
}