package logica;

/**
 * Created by Leny96 on 15/6/2017.
 */
public class DataBaseServices {
    private static DataBaseServices instancia;
    private String URL = "jdbc:h2:tcp://localhost/~/dataBase"; //Modo Server...

    /*private DataBaseServices() {
        registrarDriver();
    }*/
    public  static DataBaseServices getInstancia(){
        if(instancia==null){
            instancia = new DataBaseServices();
        }
        return instancia;
    }

}
