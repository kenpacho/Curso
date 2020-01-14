package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {

    Connection miConexion=null;


    public conexion(){

    }

    public Connection dameConexion() {

        try {

             miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqltutorial", "charly", "solyneko");


        }catch (Exception e) {

            System.out.println("Error conexión BBDD");
            e.printStackTrace();

        }

        return miConexion;
    }

}
