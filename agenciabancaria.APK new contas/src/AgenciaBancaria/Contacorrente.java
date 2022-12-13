package AgenciaBancaria;

public class Contacorrente extends AgenciaBancaria {
    private String contacorrente;
    private int tipodeconta = 1 | 2;

    public void tipodeConta() {
        if (tipodeconta == 2) {
            System.out.println(tipodeconta + "Conta corrente");
        } else {
            System.out.println(tipodeconta + "Conta salario");
        }
    }
}


