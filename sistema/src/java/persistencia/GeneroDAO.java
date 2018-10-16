package persistencia;

import java.sql.*;
import java.util.ArrayList;
import negocio.Genero;

public class GeneroDAO {

    // SQLs

    private PreparedStatement listar;
    private PreparedStatement obter;
    private PreparedStatement excluir;
    private PreparedStatement atualizar;
    private PreparedStatement adicionar;
    private PreparedStatement buscar;

    // Conexao
    private ConexaoPostgreSQL con;

    public GeneroDAO() throws SQLException {
        try {
            this.con = new ConexaoPostgreSQL();
            this.obter = con.getConnection().prepareStatement("select * from genero where id = ?;");
            this.buscar = con.getConnection().prepareStatement("select * from genero where nome ilike ?;");
            this.listar = con.getConnection().prepareStatement("select * from genero order by nome;");
            this.excluir = con.getConnection().prepareStatement("delete from genero where id = ?;");
            this.atualizar = con.getConnection().prepareStatement("update genero set nome = ?,  where id = ?;");
            this.adicionar = con.getConnection().prepareStatement("insert into genero (nome) values (?) returning id;");
        } catch (Exception ex) {
            System.out.println("Erro conexao!!");
        }

    }

    public Genero obter(int id) throws SQLException {
        this.obter.setInt(1, id);
        ResultSet rs = this.obter.executeQuery();
        Genero genero = new Genero();
        if (rs.next()) {
            genero.setId(rs.getInt("id"));
            genero.setNome(rs.getString("nome"));
        }
        this.obter.close();
        return genero;
    }

    public ArrayList<Genero> listar() throws SQLException {       
        try {
        ArrayList<Genero> generos = new ArrayList();
        ResultSet rs = this.listar.executeQuery();          
            while (rs.next()) {
                generos.add(new Genero(rs.getInt("id"), rs.getString("nome")));
            }
            this.listar.close();
            return generos;
        } catch (SQLException e) {
           // return generos;
        }
        return new ArrayList();
    }

    public boolean adicionar(Genero genero) {
        try {
            this.adicionar.setString(1, genero.getNome());
            return this.adicionar.execute();
        } catch (Exception erro) {
            System.out.println("Erro: insert genero");
            return false;
        }
    }

    public void excluir(int id) throws SQLException {
        this.excluir.setInt(1, id); // deletando os dependentes
        this.excluir.execute();
        this.excluir.close();
    }

    public boolean editar(Genero genero) {
        try {
            this.atualizar.setInt(2, genero.getId());
            this.atualizar.setString(1, genero.getNome());
            this.atualizar.execute();
            this.atualizar.close();
            return true;
        } catch (Exception erro) {
            return false;
        }
    }

    public boolean autenticar(String login, String senha) {
        return login.equals("admin") && senha.equals("123");
    }

    public Genero buscar(String nome) throws SQLException {
        this.buscar.setString(1,nome);
        ResultSet rs = this.buscar.executeQuery();
        Genero genero = new Genero();
        if (rs.next()) {
            genero.setId(rs.getInt("id"));
            genero.setNome(rs.getString("nome"));
        }
        this.obter.close();
        return genero;
    }
}
