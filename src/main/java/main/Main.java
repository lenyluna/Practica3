package main;

import Dao.ArticuloDao;
import Dao.ComenterioDao;
import Dao.EtiquetaDao;
import Dao.UsuarioDao;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import logica.Articulo;
import logica.DataBaseServices;
import logica.H2Services;
import spark.Spark;

import java.io.StringWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.staticFileLocation;
import static spark.Spark.staticFiles;
import static spark.debug.DebugScreen.enableDebugScreen;

/**
 * Created by Leny96 on 15/6/2017.
 */
public class Main {
    //http://localhost:4567
    public static void main(String[] args) {
        UsuarioDao DBusuarios = new UsuarioDao();
        EtiquetaDao DBetiqueta = new EtiquetaDao();
        ArticuloDao DBarticulos = new ArticuloDao();
        ComenterioDao DBcomentario = new ComenterioDao();


        staticFileLocation("/publico");
        final Configuration configuration = new Configuration(new Version(2, 3, 0));
        configuration.setClassForTemplateLoading(Main.class, "/");

        Spark.get("/", (request, response) -> {
            StringWriter writer = new StringWriter();

            List<Articulo> allArticulos = DBarticulos.getAllArticulos();
            try {
                Template formTemplate = configuration.getTemplate("templates/index.ftl");
                Map<String, Object> map = new HashMap<>();
                map.put("ListaArticulos", allArticulos);
                formTemplate.process(map, writer);
            } catch (Exception e) {
                System.out.println(e.toString());
                e.printStackTrace();
                Spark.halt(500);
            }
            return writer;
        });

    }
}
