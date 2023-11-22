package data;
import model.Inquilino;
import java.util.List;

public interface InquilinoDAO extends DAO<Inquilino> {

    //salvar
    void salvar(Inquilino inquilino);
    //atualizar
    void alterar (Inquilino inquilino);
    //apagar
    void apagar(Inquilino inquilino);
    //buscar
    Inquilino buscar (int idInquilino);
    //buscar todos
    List<Inquilino> buscarTodos();
}