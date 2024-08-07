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
        try {
            List<Candidato> candidatos = gerarCandidatosAleatorios(TOTAL_CANDIDATOS);
            List<Candidato> candidatosSelecionados = selecionarCandidatosParaEntrevista(candidatos);
            System.out.println("CANDIDATOS SELECIONADOS:");
            imprimirCandidatosSelecionados(candidatosSelecionados);

            System.out.println();
            System.out.println("TENTATIVAS DE CONTRATO:");
            realizarTentativaDeContrato(candidatosSelecionados);
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        }
    }

    private static List<Candidato> gerarCandidatosAleatorios(int quantidade) {
        List<Candidato> candidatos = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= quantidade; i++) {
            String nome = "Candidato " + i;
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

    private static void imprimirCandidatosSelecionados(List<Candidato> candidatos) {
        System.out.println("Candidatos selecionados para a entrevista:");
        for (Candidato candidato : candidatos) {
            System.out.println("Nome: " + candidato.getNome() + " | Salário Pretendido: R$ "
                    + String.format("%.2f", candidato.getSalarioPretendido()));
        }
    }

    private static void realizarTentativaDeContrato(List<Candidato> candidatos) {
        Random random = new Random();

        for (Candidato candidato : candidatos) {
            boolean conseguiuContrato = false;
            int tentativa;

            try {
                for (tentativa = 1; tentativa <= MAX_TENTATIVAS; tentativa++) {
                    if (random.nextBoolean()) {
                        conseguiuContrato = true;
                        break;
                    }
                }

                if (conseguiuContrato) {
                    System.out.println("Contato estabelecido com " + candidato.getNome() + " após " + tentativa
                            + " tentativa(s).");
                } else {
                    throw new TentativaDeContratoException("Não foi possível estabelecer contato com "
                            + candidato.getNome() + " após " + MAX_TENTATIVAS + " tentativa(s).");
                }
            } catch (TentativaDeContratoException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
