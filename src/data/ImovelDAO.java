package data;
import model.Imovel;
import java.util.List;

public interface ImovelDAO extends DAO<Imovel> {

    //salvar
    void salvar(Imovel imovel);
    //atualizar
    void alterar (Imovel imovel);
    //apagar
    void apagar(Imovel imovel);
    //buscar
    Imovel buscar (int idImovel);
    //buscar todos
    List<Imovel> buscarTodos();
}