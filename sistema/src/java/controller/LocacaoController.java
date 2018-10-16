package controller;

import java.io.IOException;
import java.io.PrintWriter;
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

public class LocacaoController extends Controller {

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

    public void adicionar_locacao() throws ServletException, IOException, SQLException {
        
       
    }
     public void manipulador_locacao() throws ServletException, IOException, SQLException {
           
       this.request.setAttribute("vetLocacoes", new LocacaoDAO().listar());
       
    }
    
    public void editar_locacao() throws ServletException, IOException, SQLException {        
       this.request.setAttribute("id_locacao", this.request.getParameter("id"));
    }

    public void adicionar() throws ServletException, IOException, SQLException, ParseException {
        // depois de executar a função de adicionar - redireciono para a função de listar (que está no mesmo controller)
        Locacao locacao = new Locacao();
        locacao.setSala( Integer.parseInt(this.request.getParameter("sala")));
      
        String[] auxiliar = (this.request.getParameter("hora")).split(":");
        Time time = new Time(Integer.parseInt(auxiliar[0]), Integer.parseInt(auxiliar[1]), 0);  
        
        locacao.setHora(time);
        
        
        /*SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date data = (java.util.Date) formatter.parse(this.request.getParameter("data"));
        
        locacao.setData((Date) data);*/
        
        new LocacaoDAO().adicionar(locacao);
        // momento do redirecionamento
        this.redirect("adicionar_locacao");
    }

    public void deletar() throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(this.request.getParameter("id"));
        ArrayList<Sessao> sessoes = new SessaoDAO().listar();
        for (int i = 0; i < sessoes.size(); i++) {
            if (sessoes.get(i).getLocacao() == new LocacaoDAO().obter(id)){
                new SessaoDAO().excluir(sessoes.get(i).getId());
            }
        }
        new LocacaoDAO().excluir(id);
        this.redirect("index");
    }

    public void editar() throws ServletException, IOException, SQLException, ParseException {
        Locacao locacao = new Locacao();
        locacao.setId(Integer.parseInt(this.request.getParameter("id_locacao")));
        locacao.setSala( Integer.parseInt(this.request.getParameter("sala")));
        SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");  
        Date data = (Date) formatador.parse(this.request.getParameter("hora"));  
        Time time = new Time(data.getTime());  
        locacao.setHora(time);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
        java.sql.Date dataAux = new java.sql.Date(format.parse(this.request.getParameter("data")).getTime()); 
        locacao.setData(dataAux);
        
        new LocacaoDAO().editar(locacao);
        // momento do redirecionamento
        this.redirect("index");
    }
/*
    public void search() throws IOException, SQLException {
        // como é uma requisicao ajax (não haverá redirecionamento)      
        this.hasPageJsp = false;
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        if (!request.getParameter("user").isEmpty()) {
            PessoaDAO pessoaDAO = new PessoaDAO();
            System.out.println("=================================");
            System.out.println("=================================");
            System.out.println("User:" + request.getParameter("user"));
            System.out.println("=================================");
            System.out.println("=================================");
            Pessoa pessoa = pessoaDAO.buscar(request.getParameter("user"));
            // essa será a string retornada
            if (pessoa.getId() > 0) {
                response.getWriter().write("Pessoa encontrada:" + pessoa.getNome() + " " + pessoa.getSobrenome());
            } else {
                response.getWriter().write("Nenhuma pessoa encontrada");
            }
        } else {
            response.getWriter().write("User em branco...");
        }
    }*/
}
