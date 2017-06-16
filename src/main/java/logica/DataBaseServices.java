package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Leny96 on 15/6/2017.
 */
public class DataBaseServices {
    private static DataBaseServices instancia;
    private String URL = "jdbc:h2:tcp://localhost/~/dataBase"; //Modo Server...

    private DataBaseServices() {
        registrarDriver();
    }
    public  static DataBaseServices getInstancia(){
        if(instancia==null){
            instancia = new DataBaseServices();
        }
        return instancia;
    }

    private void registrarDriver(){
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE,null,e);
        }
    }

    public Connection getConexion(){
        Connection con= null;
        try {
            con = DriverManager.getConnection(URL,"sa","");
        } catch (SQLException e) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE,null,e);
        }
        return con;
    }
    public void textConexion(){
        try {
            getConexion().close();
            System.out.println("Conexión realizado con exito..!");
        } catch (SQLException e) {
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE,null,e);
        }

    }
}
