import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Atletas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Atleta> atletas = new ArrayList<>();

        System.out.print("Informe o número de atletas (N > 0): ");
        int N = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        for (int i = 0; i < N; i++) {
            System.out.println("\nInforme os dados do atleta " + (i + 1) + ":");

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Sexo (M/F): ");
            char sexo = scanner.nextLine().toUpperCase().charAt(0);

            System.out.print("Altura (em metros): ");
            double altura = scanner.nextDouble();

            System.out.print("Peso (em kg): ");
            double peso = scanner.nextDouble();
            scanner.nextLine(); // Consumir a quebra de linha

            atletas.add(new Atleta(nome, sexo, altura, peso));
        }

        // Calculando o peso médio
        double somaPesos = 0;
        for (Atleta atleta : atletas) {
            somaPesos += atleta.peso;
        }
        double pesoMedio = somaPesos / N;

        // Encontrando o atleta mais alto
        Atleta atletaMaisAlto = atletas.get(0);
        for (Atleta atleta : atletas) {
            if (atleta.altura > atletaMaisAlto.altura) {
                atletaMaisAlto = atleta;
            }
        }

        // Calculando a porcentagem de homens
        int numHomens = 0;
        for (Atleta atleta : atletas) {
            if (atleta.sexo == 'M') {
                numHomens++;
            }
        }
        double porcentagemHomens = (double) numHomens / N * 100;

        // Calculando a altura média das mulheres
        double somaAlturasMulheres = 0;
        int numMulheres = 0;
        for (Atleta atleta : atletas) {
            if (atleta.sexo == 'F') {
                somaAlturasMulheres += atleta.altura;
                numMulheres++;
            }
        }
        double alturaMediaMulheres = numMulheres > 0 ? somaAlturasMulheres / numMulheres : 0;

        // Exibindo o relatório
        System.out.println("\nRelatório:");
        System.out.printf("Peso médio dos atletas: %.2f kg%n", pesoMedio);
        System.out.println("Nome do atleta mais alto: " + atletaMaisAlto.nome);
        System.out.printf("Porcentagem de homens: %.2f%%%n", porcentagemHomens);
        System.out.printf("Altura média das mulheres: %.2f m%n", alturaMediaMulheres);

        scanner.close();
    }

    static class Atleta {
        String nome;
        char sexo;
        double altura;
        double peso;

        Atleta(String nome, char sexo, double altura, double peso) {
            this.nome = nome;
            this.sexo = sexo;
            this.altura = altura;
            this.peso = peso;
        }
    }
}
