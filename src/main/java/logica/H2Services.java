package logica;

import org.h2.tools.Server;

import java.sql.SQLException;

/**
 * Created by Leny96 on 15/6/2017.
 */
public class H2Services {
    /**
     * @throws SQLException
     */
    public static void startDb() throws SQLException {
        Server.createTcpServer("-tcpPort","9092","-tcpAllowOthers").start();
    }

    /**
     * @throws SQLException
     */
    public static void stopDb() throws SQLException {
        Server.shutdownTcpServer("tcp://localhost:9092","",true,true);
    }

    public static void crearTablas(){
        String sqlUser = "CREATE TABLE IF NOT EXISTS USER\n" +
                "(USERNAME VARCHAR(30) PRIMARY KEY NOT NULL,\n"+
                " NOMBRE VARCHAR(100) NOT NULL,\n" +
                " PASSWORD VARCHAR(100) NOT NULL,\n" +
                " ADMINISTRADOR BOOLEAN NOT NULL,\n" +
                "AUTOR BOOLEAN NOT NULL"+");";

        String sqlArticle = "CREATE TABLE IF NOT EXISTS ARTICLE" +
                "(ID INTEGER PRIMARY KEY  AUTO_INCREMENT NOT NULL,"+
                "TITULO VARCHAR(100) NOT NULL,"+
                "CUERPO VARCHAR(2500) NOT NULL,"+
                "AUTOR VARCHAR(30) NOT NULL,FOREIGN KEY (AUTOR) REFERENCES USER(USERNAME),"+
                "FECHA VARCHAR(30) NOT NULL"+");";

        String sqlComment = "CREATE TABLE IF NOT EXISTS COMMENT" +
                "(ID INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL," +
                "COMENTARIO VARCHAR(1500) NOT NULL," +
                "AUTOR VARCHAR(30) NOT NULL, FOREIGN KEY (AUTOR) REFERENCES USERNAME(USERNAME)," +
                "ARTICULO INTEGER NOT NULL,FOREIGN KEY (ARTICULO) REFERENCES ARTICULO(ID) "+");";
        String sqlTag = "CREATE TABLE IF NOT EXISTS TAG"+
                "(ID INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,"+
                "TEXTO VARCHAR(100) NOT NULL"+");";

        String sqlTagArticulo = "CREATE TABLE IF NOT EXISTS TAG_ARTICLE(" +
                "ID INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL," +
                "ID_ARTICLE INTEGER NOT NULL, FOREIGN KEY (ID_ARTICLE) REFERENCES ARTICLE(ID)," +
                "ID_TAG INTEGER NOT NULL, FOREIGN KEY (ID_TAG) REFERENCES TAG(ID));";
        String sqlAdminUser= "INSERT INTO USER(USERNAME, NOMBRE, PASSWORD,ADMINISTRADOR, AUTOR)"
                + "VALUES('lenyluna','administrador','admin',TRUE,TRUE);";


    }
}
