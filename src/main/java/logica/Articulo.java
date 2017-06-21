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

    public Articulo(String titulo, String cuerpo, String autor, String fecha) {
        this.id = id;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.autor = autor;
        this.fecha = fecha;
        this.listaComentarios = new ArrayList<Comentario>();
        this.listaEtiqueta = new ArrayList<Etiqueta>();
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
}

