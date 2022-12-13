package AgenciaBancaria;
import ferramentas.Utilitarios;

public class Conta {
    private static int quantidadeDeContas = 1;
    private int numerodaConta;
    private int tipodeconta;
    private Cliente cliente;
    private Double saldo = 0.0;

    public Conta( Cliente cliente) {
        this.numerodaConta = quantidadeDeContas;
        this.cliente = cliente;
        this.tipodeconta = 1 | 2;
        quantidadeDeContas += 1;
    }

    public int getNumerodaConta() {

        return numerodaConta;
    }
    public void setNumerodaConta(int numerodaConta) {

        this.numerodaConta = numerodaConta;
    }
    public int getTipodeconta() {

        return tipodeconta;
    }
    public void setTipodeconta(int tipodeconta) {

        this.tipodeconta = tipodeconta;
    }
    public Cliente getCliente() {

        return cliente;
    }
    public void setCliente(Cliente cliente) {

        this.cliente = cliente;
    }
    public Double getSaldo() {

        return saldo;
    }
    public void setSaldo(Double saldo) {

        this.saldo = saldo;
    }

    public String toString(){
        return "\nNumero da conta: " + this.getNumerodaConta() +
                "\nTipo de conta: " + this.getNumerodaConta() +
                "\nNome: " + this.cliente.getNome() +
                "\nCPF: " + this.cliente.getCpf() +
                "\nEmail: " + this.cliente.getEmail() +
                "\nSaldo: " + Utilitarios.doubleToString(this.getSaldo()) +
                "\n";
    }
    public void depositar(Double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println();
        } else {
            System.out.println();
        }
    }
    public void sacar(Double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            System.out.println();
        } else {
            System.out.println();
        }
    }
    public void transferir(Conta contaParaDeposito, Double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            System.out.println();
        } else {
            System.out.println();
        }
    }
}
