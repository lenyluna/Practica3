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
import logica.Usuario;
import spark.Spark;

import java.io.StringWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static spark.Spark.get;
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
                map.put("login", "false");
                map.put("username","");
                formTemplate.process(map, writer);
            } catch (Exception e) {
                System.out.println(e.toString());
                e.printStackTrace();
                Spark.halt(500);
            }
            return writer;
        });

        Spark.get("/login/", (request, response) -> {
            StringWriter writer = new StringWriter();
            List<Usuario> allUsuarios = DBusuarios.getAllUsuarios();
            List<Articulo> allArticulos = DBarticulos.getAllArticulos();
            try {
                String username = request.queryParams("username") != null ? request.queryParams("username") : "anonymous";
                String password = request.queryParams("password") != null ? request.queryParams("password") : "unknown";

                List<Usuario> result = allUsuarios.stream()
                        .filter(item -> item.getUsername().equals(username))
                        .filter(item -> item.getPassword().equals(password))
                      //  .filter(a -> Objects.equals(a.ge, "three"))
                        .collect(Collectors.toList());

                if(result.isEmpty()){
                    System.out.println("NINGUN USUARIO CON ESA COBINACION DE PARAMETROS ");
                }
                else
                {
                    System.out.println("LOGEADO CON EXITO");
                    Template formTemplate = configuration.getTemplate("templates/index.ftl");
                    Map<String, Object> map = new HashMap<>();
                    map.put("ListaArticulos", allArticulos);
                    map.put("login", "false");
                    map.put("username",username);
                    formTemplate.process(map, writer);

                }

            } catch (Exception e) {

            }


            return writer;
        });


    }

}
