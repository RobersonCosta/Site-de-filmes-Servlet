package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import negocio.Filme;
import negocio.Sessao;
import persistencia.FilmeDAO;
import persistencia.GeneroDAO;
import persistencia.SessaoDAO;
import persistencia.TipoDAO;

public class FilmeController extends Controller {

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

    public void adicionar_filme() throws ServletException, IOException, SQLException {
        // irá cair para a tela_adicionar.jsp
       this.request.setAttribute("vetGeneros", new GeneroDAO().listar());
       this.request.setAttribute("vetTipos", new TipoDAO().listar());
       
    }
    public void pagina_do_filme() throws ServletException, IOException, SQLException {
        // irá cair para a tela_adicionar.jsp
       this.request.setAttribute("sessao", this.request.getParameter("id_sessao"));
       
    }
	
	public void filmes_em_cartaz() throws ServletException, IOException, SQLException {           
            this.request.setAttribute("vetSessoes", new SessaoDAO().listar());
           
       
    }
	
	public void filmes_estreia() throws ServletException, IOException, SQLException {
           ArrayList<Sessao> sessoes = new SessaoDAO().listar();
           ArrayList<Sessao> sessoesAux = new ArrayList();
           
            for (int i = 0; i < sessoes.size(); i++) {
                if (sessoes.get(i).getFilme().getTipo().getImportancia().equals("Estréia") && sessoes.get(i).getFilme().getTipo().getImportancia().equals("Pré-Estréia")) {
                    sessoesAux.add(sessoes.get(i));
                }
            }
            
            this.request.setAttribute("vetSessoes", sessoesAux);
           
       
    }
	
    public void manipulador_filme() throws ServletException, IOException, SQLException {  
        System.out.println("========================");
        System.out.println("sadfsdfsadfsadfsadfsad"+new FilmeDAO().listar().get(0).getElenco());
        System.out.println("========================");
       this.request.setAttribute("vetFilmes", new FilmeDAO().listar());
    }
    
    public void editar_filme() throws ServletException, IOException, SQLException {
        // irá cair para a tela_adicionar.jsp
       this.request.setAttribute("vetGeneros", new GeneroDAO().listar());
       this.request.setAttribute("vetTipos", new TipoDAO().listar());
       this.request.setAttribute("id_filme", this.request.getParameter("id"));
       
    }
    
    public void adicionar() throws ServletException, IOException, SQLException {
        // depois de executar a função de adicionar - redireciono para a função de listar (que está no mesmo controller)
        Filme filme = new Filme();
        filme.setTitulo(this.request.getParameter("titulo"));
        System.out.println(this.request.getParameter("genero"));
        filme.setGenero(new GeneroDAO().buscar(this.request.getParameter("genero")));
        filme.setTipo(new TipoDAO().buscar(this.request.getParameter("tipo")));
        if (this.request.getParameter("dimensao").equals("3D")) {
            filme.setDimensao("3D");
        } else {
            filme.setDimensao("2D");
        }
        filme.setSinopse(this.request.getParameter("sinopse"));
        filme.setElenco(this.request.getParameter("elenco"));
        filme.setDirecao(this.request.getParameter("direcao"));
        filme.setFaixa_etaria(this.request.getParameter("faixa_etaria"));    
        filme.setDuracao(Integer.parseInt(this.request.getParameter("duracao")));
        String[] auxiliar = (this.request.getParameter("link")).split("=");
        filme.setLink("http://www.youtube.com/embed/"+auxiliar[1]);
        
        new FilmeDAO().adicionar(filme);
        // momento do redirecionamento
        this.redirect("adicionar_filme");
    }

    public void deletar() throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(this.request.getParameter("id"));
        ArrayList<Sessao> sessoes = new SessaoDAO().listar();
        for (int i = 0; i < sessoes.size(); i++) {
            if (sessoes.get(i).getFilme() == new FilmeDAO().obter(id)){
                new SessaoDAO().excluir(sessoes.get(i).getId());
            }
        }
        new FilmeDAO().excluir(id);
        this.redirect("index");
    }

    public void editar() throws ServletException, IOException, SQLException {
        Filme filme = new Filme();
        filme.setId(Integer.parseInt(this.request.getParameter("id_filme")));
        filme.setTitulo(this.request.getParameter("titulo"));
        filme.setGenero(new GeneroDAO().buscar(this.request.getParameter("genero")));
        filme.setTipo(new TipoDAO().buscar(this.request.getParameter("tipo")));
        if (this.request.getParameter("dimensao").equals("3D")) {
            filme.setDimensao("3D");
        } else {
            filme.setDimensao("2D");
        }
        filme.setSinopse(this.request.getParameter("sinopse"));
        filme.setElenco(this.request.getParameter("elenco"));
        filme.setDirecao(this.request.getParameter("direcao"));
        filme.setElenco(this.request.getParameter("faixa_etaria"));        
        filme.setDuracao(Integer.parseInt(this.request.getParameter("duracao")));
        String[] auxiliar = (this.request.getParameter("link")).split("=");
        filme.setLink(this.request.getParameter("http://www.youtube.com/embed/"+auxiliar[1]));
        
        new FilmeDAO().editar(filme);
        // momento do redirecionamento
        this.redirect("index");
    }
}