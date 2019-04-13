/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.backupsystem.model;

import java.util.Objects;

/**
 *
 * @author Elias Santana
 */
public class Agendamento {
    private int id;
    private int seg;
    private int ter;
    private int qua;
    private int qui;
    private int sex;
    private int sab;
    private int dom;
    private String hora;
    private Tipo tipo;
    
    public enum Tipo{
        TOTAL, DIFERENCIAL, INCREMENTAL
    };

    public Agendamento() {
    }

    public Agendamento(int id, int seg, int ter, int qua, int qui, int sex, int sab, int dom, String hora, Tipo tipo) {
        this.id = id;
        this.seg = seg;
        this.ter = ter;
        this.qua = qua;
        this.qui = qui;
        this.sex = sex;
        this.sab = sab;
        this.dom = dom;
        this.hora = hora;
        this.tipo = tipo;
    }
    
    public Agendamento(int seg, int ter, int qua, int qui, int sex, int sab, int dom, String hora, Tipo tipo) {
      
        this.seg = seg;
        this.ter = ter;
        this.qua = qua;
        this.qui = qui;
        this.sex = sex;
        this.sab = sab;
        this.dom = dom;
        this.hora = hora;
        this.tipo = tipo;
    }
    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeg() {
        return seg;
    }

    public void setSeg(int seg) {
        this.seg = seg;
    }

    public int getTer() {
        return ter;
    }

    public void setTer(int ter) {
        this.ter = ter;
    }

    public int getQua() {
        return qua;
    }

    public void setQua(int qua) {
        this.qua = qua;
    }

    public int getQui() {
        return qui;
    }

    public void setQui(int qui) {
        this.qui = qui;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSab() {
        return sab;
    }

    public void setSab(int sab) {
        this.sab = sab;
    }

    public int getDom() {
        return dom;
    }

    public void setDom(int dom) {
        this.dom = dom;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id;
        hash = 29 * hash + this.seg;
        hash = 29 * hash + this.ter;
        hash = 29 * hash + this.qua;
        hash = 29 * hash + this.qui;
        hash = 29 * hash + this.sex;
        hash = 29 * hash + this.sab;
        hash = 29 * hash + this.dom;
        hash = 29 * hash + Objects.hashCode(this.hora);
        hash = 29 * hash + Objects.hashCode(this.tipo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Agendamento other = (Agendamento) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.seg != other.seg) {
            return false;
        }
        if (this.ter != other.ter) {
            return false;
        }
        if (this.qua != other.qua) {
            return false;
        }
        if (this.qui != other.qui) {
            return false;
        }
        if (this.sex != other.sex) {
            return false;
        }
        if (this.sab != other.sab) {
            return false;
        }
        if (this.dom != other.dom) {
            return false;
        }
        if (!Objects.equals(this.hora, other.hora)) {
            return false;
        }
        return this.tipo == other.tipo;
    }

    
    
    
    
    
    
            
}
