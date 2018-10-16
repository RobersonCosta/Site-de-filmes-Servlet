package persistencia;

import java.sql.*;
import java.util.ArrayList;
import negocio.Filme;

public class FilmeDAO {

    // SQLs

    private PreparedStatement listar;
    private PreparedStatement obter;
    private PreparedStatement excluir;
    private PreparedStatement atualizar;
    private PreparedStatement adicionar;
    private PreparedStatement buscar;

    // Conexao
    private ConexaoPostgreSQL con;

    public FilmeDAO() throws SQLException {
        try {
            this.con = new ConexaoPostgreSQL();
            this.obter = con.getConnection().prepareStatement("select * from filme where id = ?;");
            this.buscar = con.getConnection().prepareStatement("select * from filme where titulo ilike ?;");
            this.listar = con.getConnection().prepareStatement("select * from filme order by titulo");
            this.excluir = con.getConnection().prepareStatement("delete from filme where id = ?;");
            this.atualizar = con.getConnection().prepareStatement("update filme set id_genero = ?, id_tipo = ?, titulo = ?, dimensao = ?, sinopse = ?, elenco = ?, direcao =?, faixa_etaria =?, duracao=?,"
                    + "link = ?,  where id = ?;");
            this.adicionar = con.getConnection().prepareStatement("insert into filme (id_genero, id_tipo, titulo, dimensao, sinopse, elenco, direcao, faixa_etaria, duracao,link) values (?,?,?,?,?,?,?,?,?,?);");
        } catch (Exception ex) {
            System.out.println("Erro conexao!!");
        }

    }

    public Filme obter(int id) throws SQLException {
        this.obter.setInt(1, id);
        ResultSet rs = this.obter.executeQuery();
        Filme filme = new Filme();
        GeneroDAO generoDAO = new GeneroDAO();
        TipoDAO tipoDAO = new TipoDAO();
        if (rs.next()) {
            filme.setId(rs.getInt("id"));
            filme.setGenero(generoDAO.obter(rs.getInt("id_genero")));
            filme.setTipo(tipoDAO.obter(rs.getInt("id_tipo")));
            filme.setTitulo(rs.getString("titulo"));
            filme.setDimensao(rs.getString("dimensao"));
            filme.setSinopse(rs.getString("sinopse"));
            filme.setElenco(rs.getString("elenco"));
            filme.setDirecao(rs.getString("direcao"));
            filme.setFaixa_etaria(rs.getString("faixa_etaria"));
            filme.setDuracao(rs.getInt("duracao"));
            filme.setLink(rs.getString("link"));
        }
        this.obter.close();
        return filme;
    }

    public ArrayList<Filme> listar() throws SQLException {
        ArrayList<Filme> filmes = new ArrayList();
        GeneroDAO generoDAO = new GeneroDAO();
        TipoDAO tipoDAO = new TipoDAO();
        ResultSet rs;
        try {
            rs = this.listar.executeQuery();
            while (rs.next()) {
                filmes.add(new Filme(rs.getInt("id"), generoDAO.obter(rs.getInt("id_genero")), tipoDAO.obter(rs.getInt("id_tipo")), rs.getString("titulo"), rs.getString("dimensao"), rs.getString("sinopse"), rs.getString("elenco"), rs.getString("direcao"), rs.getString("faixa_etaria"), rs.getInt("duracao"), rs.getString("link")));
            }
            this.listar.close();
        } catch (SQLException e) {
            System.out.println("=====================");
System.out.println("erro na listagem");
            System.out.println("=====================");
            return filmes;
        }
        return filmes;
    }

    public boolean adicionar(Filme filme) {
       
        try {
            this.adicionar.setInt(1, filme.getGenero().getId());
            this.adicionar.setInt(2, filme.getTipo().getId());
            this.adicionar.setString(3, filme.getTitulo());            
            this.adicionar.setString(4, filme.getDimensao());
            this.adicionar.setString(5, filme.getSinopse());
            this.adicionar.setString(6, filme.getElenco());
            this.adicionar.setString(7, filme.getDirecao());            
            this.adicionar.setString(8, filme.getFaixa_etaria());
            this.adicionar.setInt(9, filme.getDuracao());
            this.adicionar.setString(10, filme.getLink());
            System.out.println("VAI TOMA NO CU SAHUSAHUSAHU");
            return this.adicionar.execute();
        } catch (Exception erro) {
            System.out.println("Erro: insert filme");
            return false;
        }
    }

    public void excluir(int id) throws SQLException {
        this.excluir.setInt(1, id); // deletando os dependentes
        this.excluir.execute();
        this.excluir.close();
    }

    public boolean editar(Filme filme) {
        try {
            this.atualizar.setInt(1, filme.getGenero().getId());
            this.atualizar.setInt(2, filme.getTipo().getId());
            this.atualizar.setString(3, filme.getTitulo());            
            this.atualizar.setString(4, filme.getDimensao());
            this.atualizar.setString(5, filme.getSinopse());
            this.atualizar.setString(6, filme.getElenco());
            this.atualizar.setString(7, filme.getDirecao());            
            this.atualizar.setString(8, filme.getFaixa_etaria());
            this.atualizar.setInt(9, filme.getDuracao());
            this.atualizar.setString(10, filme.getLink());
            this.atualizar.setInt(11, filme.getId());
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

    public Filme buscar(String nome) throws SQLException {
        this.buscar.setString(1, "%" + nome.trim() + "%");
        ResultSet rs = this.buscar.executeQuery();
        Filme filme = new Filme();
        GeneroDAO generoDAO = new GeneroDAO();
        TipoDAO tipoDAO = new TipoDAO();
        if (rs.next()) {
            filme.setId(rs.getInt("id"));
            filme.setGenero(generoDAO.obter(rs.getInt("id_genero")));
            filme.setTipo(tipoDAO.obter(rs.getInt("id_tipo")));
            filme.setTitulo(rs.getString("titulo"));
            filme.setDimensao(rs.getString("dimensao"));            
            filme.setSinopse(rs.getString("sinopse"));
            filme.setElenco(rs.getString("elenco"));
            filme.setDirecao(rs.getString("direcao"));
            filme.setFaixa_etaria(rs.getString("faixa_etaria"));
            filme.setDuracao(rs.getInt("duracao"));
            filme.setLink(rs.getString("link"));
        }
        this.obter.close();
        return filme;
    }
}
