package model;

public class Proprietario extends Pessoa {

    private int idProprietario;
    private String banco;
    private String conta;


    @Override
    public void MostrarDados() {
        System.out.println("\nCPF: " + getCpf()
                + "\nNome:" + getNome()
                + "\nID do proprietário: " + this.getIdProprietario()
                + "\nBanco: " + this.getBanco()
                + "\nConta: " + this.getConta());
    }

    //construtor
    public Proprietario(String cpf, String nome, int idProprietario, String banco, String conta) {
        super(cpf, nome);
        this.idProprietario = idProprietario;
        this.banco = banco;
        this.conta = conta;
    }

    //get set
    public int getIdProprietario() {
        return idProprietario;
    }

    public void setIdProprietario(int idProprietario) {
        this.idProprietario = idProprietario;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }
}
