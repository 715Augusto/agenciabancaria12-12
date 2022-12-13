package AgenciaBancaria;

public class Cliente {
    private static int contador = 1; //contador de contas
    private String nome;    //atributo
    private String cpf;     //atributo
    private String email;   //atributo
    private static int tipodeconta = 1 | 2;

    public Cliente(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        tipodeconta = 1 | 2;
        contador += 1;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getCpf() {

        return cpf;
    }

    public void setCpf(String cpf) {

        this.cpf = cpf;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }
    public int getTipodeconta() {

        return tipodeconta;
    }

    public void setTipodeconta(int tipodeconta) {

        this.tipodeconta = tipodeconta;
    }

    public String toString(){
        return "\nNome: " + this.getNome() +
                "\nCPF: " + this.getCpf() +
                "\nEmail: " + this.getEmail() +
                "\nTipo de conta: " + this.getTipodeconta();
    }
}