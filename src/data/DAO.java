package data;
import java.util.List;

public interface DAO <T>{
    void salvar(T type);
    void alterar (T type);
    void apagar (T type);
    T buscar (int id);
    List<T> buscarTodos();
}