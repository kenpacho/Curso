package Transacciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertaClientesPedidos {
    public static void main(String[] args) {

        Connection miConexion=null;

        try{
            miConexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/sqltutorial","charly","solyneko");
            miConexion.setAutoCommit(false);

            Statement miStatement= miConexion.createStatement();
            String instruccionSql_1="INSERT INTO CLIENTES (CÓDIGO_CLIENTE, EMPRESA, DIRECCIÓN) VALUES ('CT84', 'EJEMPLO','P BOTÁNICO')";
            miStatement.executeUpdate(instruccionSql_1);
            String instruccionSql_2="INSERT INTO PEDIDOS (NUMERO_PEDIDO, CODIGOCLIENTE,FECHAPEDIDO) VALUES ('82', 'CT8', '11/03/2000')";
            miStatement.executeUpdate(instruccionSql_2);

            miConexion.commit();


            System.out.println("Datos Insertados correctamente");

        }catch (Exception e){

            System.out.println("ERROR EN LA INSERCIÓN DE DATOS");
           try {


               miConexion.rollback();
           }catch (SQLException e1){
               e1.printStackTrace();
           }
           e.printStackTrace();
        }
    }
}
