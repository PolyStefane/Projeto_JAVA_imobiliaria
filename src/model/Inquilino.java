package model;

public class Inquilino extends Pessoa{

    private int idInquilino;
    private double rendaMensal;


    @Override
    public void MostrarDados() {
        System.out.println("\nCPF: " + getCpf()
                + "\nNome: " + getNome()
                + "\nID do inquilino: " + this.getIdInquilino()
                + "\nRenda Mensal:  R$" + this.getRendaMensal());
    }

    //construtor
    public Inquilino(String cpf, String nome, int idInquilino, double rendaMensal) {
        super(cpf, nome);
        this.idInquilino = idInquilino;
        this.rendaMensal = rendaMensal;
    }

    // get set
    public int getIdInquilino() {
        return idInquilino;
    }

    public void setIdInquilino(int idInquilino) {
        this.idInquilino = idInquilino;
    }

    public double getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(double rendaMensal) {
        this.rendaMensal = rendaMensal;
    }
}
