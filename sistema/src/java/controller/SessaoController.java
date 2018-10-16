package controller;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Double.parseDouble;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import negocio.Filme;
import negocio.Locacao;
import negocio.Sessao;
import persistencia.FilmeDAO;
import persistencia.GeneroDAO;
import persistencia.LocacaoDAO;
import persistencia.SessaoDAO;
import persistencia.TipoDAO;

public class SessaoController extends Controller {

    public void autenticar() throws SQLException, IOException {
        /* PrintWriter out;
         out = this.response.getWriter();
         HttpSession session = this.request.getSession(true);
         session.setAttribute("login", this.request.getParameter("login"));
         session.setAttribute("senha", this.request.getParameter("senha"));
         out.println("Login:" + this.request.getParameter("login"));
         out.println("Senha:" + this.request.getParameter("senha"));
         out.println("Autenticou?:" + new PessoaDAO().autenticar(this.request.getParameter("login"), this.request.getParameter("senha")));
         // caso eu determine que não ha nem redirecionamento nem pagina jsp
         this.hasPageJsp = false;*/
    }
    public void manipulador_sessao() throws ServletException, IOException, SQLException {
           
       this.request.setAttribute("vetSessoes", new SessaoDAO().listar());
       
    }
    

    public void adicionar_sessao() throws ServletException, IOException, SQLException {
        // irá cair para a tela_adicionar.jsp       
       this.request.setAttribute("vetFilmes", new FilmeDAO().listar());
       this.request.setAttribute("vetLocacoes", new LocacaoDAO().listar());
    }
    
    public void editar_sessao() throws ServletException, IOException, SQLException {        
       this.request.setAttribute("vetFilmes", new FilmeDAO().listar());
       this.request.setAttribute("vetLocacoes", new LocacaoDAO().listar());      
       this.request.setAttribute("id_sessao", this.request.getParameter("id"));
    }

    public void adicionar() throws ServletException, IOException, SQLException, ParseException {
        // depois de executar a função de adicionar - redireciono para a função de listar (que está no mesmo controller)
        Sessao sessao = new Sessao();
        sessao.setFilme( new FilmeDAO().buscar(this.request.getParameter("filme")) );
        String[] auxiliar= (this.request.getParameter("locacao")).split("ID");
        int id = Integer.parseInt(auxiliar[1]);
        sessao.setLocacao( new LocacaoDAO().obter(id));
        sessao.setValor(parseDouble(this.request.getParameter("valor")));
        
        new SessaoDAO().adicionar(sessao);
        // momento do redirecionamento
        this.redirect("index");
    }

    public void excluir() throws ServletException, IOException, SQLException {
        new SessaoDAO().excluir(Integer.parseInt(this.request.getParameter("id_sessao")));
        this.redirect("index");
    }
    
    public void consultar_sessao() throws SQLException{
        int id = Integer.parseInt(this.request.getParameter("id_sessao"));
        Filme filme = new Filme();
        Locacao locacao =new Locacao();
        ArrayList<Filme> filmes = new FilmeDAO().listar();
        ArrayList<Locacao> locacoes = new LocacaoDAO().listar();
        for (int i = 0; i < filmes.size(); i++) {
            if (filmes.get(i) == new SessaoDAO().obter(id).getFilme()){
                filme = filmes.get(i);
            }
        }
        for (int i = 0; i < locacoes.size(); i++) {
            if (locacoes.get(i) == new SessaoDAO().obter(id).getLocacao()){
                locacao = locacoes.get(i);
            }
        }
         
       this.request.setAttribute("titulo", filme.getTitulo());
       this.request.setAttribute("sala", locacao.getSala());
       this.request.setAttribute("hora", locacao.getHora());
       this.request.setAttribute("data", locacao.getData());
    }

    public void editar() throws ServletException, IOException, SQLException {
        Sessao sessao = new Sessao();
        sessao.setId(Integer.parseInt(this.request.getParameter("id_sessao")));
        sessao.setFilme( new FilmeDAO().buscar(this.request.getParameter("filme")) );
        String[] auxiliar= (this.request.getParameter("locacao")).split("ID");
        int id = Integer.parseInt(auxiliar[1]);
        sessao.setLocacao( new LocacaoDAO().obter(id));
        sessao.setValor(parseDouble(this.request.getParameter("valor")));
        
        new SessaoDAO().editar(sessao);
        // momento do redirecionamento
        this.redirect("index");
    }
    
}
