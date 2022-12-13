package AgenciaBancaria;
import javax.xml.transform.stream.StreamSource;
import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;
    private static int numerodaConta;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes() {
        System.out.println("----------------------------------------");
        System.out.println("-                BANCO APK             -");
        System.out.println("-                ---------             -");
        System.out.println("-                                      -");
        System.out.println("-                                      -");
        System.out.println("-  O QUE PODEMOS FAZER POR VOCÊ HOJE?  -");
        System.out.println("-                                      -");
        System.out.println("- 1- Abra sua conta corrente;          -");
        System.out.println("- 2- Efetuar um depósito;              -");
        System.out.println("- 3- Realizar saque;                   -");
        System.out.println("- 4- Efetuar uma transferência;        -");
        System.out.println("- 5- Consultar Contas Existentes;      -");
        System.out.println("- 6- Sair                              -");
        System.out.println("----------------------------------------");

        int operacao = input.nextInt();

        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                encontrarconta();
                break;
            case 6:
                System.out.println("Obrigado usar nossa agência, volte sempre!!");
            default:
                System.out.println("Opção inválida!");
                operacoes();
                break;
        }
    }

    public static void criarConta() {
        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("\nEmail: ");
        String email = input.next();

        System.out.println("\nTipo de conta: ");
        String tipodeconta = input.next();
        int tipodeConta = 1 | 2;
        if (tipodeConta == 1){
            System.out.println( tipodeConta + "Conta corrente");
        }else {
            System.out.println(tipodeConta + "Conta poupança");
        }
        Cliente cliente = new Cliente(nome, cpf, email);
        Conta conta = new Conta(cliente);

        contasBancarias.add(conta);
        System.out.println("Sua conta foi criada com sucesso!" + conta);

        operacoes();
    }

    private static Conta encontrarConta() {
        Conta conta = null;
        if (contasBancarias.size() > 0) {
            for (Conta a : contasBancarias) {
                if (a.getNumerodaConta() == numerodaConta) ;
                conta = a;
            }
        }
        return conta;
    }

    public static void depositar() {
        System.out.println("Informe o número da conta: ");
        int numeroDaConta = input.nextInt();

        Conta conta = encontrarConta();

        if (conta != null) {
            System.out.println("Informe o valor para depósito: ");
            Double valorDeposito = input.nextDouble();
            conta.depositar(valorDeposito);
            System.out.println("Valor foi depositado com sucesso, confira seu saldo!");
        } else {
            System.out.println("Conta não encontrada");
        }
        operacoes();
    }

    public static void sacar() {
        System.out.println("Informe o número da conta: ");
        int numeroDaConta = input.nextInt();

        Conta conta = encontrarConta();

        if (conta != null) {
            System.out.println("Informe o valor que deseja sacar: ");
            Double valorSaque = input.nextDouble();
            conta.sacar(valorSaque);
            System.out.println("Valor foi retirado com sucesso, retire no local indicado e confira seu saldo!");
        } else {
            System.out.println("Conta não encontrada, revise as informaçõe se tente novamente");
        }
        operacoes();
    }

    public static void transferir() {
        System.out.println("Informe a conta que fará a transferência: ");
        int numeroContaEnvia = input.nextInt();

        Conta contaEnvia = encontrarConta();
        if (contaEnvia != null) {
            System.out.println("Informe a conta que receberá a transferência: ");
            int numeroContaRecebe = input.nextInt();

            Conta contarecebe = encontrarConta();
            if (contarecebe != null) {
                System.out.println("Valor da transferência: ");
                Double valor = input.nextDouble();

                contarecebe.transferir(contarecebe, valor);
            }else{
                System.out.println("Conta para deposito não foi encontrada");
            }
        }
        operacoes();
    }
    public static void encontrarconta(){
        if(contasBancarias.size() > 0) {
            for(Conta conta: contasBancarias){
                System.out.println(conta);
            }
        }else{
                System.out.println("Não existem contas cadastradas");
            }
        operacoes();

        }

    public static void sair(){
    }
    }
