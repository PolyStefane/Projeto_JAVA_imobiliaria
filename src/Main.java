import data.*;
import model.Imovel;
import model.Inquilino;
import model.Proprietario;
import model.Aluguel;

public class Main {
    public static void main(String[] args) {
        /*Proprietario proprietario1 = new Proprietario("12345667", "Juliana", 1, "Santander","123456");
        proprietario1.MostrarDados();

        Inquilino inquilino1 = new Inquilino("543211", "Fabio", 1, 4000);
        inquilino1.MostrarDados();

        //Imovel imovel1 = new Imovel(1, "Rua augusta 234", 2000);
        //imovel1.MostrarDados();
        Imovel imovel2 = new Imovel(2, "Rua Jorgia 123", 3000);
        imovel2.MostrarDados();

        Aluguel aluguel2 = new Aluguel(2, "11/02/2023", "13/11/2023" );
        Aluguel aluguel3 = new Aluguel(3, "02/02/2023", "11/11/2023" );
        Aluguel aluguel4 = new Aluguel(4, "10/02/2023", "28/11/2023" );

        Imovel imovel1 = new Imovel();
        imovel1.setIdImovel(1);
        imovel1.setEndereco("Rua augusta 234");
        imovel1.setValorAluguel(2000);


        imovel1.incluirAluguel(aluguel2);
        imovel1.incluirAluguel(aluguel3);
        imovel1.MostrarDados();

        imovel1.exibirHistoricoAluguel();*/

        DAO<Proprietario> proprietarioDAO = new ProprietarioSqliteDAO();

        Proprietario proprietario1 = new Proprietario("12345667", "Juliana", 1, "Santander","123456");
        proprietario1.MostrarDados();
        proprietarioDAO.salvar(proprietario1);

        DAO<Inquilino> inquilinoDAO = new InquilinoSqliteDAO();
        Inquilino inquilino1 = new Inquilino("543211", "Fabio", 1, 4000);
        inquilino1.MostrarDados();
        inquilinoDAO.salvar(inquilino1);



        DAO<Imovel> imovelDAO = new ImovelSqliteDAO();
        Imovel imovel1 = new Imovel();
        imovel1.setIdImovel(1);
        imovel1.setEndereco("Rua augusta 234");
        imovel1.setValorAluguel(2000);
        imovel1.setProprietario(proprietario1);


        Imovel imovel2 = new Imovel();
        imovel2.setIdImovel(2);
        imovel2.setEndereco("Rua Jorgia 123");
        imovel2.setValorAluguel(3000);
        imovel2.setProprietario(proprietario1);

        DAO<Aluguel> aluguelDAO = new AluguelSqliteDAO();
        Aluguel aluguel2 = new Aluguel(2, "11/02/2023", "13/11/2023", imovel1, inquilino1 );
        Aluguel aluguel3 = new Aluguel(3, "02/02/2023", "11/11/2023", imovel1, inquilino1);
        Aluguel aluguel4 = new Aluguel(4, "10/02/2023", "28/11/2023", imovel2,inquilino1);
        aluguelDAO.salvar(aluguel2);
        aluguelDAO.salvar(aluguel3);
        aluguelDAO.salvar(aluguel4);
        aluguel2.MostrarDados();
        aluguel3.MostrarDados();
        aluguel4.MostrarDados();

        imovel1.incluirAluguel(aluguel2);
        imovel1.incluirAluguel(aluguel3);
        imovel1.MostrarDados();
        imovelDAO.salvar(imovel1);

        imovel2.incluirAluguel(aluguel4);
        imovel2.MostrarDados();
        imovelDAO.salvar(imovel2);
        System.out.println("\n");
        imovel1.exibirHistoricoAluguel();
        imovel2.exibirHistoricoAluguel();
        //System.out.println("=========== \n ");
        //Imovel imovel_teste2 =  imovelDAO.buscar(2);
        //imovel_teste2.MostrarDados();
        //System.out.println("=========== \n ");

        System.out.println("aluguel 4: \n");
        Aluguel a_teste =  aluguelDAO.buscar(4);
        a_teste.MostrarDados();


    }
}