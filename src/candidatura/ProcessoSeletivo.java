package candidatura;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ProcessoSeletivo {
    private static final double SALARIO_BASE = 2000;
    private static final int MAX_CANDIDATOS = 5;
    private static final int TOTAL_CANDIDATOS = 10;
    private static final double SALARIO_MIN = 1800;
    private static final double SALARIO_MAX = 2200;
    private static final int MAX_TENTATIVAS = 3;

    public static void main(String[] args) {
        List<Candidato> candidatos = gerarCandidatosAleatorios(TOTAL_CANDIDATOS);

        List<Candidato> candidatosSelecionados = selecionarCandidatosParaEntrevista(candidatos);

        imprimirCandidatoSelecionados(candidatosSelecionados);

        realizarTentativaDeContrato(candidatosSelecionados);
    }

    private static List<Candidato> gerarCandidatosAleatorios(int quantidade) {
        List<Candidato> candidatos = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= quantidade; i++) {
            String nome = "Candidato " + (i + 1);
            double salarioPretendido = SALARIO_MIN + (SALARIO_MAX - SALARIO_MIN) * random.nextDouble();

            candidatos.add(new Candidato(nome, salarioPretendido));
        }
        return candidatos;
    }

    private static List<Candidato> selecionarCandidatosParaEntrevista(List<Candidato> candidatos) {
        return candidatos.stream()
                .filter(c -> c.getSalarioPretendido() <= SALARIO_BASE)
                .limit(MAX_CANDIDATOS)
                .collect(Collectors.toList());
    }

    private static void imprimirCandidatoSelecionados(List<Candidato> candidados) {
        System.out.println("Candidatos selecionados para a entrevista:");
        for (Candidato candidato : candidados) {
            System.out.println(candidato.getNome() + " - Salário Pretendido: " + candidato.getSalarioPretendido());
        }
    }

    
    private static void realizarTentativaDeContrato(List<Candidato> candidatos) {
        Random random = new Random();

        for (Candidato candidato : candidatos) {
            boolean conseguiuContrato = false;
            int tentativa;

            for (tentativa = 1; tentativa <= MAX_TENTATIVAS; tentativa++) {
                if (random.nextBoolean()) {
                    conseguiuContrato = true;
                    break;
                }
            }

            if (conseguiuContrato) {
                System.out.println(
                        "CONSEGUIMOS CONTATO COM " + candidato.getNome() + " APÓS " + tentativa + " TENTATIVA(S)");
            } else {
                System.out.println("NÃO CONSEGUIMOS CONTATO COM O " + candidato.getNome());
            }
        }

    }
}
