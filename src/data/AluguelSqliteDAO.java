package data;
import model.Aluguel;
import model.Imovel;
import model.Inquilino;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class AluguelSqliteDAO implements AluguelDAO {


    @Override
    public void salvar(Aluguel aluguel) {
        String sql = "INSERT INTO aluguel( idAluguel, inicioContrato, fimContrato, inquilino, imovel) VALUES (?,?,?,?,?)";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,aluguel.getIdAluguel());
            stmt.setString(2,aluguel.getInicioContrato());
            stmt.setString(3,aluguel.getFimContrato());
            stmt.setInt(4,aluguel.getInquilino().getIdInquilino());
            stmt.setInt(5,aluguel.getImovel().getIdImovel());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace(); }
    }

    @Override
    public void alterar(Aluguel aluguel) {
        String sql = "UPDATE aluguel SET ?, ?, ?, WHERE idAluguel = ?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1,aluguel.getInicioContrato());
            stmt.setString(2,aluguel.getFimContrato());
            stmt.setInt(3,aluguel.getInquilino().getIdInquilino());
            stmt.setInt(4,aluguel.getImovel().getIdImovel());

            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void apagar(Aluguel aluguel) {
        String sql = "DELETE FROM aluguel WHERE idAluguel=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,aluguel.getIdAluguel());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Aluguel buscar(int idAluguel) {
        String sql = "SELECT * FROM aluguel WHERE idAluguel=?";
        Aluguel a=null;
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,idAluguel);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Imovel imo = new ImovelSqliteDAO().buscar(rs.getInt("imovel"));
                Inquilino inq = new InquilinoSqliteDAO().buscar(rs.getInt("inquilino"));
                System.out.println("Inquilino encontrado: " + inq);


                a = new Aluguel(rs.getInt("idAluguel"),
                        rs.getString("inicioContrato"),
                        rs.getString("fimContrato"),imo, inq);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    @Override
    public List<Aluguel> buscarTodos() {
        String sql = "SELECT * FROM aluguel";
        List<Aluguel> listaAluguel=new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Aluguel a = new Aluguel(rs.getInt("idAluguel"),
                        rs.getString("inicioContrato"),
                        rs.getString("fimContrato")
                );
                listaAluguel.add(a);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAluguel;    }
    }
