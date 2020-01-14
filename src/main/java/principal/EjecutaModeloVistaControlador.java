package principal;

import vista.MarcoAplicacion2;

import javax.swing.*;

public class EjecutaModeloVistaControlador {
    public static void main(String[] args) {

        MarcoAplicacion2 mimarco= new MarcoAplicacion2();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mimarco.setVisible(true);
    }
}
