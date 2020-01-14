package modelo;
import java.sql.*;

public class ejecutaConsultas {

    public ejecutaConsultas(){

        miConexion=new conexion();
    }

    public ResultSet filtraBBDD(String seccion, String pais) {

        Connection conecta = miConexion.dameConexion();

        rs = null;

        try {

            if (!seccion.equals("Todos") && pais.equals("Todos")) {

                enviaConsultaSeccion = conecta.prepareStatement(consultaSeccion);

                enviaConsultaSeccion.setString(1,seccion);

                rs=enviaConsultaSeccion.executeQuery();


            } else if (seccion.equals("Todos") && !pais.equals("Todos")) {

                enviaConsultaSeccion=conecta.prepareStatement(consultaPais);

                enviaConsultaPais.setString(1,pais);

                rs=enviaConsultaPais.executeQuery();


            } else {

                enviaConsultaTodo=conecta.prepareStatement(consultaTodo);

                enviaConsultaTodo.setString(1,seccion);

                enviaConsultaTodo.setString(2,pais);

                rs=enviaConsultaTodo.executeQuery();


            }




        } catch (Exception e) {
            e.printStackTrace();

        }

        return rs;
    }

    private conexion miConexion;

    private ResultSet rs;

    private PreparedStatement enviaConsultaSeccion;

    private PreparedStatement enviaConsultaPais;

    private PreparedStatement enviaConsultaTodo;

    private final String consultaTodo="SELECT NOMBRE_ARTÍCULO, SECCIÓN, PRECIO, PAISDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=? AND PAISDEORIGEN=?";

    private final String consultaPais="SELECT NOMBRE_ARTÍCULO, SECCIÓN, PRECIO, PAISDEORIGEN FROM PRODUCTOS WHERE PAISDEORIGEN=?";

    private final String consultaSeccion= "SELECT NOMBRE_ARTÍCULO, SECCIÓN, PRECIO, PAISDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=?";




}
