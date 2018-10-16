package persistencia;

import java.sql.*;
import java.util.ArrayList;
import negocio.Tipo;

public class TipoDAO {

    // SQLs

    private PreparedStatement listar;
    private PreparedStatement obter;
    private PreparedStatement excluir;
    private PreparedStatement atualizar;
    private PreparedStatement adicionar;
    private PreparedStatement buscar;

    // Conexao
    private ConexaoPostgreSQL con;

    public TipoDAO() throws SQLException {
        try {
            this.con = new ConexaoPostgreSQL();
            this.obter = con.getConnection().prepareStatement("select * from tipo where id = ?;");
            this.buscar = con.getConnection().prepareStatement("select * from tipo where importancia ilike ?;");
            this.listar = con.getConnection().prepareStatement("select * from tipo order by importancia;");
            this.excluir = con.getConnection().prepareStatement("delete from tipo where id = ?;");
            this.atualizar = con.getConnection().prepareStatement("update tipo set importancia = ?,  where id = ?;");
            this.adicionar = con.getConnection().prepareStatement("insert into tipo (importancia) values (?) returning id;");
        } catch (Exception ex) {
            System.out.println("Erro conexao!!");
        }

    }

    public Tipo obter(int id) throws SQLException {
        this.obter.setInt(1, id);
        ResultSet rs = this.obter.executeQuery();
        Tipo tipo = new Tipo();
        if (rs.next()) {
            tipo.setId(rs.getInt("id"));
            tipo.setImportancia(rs.getString("importancia"));
        }
        this.obter.close();
        return tipo;
    }

    public ArrayList<Tipo> listar() throws SQLException {
        ArrayList<Tipo> tipos = new ArrayList();
        ResultSet rs;
        try {
            rs = this.listar.executeQuery();
            while (rs.next()) {
                tipos.add(new Tipo(rs.getInt("id"), rs.getString("importancia")));
            }
            this.listar.close();
        } catch (SQLException e) {
            return tipos;
        }
        return tipos;
    }

    public boolean adicionar(Tipo tipo) {
        try {
            this.adicionar.setString(1, tipo.getImportancia());
            return this.adicionar.execute();
        } catch (Exception erro) {
            System.out.println("Erro: insert tipo");
            return false;
        }
    }

    public void excluir(int id) throws SQLException {
        this.excluir.setInt(1, id); // deletando os dependentes
        this.excluir.execute();
        this.excluir.close();
    }

    public boolean editar(Tipo tipo) {
        try {
            this.atualizar.setInt(2, tipo.getId());
            this.atualizar.setString(1, tipo.getImportancia());
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

    public Tipo buscar(String importancia) throws SQLException {
        this.buscar.setString(1, "%" + importancia.trim() + "%");
        ResultSet rs = this.buscar.executeQuery();
        Tipo tipo = new Tipo();
        if (rs.next()) {
            tipo.setId(rs.getInt("id"));
            tipo.setImportancia(rs.getString("importancia"));
        }
        this.obter.close();
        return tipo;
    }
}
