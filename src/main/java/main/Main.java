package main;

import Dao.ArticuloDao;
import Dao.ComenterioDao;
import Dao.EtiquetaDao;
import Dao.UsuarioDao;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import logica.Articulo;
import logica.Usuario;
import spark.Request;
import spark.Spark;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;
import static spark.debug.DebugScreen.enableDebugScreen;

/**
 * Created by Leny96 on 15/6/2017.
 */
public class Main {
    private static final String COOKIE_NAME = "user_cookies" ;
    private static String SESSION_NAME= "username";


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
            checkCOOKIES(request);
            StringWriter writer = new StringWriter();
            List<Articulo> allArticulos = DBarticulos.getAllArticulos();
            try {
                Template formTemplate = configuration.getTemplate("templates/index.ftl");
                Map<String, Object> map = new HashMap<>();
                map.put("ListaArticulos", allArticulos);

                Usuario user = finUser(request.session().attribute(SESSION_NAME),DBusuarios);
                if(user==null){
                    map.put("login", "false");
                }else {
                    map.put("login", "true");
                    map.put("username",user.getUsername());
                }
                formTemplate.process(map, writer);
            } catch (Exception e) {
                System.out.println(e.toString());
                e.printStackTrace();
                Spark.halt(500);
            }
            return writer;
        });

        Spark.post("/login/", (request, response) -> {
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

                if (result.isEmpty()) {
                    System.out.println("NINGUN USUARIO CON ESA COBINACION DE PARAMETROS ");
                   Template formTemplate = configuration.getTemplate("templates/ventanaLogin.ftl");
                    Map<String, Object> map = new HashMap<>();
                    map.put("ListaArticulos", allArticulos);
                    map.put("login", "false");
                    map.put("cargando", "true");
                    map.put("username",username);
                    formTemplate.process(map, writer);

                } else {
                    System.out.println("LOGEADO CON EXITO");
                    response.cookie(COOKIE_NAME,username,3600);
                    request.session().attribute(SESSION_NAME,username);
                    response.redirect("/");
                }

            } catch (Exception e) {
                response.redirect("/");
            }
            return writer;
        });

        Spark.get("/signup/", (request, response) -> {
            StringWriter writer = new StringWriter();
            boolean adm = false;
            boolean aut = false;
            //List<Usuario> allUsuarios = DBusuarios.getAllUsuarios();
            try {
                String username = request.queryParams("username") != null ? request.queryParams("username") : "anonymous";
                String password = request.queryParams("password") != null ? request.queryParams("password") : "unknown";
                String nombre = request.queryParams("nombre") != null ? request.queryParams("nombre") : "unknown";
                String administrador = request.queryParams("administrador") != null ? request.queryParams("administrador") : "unknown";
                String autor = request.queryParams("autor") != null ? request.queryParams("autor") : "unknown";

                if (administrador.equals("on")) {
                    adm = true;
                }
                if (autor.equals("on")) {
                    aut = true;
                }

                DBusuarios.createUsuario(new Usuario(username, nombre, password, adm, aut));
                response.redirect("/");
                System.out.println(administrador + " " + autor);

            } catch (Exception e) {
                response.redirect("/");
            }
            return writer;
        });

        Spark.get("/logout", (request, response) -> {
             request.session().removeAttribute(SESSION_NAME);
            response.redirect("/");
            return null;
        });

        Spark.get("/CrearArticulo/:username",(request, response) -> {
            StringWriter writer = new StringWriter();
            String username = request.params("username");
            Template formTemplate = configuration.getTemplate("templates/crearArticulo.ftl");
            Map<String, Object> map = new HashMap<>();
            map.put("username",username);
            map.put("login", "true");
            formTemplate.process(map, writer);
            return writer;
        });

        Spark.post("/articulo",(request, response) -> {
            String titulo = request.queryParams("titulo");
            String cuerpo = request.queryParams("cuerpo");
            Usuario user = finUser(request.session().attribute(SESSION_NAME),DBusuarios);
           // String etiqueta = request.queryParams("etiqueta");
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");
            Articulo yuca = new Articulo(titulo, cuerpo, user.getUsername(), "89880");
            System.out.println(yuca.getAutor() +" "+ yuca.getFecha() +" "+ yuca.getTitulo());
            try {

                DBarticulos.createArticulo(yuca);
            }catch (Exception e){
                e.printStackTrace();
            }
            response.redirect("/");
            return null;
        });

    }
    private static void checkCOOKIES(Request req) {
        if (req.session().attribute(SESSION_NAME) == null) {
            Map<String, String> cookies = req.cookies();
            if (cookies.containsKey(COOKIE_NAME)) {
                System.out.println("que lo que con que lo que ");
                System.out.println("COOKIE ENCONTRADA" + cookies.get(COOKIE_NAME));
                req.session().attribute(SESSION_NAME, cookies.get(COOKIE_NAME));
            }
        }
    }


    private static Usuario finUser(String username, UsuarioDao DBusuarios){
        List<Usuario> allUsuarios = DBusuarios.getAllUsuarios();
        for(Usuario user: allUsuarios){
            if(user.getUsername().equalsIgnoreCase(username)){
                return user;
            }
        }
        return null;
    }
}
