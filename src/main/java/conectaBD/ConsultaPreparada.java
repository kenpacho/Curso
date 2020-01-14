package conectaBD;

import jdk.swing.interop.SwingInterOpUtils;

import java.sql.*;

public class ConsultaPreparada {

    public static void main(String[] args) {

        try {

               //1. CREAR CONEXIÓN.

            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqltutorial", "charly", "solyneko");

                //2. PREPARAR CONSULTA.

            PreparedStatement miSentencia = miConexion.prepareStatement("SELECT NOMBRE_ARTÍCULO, SECCIÓN, PAISDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=? AND PAISDEORIGEN=?");

                //3. ESTABLECER PARÁMETROS DE CONSULTA.

            miSentencia.setString(1, "DEPORTIVOS");
            miSentencia.setString(2,"USA");


                //4. EJECUTAR Y RECORRER CONSULTA.

            ResultSet rs = miSentencia.executeQuery();

            while(rs.next()){
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }

            rs.close();

                //5. REUTILIZACIÓN DE CONSULTA.

            System.out.println("EJECUCIÓN SEGUNDA CONSULTA");
            System.out.println(" ");


            miSentencia.setString(1, "CERÁMICA");
            miSentencia.setString(2,"CHINA");

            rs = miSentencia.executeQuery();



            while(rs.next()){
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }

            rs.close();


        } catch (Exception e) {
        System.out.println("No conecta con BBDD ");

        e.printStackTrace();
    }



    }
}
