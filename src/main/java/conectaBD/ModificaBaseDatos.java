package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ModificaBaseDatos {

    public static void main(String[] args) {

        try {

            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqltutorial", "charly", "solyneko");

            Statement miStatement = miConexion.createStatement();

            String instruccionSql= "DELETE FROM PRODUCTOS WHERE CODÍGO_ARTÍCULO='AR77'";

            miStatement.executeUpdate(instruccionSql);

            System.out.println("Datos eliminados correctamente");


        } catch (Exception e) {
            System.out.println("No conecta con BBDD ");

            e.printStackTrace();
        }

    }
}

