package persistencia;

import java.sql.*;
import java.util.ArrayList;
import negocio.Sessao;

public class SessaoDAO {

    // SQLs

    private PreparedStatement listar;
    private PreparedStatement obter;
    private PreparedStatement excluir;
    private PreparedStatement atualizar;
    private PreparedStatement adicionar;
    private PreparedStatement buscar;

    // Conexao
    private ConexaoPostgreSQL con;

    public SessaoDAO() throws SQLException {
        try {
            this.con = new ConexaoPostgreSQL();
            this.obter = con.getConnection().prepareStatement("select * from sessao where id = ?;");
            this.buscar = con.getConnection().prepareStatement("select * from sessao where nome ilike ?;");
            this.listar = con.getConnection().prepareStatement("select * from sessao order by nome;");
            this.excluir = con.getConnection().prepareStatement("delete from sessao where id = ?;");
            this.atualizar = con.getConnection().prepareStatement("update sessao set sala = ?, hora = ?,  dia = ?, where id = ?;");
            this.adicionar = con.getConnection().prepareStatement("insert into sessao (sala, hora, dia) values (?,?,?) returning id;");
        } catch (Exception ex) {
            System.out.println("Erro conexao!!");
        }

    }

    public Sessao obter(int id) throws SQLException {
        this.obter.setInt(1, id);
        ResultSet rs = this.obter.executeQuery();
        Sessao sessao = new Sessao();
        FilmeDAO filmeDAO = new FilmeDAO();
        LocacaoDAO locacaoDAO = new LocacaoDAO();
        if (rs.next()) {
            sessao.setId(rs.getInt("id"));
            sessao.setFilme(filmeDAO.obter(rs.getInt("id_filme")));
            sessao.setLocacao(locacaoDAO.obter(rs.getInt("id_locacao")));
            sessao.setValor(rs.getDouble("valor"));
            sessao.setDublagem(rs.getBoolean("dublagem"));
        }
        this.obter.close();
        return sessao;
    }

    public ArrayList<Sessao> listar() throws SQLException {
        ArrayList<Sessao> sessoes = new ArrayList();
        FilmeDAO filmeDAO = new FilmeDAO();
        LocacaoDAO locacaoDAO = new LocacaoDAO();
        ResultSet rs;
        try {
            rs = this.listar.executeQuery();
            while (rs.next()) {
                sessoes.add(new Sessao(rs.getInt("id"), filmeDAO.obter(rs.getInt("id_filme")), locacaoDAO.obter(rs.getInt("id_locacao")), rs.getDouble("valor"), rs.getBoolean("dublagem")));
            }
            this.listar.close();
        } catch (SQLException e) {
            return sessoes;
        }
        return sessoes;
    }

    public boolean adicionar(Sessao sessao) {
        try {
            this.adicionar.setInt(1, sessao.getFilme().getId());
            this.adicionar.setInt(2, sessao.getLocacao().getId());
            this.adicionar.setDouble(3, sessao.getValor());
            this.adicionar.setBoolean(4, sessao.isDublagem());
            return this.adicionar.execute();
        } catch (Exception erro) {
            System.out.println("Erro: insert sessao");
            return false;
        }
    }

    public void excluir(int id) throws SQLException {
        this.excluir.setInt(1, id); // deletando os dependentes
        this.excluir.execute();
        this.excluir.close();
    }

    public boolean editar(Sessao sessao) {
        try {
            this.atualizar.setInt(1, sessao.getFilme().getId());
            this.atualizar.setInt(2, sessao.getLocacao().getId());
            this.atualizar.setDouble(3, sessao.getValor());
            this.atualizar.setBoolean(4, sessao.isDublagem());
            this.atualizar.setInt(5,sessao.getId());
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

    public Sessao buscar(String nome) throws SQLException {
        this.buscar.setString(1, "%" + nome.trim() + "%");
        ResultSet rs = this.buscar.executeQuery();
        Sessao sessao = new Sessao();
        FilmeDAO filmeDAO = new FilmeDAO();
        LocacaoDAO locacaoDAO = new LocacaoDAO();
        if (rs.next()) {
            sessao.setId(rs.getInt("id"));
            sessao.setFilme(filmeDAO.obter(rs.getInt("id_filme")));
            sessao.setLocacao(locacaoDAO.obter(rs.getInt("id_locacao")));
            sessao.setValor(rs.getDouble("valor"));
            sessao.setDublagem(rs.getBoolean("dublagem"));
        }
        this.obter.close();
        return sessao;
    }
}
