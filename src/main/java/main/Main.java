package main;

import logica.DataBaseServices;
import logica.H2Services;

import java.sql.SQLException;

import static spark.Spark.staticFiles;
import static spark.debug.DebugScreen.enableDebugScreen;

/**
 * Created by Leny96 on 15/6/2017.
 */
public class Main {
    public static void main(String[] args) {
        staticFiles.location("/publico");

        enableDebugScreen();
        try {
            H2Services.startDb();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataBaseServices.getInstancia().textConexion();
        H2Services.crearTablas();

        new Templates().TempFreeMarker();


        try {
            H2Services.stopDb();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
