package data;
import model.Proprietario;
import java.util.List;

public interface ProprietarioDAO extends DAO<Proprietario> {

    //salvar
    void salvar(Proprietario proprietario);

    //atualizar
    void alterar (Proprietario proprietario);
    //apagar
    void apagar(Proprietario proprietario);
    //buscar
    Proprietario buscar (int idProprietario);
    //buscar todos
    List<Proprietario> buscarTodos();
}
