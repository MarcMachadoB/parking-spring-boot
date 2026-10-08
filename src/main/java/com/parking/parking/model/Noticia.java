package com.parking.parking.model;

public class Noticia {
    private String titol;
    private String cos;
    
    public Noticia() {
    }

    public Noticia(String titol, String cos) {
        this.titol = titol;
        this.cos = cos;
    }
    public String getTitol() {
        return titol;
    }
    public void setTitol(String titol) {
        this.titol = titol;
    }
    public String getCos() {
        return cos;
    }
    public void setCos(String cos) {
        this.cos = cos;
    }

    

}
