package controlador;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import modelo.*;
import vista.*;

public class controladorCargaMenus extends WindowAdapter {

    public controladorCargaMenus(MarcoAplicacion2 elmarco){

        this.elmarco=elmarco;

    }


    public void WindowOpened(WindowEvent e){

        obj.ejecutaConsultas();

     try {

         while(obj.rs.next()){

             elmarco.secciones.addItem(obj.rs.getString(1));


         }

         while(obj.rs2.next()){
             elmarco.paises.addItem(obj.rs2.getString(1));

         }

     }catch (Exception e2){

         e2.printStackTrace();
     }


    }


    cargaMenus obj=new cargaMenus();
    private MarcoAplicacion2 elmarco;

}

