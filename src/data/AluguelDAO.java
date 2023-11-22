package data;
import model.Aluguel;
import java.util.List;

public interface AluguelDAO extends DAO<Aluguel> {

    //salvar
    void salvar(Aluguel aluguel);
    //atualizar
    void alterar (Aluguel aluguel);
    //apagar
    void apagar(Aluguel aluguel);
    //buscar
    Aluguel buscar (int id);
    //buscar todos
    List<Aluguel> buscarTodos();
}