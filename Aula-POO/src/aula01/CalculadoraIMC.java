package aula01;

import java.util.Scanner;

// Calculadora de IMC - usa tipos primitivos (double para decimais) e métodos estáticos
public class CalculadoraIMC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== CALCULADORA DE IMC =====");

        System.out.print("Digite seu peso (kg): ");
        double peso = scanner.nextDouble();

        System.out.print("Digite sua altura (m): ");
        double altura = scanner.nextDouble();

        double imc = calculaImc(peso, altura);
        System.out.printf("Seu IMC é: %.2f%n", imc);
        imprimeSituacao(imc);

        scanner.close();
    }

    // Retorna o IMC calculado. Usa double porque o resultado tem casas decimais
    public static double calculaImc(double peso, double altura) {
        return peso / (altura * altura);
    }

    // Método void: não retorna nada, só imprime na tela
    public static void imprimeSituacao(double imc) {
        System.out.print("Situação: ");

        if (imc < 18.5) {
            System.out.println("Abaixo do peso");
        } else if (imc < 25.0) {
            System.out.println("Peso normal");
        } else if (imc < 30.0) {
            System.out.println("Sobrepeso");
        } else if (imc < 35.0) {
            System.out.println("Obesidade Grau I");
        } else if (imc < 40.0) {
            System.out.println("Obesidade Grau II");
        } else {
            System.out.println("Obesidade Grau III (Mórbida)");
        }
    }
}
