/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author aluno
 */
public class Sessao {
    private int id;
    private Filme filme;
    private Locacao locacao;
    private double valor;    
    private boolean dublagem;

    public Sessao(int id, Filme filme, Locacao locacao, double valor, boolean dublagem) {
        this.id = id;
        this.filme = filme;
        this.locacao = locacao;
        this.valor = valor;
        this.dublagem = dublagem;
    }

    public Sessao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isDublagem() {
        return dublagem;
    }

    public void setDublagem(boolean dublagem) {
        this.dublagem = dublagem;
    }
}
