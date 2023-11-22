package data;
import model.Inquilino;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class InquilinoSqliteDAO implements InquilinoDAO {


    @Override
    public void salvar(Inquilino inquilino) {
        String sql = "INSERT INTO inquilino(cpf, nome,idInquilino, rendaMensal) VALUES (?,?,?,?)";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1,inquilino.getCpf());
            stmt.setString(2,inquilino.getNome());
            stmt.setInt(3,inquilino.getIdInquilino());
            stmt.setDouble(4,inquilino.getRendaMensal());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace(); }
    }

    @Override
    public void alterar(Inquilino inquilino) {
        String sql = "UPDATE inquilino SET ?, ?, ?, ?, WHERE idInquilino = ?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1,inquilino.getCpf());
            stmt.setString(2,inquilino.getNome());
            stmt.setInt(3,inquilino.getIdInquilino());
            stmt.setDouble(4,inquilino.getRendaMensal());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void apagar(Inquilino inquilino) {
        String sql = "DELETE FROM inquilino WHERE idInquilino=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,inquilino.getIdInquilino());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Inquilino buscar(int idInquilino) {
        String sql = "SELECT * FROM inquilino WHERE idInquilino=?";
        Inquilino a = null;
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,idInquilino);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                a = new Inquilino(
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        rs.getInt("idInquilino"),
                        rs.getDouble("rendaMensal")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    @Override
    public List<Inquilino> buscarTodos() {
        String sql = "SELECT * FROM inquilino";
        List<Inquilino> listaInquilino=new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Inquilino a = new Inquilino(rs.getString("cpf"),
                        rs.getString("nome"),
                        rs.getInt("idInquilino"),
                        rs.getDouble("rendaMensal")
                );
                listaInquilino.add(a);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listaInquilino;    }
}
