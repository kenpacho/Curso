package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import modelo.*;
import vista.*;

public class controladorBotonEjecuta implements ActionListener {

    public controladorBotonEjecuta(MarcoAplicacion2 elmarco){

        this.elmarco=elmarco;

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String seleccionSeccion=(String)elmarco.secciones.getSelectedItem();
        String seleccionPais=(String)elmarco.paises.getSelectedItem();

         resultadoConsulta = obj.filtraBBDD(seleccionSeccion, seleccionPais);
         try {

             elmarco.resultado.setText("");

             while (resultadoConsulta.next()) {

                 elmarco.resultado.append(resultadoConsulta.getString(1));
                 elmarco.resultado.append(", ");
                 elmarco.resultado.append(resultadoConsulta.getString(2));
                 elmarco.resultado.append(", ");
                 elmarco.resultado.append(resultadoConsulta.getString(3));
                 elmarco.resultado.append(", ");
                 elmarco.resultado.append(resultadoConsulta.getString(4));
                 elmarco.resultado.append("\n");

             }
         }catch (Exception q){
             q.printStackTrace();

         }

    }

    private MarcoAplicacion2 elmarco;
    ejecutaConsultas obj = new ejecutaConsultas();
    private ResultSet resultadoConsulta;


}
