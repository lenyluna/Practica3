package logica;

import java.util.ArrayList;

/**
 * Created by Leny96 on 15/6/2017.
 */
public class Articulo {
    private long id;
    private String titulo;
    private String cuerpo;
    private String autor;
    private String fecha;
    private ArrayList<Comentario> listaComentarios;
    private ArrayList<Etiqueta> listaEtiqueta;
    private String cuerpo70;

    public void setListaComentarios(ArrayList<Comentario> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    public String getCuerpo70() {
        return cuerpo70;
    }

    public void setCuerpo70(String cuerpo70) {
        this.cuerpo70 = cuerpo70;
    }

    public Articulo(String titulo, String cuerpo, String autor, String fecha) {
        this.id = id;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.autor = autor;
        this.fecha = fecha;
        this.listaComentarios = new ArrayList<Comentario>();
        this.listaEtiqueta = new ArrayList<Etiqueta>();
        this.cuerpo70 = cuerpo70;
    }

    public ArrayList<Comentario> getListaComentarios() {
        return listaComentarios;
    }
    public void setListaEtiqueta(ArrayList<Etiqueta> listaEtiqueta) {
        this.listaEtiqueta = listaEtiqueta;
    }
    public ArrayList<Etiqueta> getListaEtiqueta() {
        return listaEtiqueta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void addEtiqueta(Etiqueta et){
            listaEtiqueta.add(et);

    }
    public void addComentario(Comentario com){
        listaComentarios.add(com);
    }
}

