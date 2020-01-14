package modelo;
import java.sql.*;



public class cargaMenus {

    public cargaMenus() {

        miConexion = new conexion();
    }

    public void ejecutaConsultas(){

        Productos miProducto=null;

        Connection accesoBBDD = miConexion.dameConexion();

        try{
            Statement secciones=accesoBBDD.createStatement();

            Statement paises=accesoBBDD.createStatement();

            rs=secciones.executeQuery("SELECT DISTINCT SECCIÓN FROM PRODUCTOS");

            rs2=paises.executeQuery("SELECT DISTINCT PAISDEORIGEN FROM PRODUCTOS ");

            miProducto=new Productos();

            miProducto.setSeccion(rs.getString(1));

            miProducto.setPaisOrigen(rs2.getString(1));

            rs.close();

            rs2.close();

            accesoBBDD.close();


        }catch (Exception E){

            System.out.println("No conecta con BBDD ");

            E.printStackTrace();


        }

    }



    public conexion miConexion;
    public ResultSet rs;
    public ResultSet rs2;


}
