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
public class Filme {
    private int id;
    private Genero genero;
    private Tipo tipo;
    private String titulo;
    private String dimensao;
    private String sinopse;
    private String elenco;
    private String direcao;
    private String faixa_etaria;
    private int duracao;
    private String link;

    public Filme(int id, Genero genero, Tipo tipo, String sinopse, String titulo, String dimensao, String elenco, String direcao, String faixa_etaria, int duracao, String link) {
        this.id = id;
        this.sinopse = sinopse;
        this.genero = genero;
        this.tipo = tipo;
        this.titulo = titulo;
        this.dimensao = dimensao;
        this.elenco = elenco;
        this.direcao = direcao;
        this.faixa_etaria = faixa_etaria;
        this.duracao = duracao;
        this.link = link;
    }

    public Filme() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDimensao() {
        return dimensao;
    }

    public void setDimensao(String dimensao) {
        this.dimensao = dimensao;
    }

    public String getElenco() {
        return elenco;
    }

    public void setElenco(String elenco) {
        this.elenco = elenco;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public String getFaixa_etaria() {
        return faixa_etaria;
    }

    public void setFaixa_etaria(String faixa_etaria) {
        this.faixa_etaria = faixa_etaria;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
    

    public String getSinopse() {
        return sinopse;
    }
}
