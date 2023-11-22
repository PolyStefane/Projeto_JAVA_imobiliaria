package data;
import model.Proprietario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ProprietarioSqliteDAO implements ProprietarioDAO {

    @Override
    public void salvar(Proprietario proprietario) {
        String sql = "INSERT INTO proprietario (cpf, nome,idProp, banco, conta) VALUES (?,?,?,?,?)";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1,proprietario.getCpf());
            stmt.setString(2,proprietario.getNome());
            stmt.setInt(3,proprietario.getIdProprietario());
            stmt.setString(4,proprietario.getBanco());
            stmt.setString(5,proprietario.getConta());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace(); }
    }

    @Override
    public void alterar(Proprietario proprietario) {
        String sql = "UPDATE proprietario SET ?, ?, ?, ?, ?, WHERE idProp = ?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1,proprietario.getCpf());
            stmt.setString(2,proprietario.getNome());
            stmt.setInt(3,proprietario.getIdProprietario());
            stmt.setString(4,proprietario.getBanco());
            stmt.setString(5,proprietario.getConta());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void apagar(Proprietario proprietario) {
        String sql = "DELETE FROM proprietario WHERE idProp=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,proprietario.getIdProprietario());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Proprietario buscar(int idProprietario) {
        String sql = "SELECT * FROM proprietario WHERE idProp=?";
        Proprietario a = null;
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,idProprietario);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                a = new Proprietario(
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        rs.getInt("idProp"),
                        rs.getString("banco"),
                        rs.getString("conta")
                        );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    @Override
    public List<Proprietario> buscarTodos() {

        String sql = "SELECT * FROM proprietario";
        List<Proprietario> listaProprietarios=new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Proprietario a = new Proprietario(rs.getString("cpf"),
                                                    rs.getString("nome"),
                                                    rs.getInt("idProp"),
                                                    rs.getString("banco"),
                                                    rs.getString("conta")
                                                    );
                listaProprietarios.add(a);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listaProprietarios;

    }
}
