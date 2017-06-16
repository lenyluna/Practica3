package main;

import static spark.Spark.staticFiles;
import static spark.debug.DebugScreen.enableDebugScreen;

/**
 * Created by Leny96 on 15/6/2017.
 */
public class Main {
    public static void main(String[] args) {
        staticFiles.location("/publico");

        enableDebugScreen();

        new Templates().TempFreeMarker();
    }
}
