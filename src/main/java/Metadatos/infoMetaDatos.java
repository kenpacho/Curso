package Metadatos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class infoMetaDatos {
    public static void main(String[] args) {

        //mostrarInfoBBDD();

        mostrarInfoTablas();

    }

    public static void mostrarInfoBBDD(){

        Connection miConexion =null;
        try {

            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqltutorial", "charly", "solyneko");

            //OBTENCION DE METADATOS.

            DatabaseMetaData datosBBDD= miConexion.getMetaData();

            //MOSTRAR INFO BBDD.

            System.out.println("Gestor de BBDD " + datosBBDD.getDatabaseProductName());
            System.out.println("Versión del gestor " + datosBBDD.getDatabaseProductVersion());
            System.out.println("Driver Utilizado " + datosBBDD.getDriverName());
            System.out.println("Versión del driver " + datosBBDD.getDriverVersion());



        }catch(Exception e){

            e.printStackTrace();

        }finally {
           try{
               miConexion.close();
           }catch (Exception e1){
               e1.printStackTrace();
           }
        }

    }

    public static void mostrarInfoTablas(){

        Connection miConexion =null;
        ResultSet miResultset=null;

        try {

            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqltutorial", "charly", "solyneko");

            //OBTENCION DE METADATOS.

            DatabaseMetaData datosBBDD = miConexion.getMetaData();

            //LISTA DE TABLAS.

            System.out.println("Lista de tablas ");

            miResultset=datosBBDD.getTables(null, null, null, null);

            while(miResultset.next()){
                System.out.println(miResultset.getString("TABLE_NAME"));
            }

            //LISTA DE COLUMNAS DE PRODUCTOS.

            System.out.println(" ");

            System.out.println("Campos de productos");

            miResultset=datosBBDD.getColumns(null, null, "PRODUCTOS", null);
            while (miResultset.next()){
                System.out.println(miResultset.getString("COLUMN_NAME"));
            }





        }catch (Exception e){

            e.printStackTrace();

        }finally {
           try{
               miConexion.close();
           }catch (Exception e1){

               e1.printStackTrace();

           }
        }


    }


}
