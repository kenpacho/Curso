package aplicacionFinal;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class tirar {

    public static void main(String[] args) {

        Marco miMarco = new Marco();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


               JFileChooser chooser = new JFileChooser();

        FileNameExtensionFilter filter= new FileNameExtensionFilter("Archivos de texto", "txt");

        chooser.setFileFilter(filter);

        int returnVal = chooser.showOpenDialog(miMarco);

        if(returnVal == JFileChooser.APPROVE_OPTION){
            System.out.println("Has elegido abrir este archivo: " + chooser.getSelectedFile().getAbsolutePath());
        }



    }


    static class Marco extends JFrame{
        public Marco(){

            setBounds(300, 300, 300,300);
            setVisible(true);

        }
    }
}
