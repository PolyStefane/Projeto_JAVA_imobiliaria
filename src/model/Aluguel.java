package model;

public class Aluguel implements IMostrarDados{

    private int idAluguel;
    private String inicioContrato;
    private String fimContrato;
    private Imovel imovel;
    private Inquilino inquilino;



    @Override
    public void MostrarDados() {
        System.out.println("\nID do aluguel: " + this.getIdAluguel()
                            + "\nInicio do contrato: " + this.getInicioContrato()
                            + "\nFim do contrato: " + this.getFimContrato()
                            + "\nImóvel: " + this.getImovel().getIdImovel()
                            + "\nInquilino: " + this.getInquilino().getIdInquilino());
    }


    //construtor
    public Aluguel() {
    }

    public Aluguel(int idAluguel, String inicioContrato, String fimContrato, Imovel imovel, Inquilino inquilino) {
        this.idAluguel = idAluguel;
        this.inicioContrato = inicioContrato;
        this.fimContrato = fimContrato;
        this.imovel = imovel;
        this.inquilino = inquilino;
    }


    public Aluguel(int idAluguel, String inicioContrato, String fimContrato) {
        this.idAluguel = idAluguel;
        this.inicioContrato = inicioContrato;
        this.fimContrato = fimContrato;
    }

    //get set
    public int getIdAluguel() {
        return idAluguel;
    }

    public void setIdAluguel(int idAluguel) {
        this.idAluguel = idAluguel;
    }

    public String getInicioContrato() {
        return inicioContrato;
    }

    public void setInicioContrato(String inicioContrato) {
        this.inicioContrato = inicioContrato;
    }

    public String getFimContrato() {
        return fimContrato;
    }

    public void setFimContrato(String fimContrato) {
        this.fimContrato = fimContrato;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }
}
