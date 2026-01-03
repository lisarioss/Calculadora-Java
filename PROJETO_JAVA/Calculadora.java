package PROJETO_JAVA;

import java.util.Scanner;

public class Calculadora {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        exibirMensagemInicial();
        int opcao = lerOpcao();

        if (opcao == 0) {
            System.out.println("Encerrando a aplicação. Até logo!");
        } else {
            executarOperacao(opcao);
        }

        scanner.close();
    }

    private static void exibirMensagemInicial() {
        System.out.println("=================================");
        System.out.println("  Bem-vindo à Calculadora Java");
        System.out.println("=================================");
    }

    private static int lerOpcao() {
        System.out.println("\nEscolha a operação:");
        System.out.println("1 - Adição");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");
        System.out.println("0 - Sair");

        return scanner.nextInt();
    }

    private static void executarOperacao(int opcao) {
        try {
            double num1 = lerNumero("Digite o primeiro número:");
            double num2 = lerNumero("Digite o segundo número:");

            double resultado = calcular(opcao, num1, num2);
            System.out.println("Resultado: " + resultado);

        } catch (ArithmeticException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado. Verifique os dados informados.");
        }
    }

    private static double lerNumero(String mensagem) {
        System.out.println(mensagem);
        return scanner.nextDouble();
    }

    private static double calcular(int opcao, double num1, double num2) {
        switch (opcao) {
            case 1:
                return num1 + num2;
            case 2:
                return num1 - num2;
            case 3:
                return num1 * num2;
            case 4:
                if (num2 == 0) {
                    throw new ArithmeticException("Divisão por zero não é permitida.");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Opção inválida.");
        }
    }
}
