package procAlmacenado;
import java.sql.*;

public class ConsultaClientes {
    public static void main(String[] args) {

        try{

            Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/sqltutorial", "charly", "solyneko");
            CallableStatement miSentencia=miConexion.prepareCall("{call MUESTRA_CLIENTES()}");
            ResultSet rs=miSentencia.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }

            rs.close();

        }catch (Exception e){

        }

    }
}
