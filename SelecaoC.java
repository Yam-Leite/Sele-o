
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SelecaoC {

    static List<String> candidatosSelecionados = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Processo seletivo");
        selecaoCandidatos();
        analisarCandidato(0);
        imprimirSelecionados();

        String[] candidatos = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando) {
                tentativasRealizadas++;
            } else {
                System.out.println("CONTATO REALIZADO COM SUCESSO");
            }
        } while (continuarTentando && tentativasRealizadas < 3);

        if (atendeu) {
            System.out.println("CONTATO REALIZADO COM O CANDIDATO " + candidato + " NA " + tentativasRealizadas + "ª TENTATIVA");
        } else {
            System.out.println("CONTATO NÃO FOI REALIZADO COM O CANDIDATO " + candidato + " APÓS " + tentativasRealizadas + " TENTATIVAS");
        }
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void imprimirSelecionados() {
        System.out.println("Candidatos Selecionados:");
        // Imprime candidatos selecionados com índice começando em 1
        for (int i = 0; i < candidatosSelecionados.size(); i++) {
            System.out.println((i + 1) + ": " + candidatosSelecionados.get(i));
        }
    }

    static void selecaoCandidatos() {
        String[] candidatos = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
        int candidatosSelecionadosCount = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        DecimalFormat df = new DecimalFormat("0.00");

        while (candidatosSelecionadosCount < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O candidato " + candidato + " solicitou este valor: " + df.format(salarioPretendido));
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado");
                candidatosSelecionadosCount++;
                candidatosSelecionados.add(candidato);
            }
            candidatoAtual++;
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}
