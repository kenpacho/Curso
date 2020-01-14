package procAlmacenado;

import javax.swing.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class ActualizaProductos {
    public static void main(String[] args) {

        int nPrecio = Integer.parseInt(JOptionPane.showInputDialog("Introduce precio"));
        String nArticulo = JOptionPane.showInputDialog("Introduce nombre artículo");


        try {

            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqltutorial", "charly", "solyneko");
            CallableStatement miSentencia = miConexion.prepareCall("{call ACTUALIZA_PROD(?, ?)}");

            miSentencia.setInt(1, nPrecio);
            miSentencia.setString(2,nArticulo);
            miSentencia.execute();

            System.out.println("Atualización ok");



        }catch (Exception e){
            e.printStackTrace();
        }

    }
}


