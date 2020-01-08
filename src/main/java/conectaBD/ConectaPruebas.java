package conectaBD;
import java.sql.*;



public class ConectaPruebas {
    public static void main(String[] args) {
        try {

            //1. CREAR CONEXIÓN

            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqltutorial", "charly", "solyneko");

            //2. CREAR OBJETO STATEMENT

            Statement miStatement = miConexion.createStatement();

            //3. EJECUTAR SQL

            ResultSet miResulset = miStatement.executeQuery("SELECT * FROM PRODUCTOS");

            //4. RECORRER EL RESULSET.

            while(miResulset.next()){
                System.out.println(miResulset.getString("NOMBRE_ARTÍCULO")+ " " + miResulset.getString("CODÍGO_ARTÍCULO") +" "+ miResulset.getString("PRECIO"));
            }





        } catch (Exception e) {
            System.out.println("No conecta con BBDD ");

            e.printStackTrace();
        }

    }
}
