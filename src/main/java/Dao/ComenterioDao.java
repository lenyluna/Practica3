package Dao;

import logica.Articulo;
import logica.Comentario;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

/**
 * Created by No. GP62 on 16/06/2017.
 */
public class ComenterioDao {

    private Sql2o sql2o;

    public ComenterioDao() {
        //subiendola en modo Embedded
        this.sql2o = new Sql2o("jdbc:h2:~/blog", "root", "");
        crearTabla();
        //cargaDemo();
    }

    /**
     *
     */
    private void crearTabla() {
        String sql = "CREATE TABLE IF NOT EXISTS COMENTARIOS" +
                "(ID INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL," +
                "COMENTARIO VARCHAR(1500) NOT NULL," +
                "AUTOR VARCHAR(30) NOT NULL, FOREIGN KEY (AUTOR) REFERENCES USER(USERNAME)," +
                "ARTICULO INTEGER NOT NULL,FOREIGN KEY (ARTICULO) REFERENCES ARTICULOS(ID) "+");";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        }
    }

    private void cargaDemo() {
        System.out.println("Cargando el demo COMENTARIO...");
        if (getAllComentarios().isEmpty()) {
            crearDataDemo();
        }
    }

    public List<Comentario> getAllComentarios() {
        String sql = "select * from COMENTARIOS ";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Comentario.class);
        }
    }

    public void crearDataDemo() {
        String sql = "insert into ARTICULOS (TITULO, CUERPO, AUTOR, FECHA) values(:TITULO, :CUERPO, :AUTOR, :FECHA)";
        try (Connection con = sql2o.open()) {

            con.createQuery(sql)
                    .addParameter("TITULO", "PRIMER POST")
                    .addParameter("CUERPO", "ESTE ES EL PRIMER POST DEL BLOG")
                    .addParameter("AUTOR", "zomgod")
                    .addParameter("FECHA", "16/06/2017")
                    .executeUpdate();

            con.createQuery(sql)
                    .addParameter("TITULO", "SEGUNDO POST")
                    .addParameter("CUERPO", "ESTE ES EL SEGUNDO POST DEL BLOG")
                    .addParameter("AUTOR", "lenyluna")
                    .addParameter("FECHA", "16/06/2017")
                    .executeUpdate();
        }
    }
}
