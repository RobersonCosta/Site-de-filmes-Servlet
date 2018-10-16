/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;


import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author aluno
 */
public class Locacao {
    private int id;
    private int sala;
    private Time hora;
    private Date data;

    public Locacao(int id, int sala, Time hora, Date data) {
        this.id = id;
        this.sala = sala;
        this.hora = hora;
        this.data = data;
    }

    public Locacao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
