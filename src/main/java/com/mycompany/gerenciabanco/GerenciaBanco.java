
package com.mycompany.gerenciabanco;
import java.util.Scanner;
/*
 * @author João Guilherme Portela 
 */
    

class Cliente {
    private String nome;
    private String sobrenome;
    private String cpf;
    private double saldo;

    public Cliente(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.saldo = 0.0;
    }

    public void consultarSaldo() {
        
        System.out.println("Seu saldo atual é de R$" + saldo);
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Deposito de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Deposito inválido. O valor deve ser maior que zero.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saque invalido. Verifique o valor inserido ou saldo disponível.");
        }
    }
}

public class GerenciaBanco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o seu nome:");
        String nome = scanner.nextLine();
        System.out.println("Informe o seu sobrenome:");
        String sobrenome = scanner.nextLine();
        System.out.println("Informe o seu CPF:");
        String cpf = scanner.nextLine();

        Cliente cliente = new Cliente(nome, sobrenome, cpf);

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nEscolha uma opcao:");
            System.out.println("(1) Ver saldo");
            System.out.println("(2) Depositar");
            System.out.println("(3) Sacar");
            System.out.println("(4) Sair");

            int escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    cliente.consultarSaldo();
                    break;
                case 2:
                    System.out.println("Digite o valor a ser depositado:");
                    double valorDeposito = scanner.nextDouble();
                    cliente.depositar(valorDeposito);
                    break;
                case 3:
                    System.out.println("Digite o valor do saque:");
                    double valorSaque = scanner.nextDouble();
                    cliente.sacar(valorSaque);
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Encerrando a aplicacao.");
                    break;
                default:
                    System.out.println("Opcao invalida. Por favor, escolha uma opcao valida.");
                    break;
            }
        }
        scanner.close();
    }
}

