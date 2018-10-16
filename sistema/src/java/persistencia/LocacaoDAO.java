package persistencia;

import java.sql.*;
import java.util.ArrayList;
import negocio.Locacao;

public class LocacaoDAO {

    // SQLs

    private PreparedStatement listar;
    private PreparedStatement obter;
    private PreparedStatement excluir;
    private PreparedStatement atualizar;
    private PreparedStatement adicionar;
    private PreparedStatement buscar;

    // Conexao
    private ConexaoPostgreSQL con;

    public LocacaoDAO() throws SQLException {
        try {
            this.con = new ConexaoPostgreSQL();
            this.obter = con.getConnection().prepareStatement("select * from locacao where id = ?;");
            this.buscar = con.getConnection().prepareStatement("select * from locacao where nome ilike ?;");
            this.listar = con.getConnection().prepareStatement("select * from locacao order by nome;");
            this.excluir = con.getConnection().prepareStatement("delete from locacao where id = ?;");
            this.atualizar = con.getConnection().prepareStatement("update locacao set sala = ?, hora = ?,  dia = ?, where id = ?;");
            this.adicionar = con.getConnection().prepareStatement("insert into locacao (sala, hora, dia) values (?,?,?);");
        } catch (Exception ex) {
            System.out.println("Erro conexao!!");
        }

    }

    public Locacao obter(int id) throws SQLException {
        this.obter.setInt(1, id);
        ResultSet rs = this.obter.executeQuery();
        Locacao locacao = new Locacao();
        if (rs.next()) {
            locacao.setId(rs.getInt("id"));
            locacao.setSala(rs.getInt("sala"));
            locacao.setHora(rs.getTime("hora"));
            locacao.setData(rs.getDate("data"));
        }
        this.obter.close();
        return locacao;
    }

    public ArrayList<Locacao> listar() throws SQLException {
        ArrayList<Locacao> locacoes = new ArrayList();
        ResultSet rs;
        try {
            rs = this.listar.executeQuery();
            while (rs.next()) {
                locacoes.add(new Locacao(rs.getInt("id"), rs.getInt("sala"), rs.getTime("hora"), rs.getDate("data")));
            }
            this.listar.close();
        } catch (SQLException e) {
            return locacoes;
        }
        return locacoes;
    }

    public boolean adicionar(Locacao locacao) {
        try {
            this.adicionar.setInt(1, locacao.getSala());
            this.adicionar.setTime(2, locacao.getHora());
            return this.adicionar.execute();
        } catch (Exception erro) {
            System.out.println("Erro: insert locacao");
            return false;
        }
    }

    public void excluir(int id) throws SQLException {
        this.excluir.setInt(1, id); // deletando os dependentes
        this.excluir.execute();
        this.excluir.close();
    }

    public boolean editar(Locacao locacao) {
        try {
            this.atualizar.setInt(1, locacao.getSala());
            this.atualizar.setTime(2, locacao.getHora());
            this.atualizar.setDate(3, locacao.getData());
            this.atualizar.setInt(4,locacao.getId());
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

    
}
