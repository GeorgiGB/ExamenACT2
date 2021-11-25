package EXAMEN_AC_T2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConectarBBDD {
    private String host;
    private String port;
    private String user;
    private String passwd;
    private String ddbb;

    private Connection laConexio;

    //Constructor predeterminado
    public ConectarBBDD(){
        host="localhost";
        port="49153";
        //port="3308";
        user="examenAD02";
        passwd="examenAD02";//no se ha especificado ninguna contraseña pongo el nombre
        ddbb="ships";

        laConexio = null;
    }

    //La conexion con el servidor mysql

    private void connectar(){
        try{
            //Inicializamos el Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://"+host+":"+port+"/"+ddbb;

            //Creamos el objeto properties por si vamos a introducir otros datos que no sean los predeterminados

            Properties p = new Properties();

            //Nombre y Contraseña
            p.put("user",user);
            p.put("password",passwd);

            //Recogemos la informacion con "laConexio"
            this.laConexio = DriverManager.getConnection(url, p);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConectarBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //getter

    public Connection getLaConexio() {
        //Control de error
        if (laConexio==null)
            this.connectar();

        return laConexio;
    }

    public void closeConexion(){
        try {
            laConexio.close();
            laConexio=null;
        } catch (SQLException ex) {
            Logger.getLogger(ConectarBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
