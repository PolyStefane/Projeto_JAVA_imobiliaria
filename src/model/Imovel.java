package model;

import java.util.ArrayList;
import java.util.List;

public class Imovel implements IMostrarDados{
    private int idImovel;
    private String endereco;
    private double valorAluguel;
    private Proprietario proprietario;
    private List<Aluguel> listaAlugueis = new ArrayList<>();



    @Override
    public void MostrarDados() {
        System.out.println("\nID do imóvel: " + this.getIdImovel()
                            + "\nEndereço: " + this.getEndereco()
                            + "\nValor do aluguel: R$" + this.getValorAluguel());

    }


    public void exibirHistoricoAluguel(){

        System.out.println("Histórico de Aluguel para o Imóvel " + this.idImovel + ":");
        System.out.println("-----------------------------------------");
        for (Aluguel aluguel : listaAlugueis) {
            System.out.println("Início do contrato: " + aluguel.getInicioContrato()
                                + "\nTérmino do contrato: " + aluguel.getFimContrato());
            System.out.println("-----------------------------------------");
        }
    }

    public void incluirAluguel(Aluguel aluguel){

        this.listaAlugueis.add(aluguel);

    }

    public void removerAluguel(Aluguel aluguel){

        this.listaAlugueis.remove(aluguel);

    }


    //construtor
    public Imovel(int idImovel, String endereco, double valorAluguel, Proprietario proprietario) {
        this.idImovel = idImovel;
        this.endereco = endereco;
        this.valorAluguel = valorAluguel;
        this.proprietario = proprietario;
    }
    public Imovel() {

    }

    //get set
    public int getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(int idImovel) {
        this.idImovel = idImovel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }


    public List<Aluguel> getListaAlugueis() {
        return listaAlugueis;
    }

    public void setListaAlugueis(List<Aluguel> listaAlugueis) {
        this.listaAlugueis = listaAlugueis;
    }
}
