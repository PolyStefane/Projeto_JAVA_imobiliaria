package data;
import model.Imovel;
import model.Proprietario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ImovelSqliteDAO implements ImovelDAO {
    @Override
    public void salvar(Imovel imovel) {
        String sql = "INSERT INTO imovel(, idImovel, endereco, valorAluguel, proprietario) VALUES (?,?,?,?)";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,imovel.getIdImovel());
            stmt.setString(2,imovel.getEndereco());
            stmt.setDouble(3,imovel.getValorAluguel());
            stmt.setInt(4,imovel.getProprietario().getIdProprietario());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace(); }
    }

    @Override
    public void alterar(Imovel imovel) {
        String sql = "UPDATE aluguel SET endereco=?, valorAluguel=?, proprietario=? WHERE idAluguel=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1,imovel.getEndereco());
            stmt.setDouble(2,imovel.getValorAluguel());
            stmt.setInt(3,imovel.getProprietario().getIdProprietario());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void apagar(Imovel imovel) {
        String sql = "DELETE FROM imovel WHERE idImovel=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,imovel.getIdImovel());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Imovel buscar(int idImovel) {
        String sql = "SELECT * FROM imovel WHERE idImovel=?";
        Imovel a=null;
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,idImovel);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                Proprietario proprietario = new ProprietarioSqliteDAO().buscar(rs.getInt("proprietario"));

                a = new Imovel(rs.getInt("idImovel"),
                        rs.getString("endereco"),
                        rs.getDouble("valorAluguel"),
                        proprietario
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    @Override
    public List<Imovel> buscarTodos() {
        String sql = "SELECT * FROM imovel";
        List<Imovel> listaImoveis=new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String cpf = rs.getString("cpf");
                String nome = rs.getString("nome");
                int idProp = rs.getInt("idProp");
                String banco = rs.getString("banco");
                String conta = rs.getString("conta");
                Proprietario proprietario = new Proprietario(cpf, nome, idProp, banco, conta);

                int idImovel = rs.getInt("idImovel");
                String endereco = rs.getString("endereco");
                double valorAluguel = rs.getDouble("valorAluguel");

                Imovel imovel = new Imovel(idImovel, endereco, valorAluguel, proprietario);
                listaImoveis.add(imovel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaImoveis;}
}
