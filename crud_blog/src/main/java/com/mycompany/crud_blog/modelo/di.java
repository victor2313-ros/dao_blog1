
package com.mycompany.crud_blog.modelo;

import java.time.LocalDate;
public class di {
    private int id;
    private LocalDate fecha;
    private String titulo;
    private String contenido;

    public di() {
        this.id =0;
        this.fecha= null;
        this.titulo="";
        this.contenido="";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    
}
