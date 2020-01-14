package Transacciones;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class transaccionProductos {
    public static void main(String[] args) {
        Connection miConexion=null;

        try {
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqltutorial", "charly", "solyneko");
            miConexion.setAutoCommit(false);

            Statement miStatement = miConexion.createStatement();

            String instruccionSql_1 = "DELETE * FROM PRODUCTOS WHERE PAISDEORIGEN ='ITALIA'";

            String instruccionSql_2 = "DELETE * FROM PRODUCTOS WHERE PRECIO>300";

            String instruccionSql_3= "UPDATE PRODUCTOS SET PRECIO = PRECIO * 1.15";

            boolean ejecutar= ejecutarTransaccion();

            if(ejecutar = true) {

                miStatement.executeUpdate(instruccionSql_1);
                miStatement.executeUpdate(instruccionSql_2);
                miStatement.executeUpdate(instruccionSql_3);

                miConexion.commit();

                System.out.println("Transaccion ejecutada correctamente");

            }else{

                System.out.println("No se realizó cambio en la BBDD");
            }




        }catch (Exception e){
            try {

                miConexion.rollback();

                System.out.println("Algo salió mal y no se realizó cambio alguno en BBDD");

            }catch (Exception e2){

                e.printStackTrace();

            }
        }
    }

    public static boolean ejecutarTransaccion(){

        String ejecucion = JOptionPane.showInputDialog("¿Ejecutamos transacción? ");

        if(ejecucion.equalsIgnoreCase("Si")){
            return true;
        }else{
            return false;
        }


    }

}
