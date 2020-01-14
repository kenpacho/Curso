package aplicacionFinal;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class aplicacionUniversal {
    public static void main(String[] args) throws IOException, SQLException {

        MarcoBBDD miMarco= new MarcoBBDD();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);

    }
}

class MarcoBBDD extends JFrame{
    public MarcoBBDD() throws IOException, SQLException {
        setBounds(300, 300, 700, 700);
        LaminaBBDD miLamina = new LaminaBBDD();
        add(miLamina);

    }
}

class LaminaBBDD extends JPanel{
    public LaminaBBDD() throws IOException, SQLException {

        setLayout(new BorderLayout());
        comboTablas=new JComboBox<>();
        areaInformacion=new JTextArea();
        add(areaInformacion, BorderLayout.CENTER);

        conectarBBDD();
        obtenerTablas();

        comboTablas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreTabla=(String)comboTablas.getSelectedItem();
            }
        });

        add(comboTablas, BorderLayout.NORTH);


    }


    public void conectarBBDD() throws IOException, SQLException {
        miConexion=null;
        String[] datos = new String[3];


        try {
            entrada = new FileReader("C:/Users/Carlos/Desktop/datosConfig.txt");

        }catch (IOException e) {

            JFileChooser chooser = new JFileChooser();

            FileNameExtensionFilter filter= new FileNameExtensionFilter("Archivos de texto", "txt");

            chooser.setFileFilter(filter);

            int returnVal = chooser.showOpenDialog(this);

            if(returnVal == JFileChooser.APPROVE_OPTION){

                entrada = new FileReader(chooser.getSelectedFile().getAbsolutePath());
            }

        }
            BufferedReader miBuffer = new BufferedReader(entrada);

            for(int i=0; i<=2;i++){
                datos[i]=miBuffer.readLine();
            }


            miConexion= DriverManager.getConnection(datos[0], datos[1], datos[2]);

            entrada.close();


        }


    public void obtenerTablas(){

       ResultSet miResulset;

        try{

            DatabaseMetaData datosBBDD =miConexion.getMetaData();

            miResulset= datosBBDD.getTables(null, null, null, null);



            while(miResulset.next()){

                comboTablas.addItem(miResulset.getString("TABLE_NAME"));

            }


        }catch (Exception e){

            e.printStackTrace();
        }
    }

    public void mostrarInfoTabla(String tabla){

        ArrayList<String> campos = new ArrayList<String>();
        String consulta= "SELECT * FROM " + tabla;

        try{

            areaInformacion.setText("");

            Statement miStatement= miConexion.createStatement();
            ResultSet miRs= miStatement.executeQuery(consulta);

            ResultSetMetaData rsBBDD = miRs.getMetaData();

            for(int i=1; i<=rsBBDD.getColumnCount(); i++){

                campos.add(rsBBDD.getColumnLabel(i));

            }
            while(miRs.next()){

                for(String nombreCampo:campos){

                    areaInformacion.append(miRs.getString(nombreCampo) + " " );

                }

                areaInformacion.append("\n");

            }



        }catch (Exception e){
            e.printStackTrace();
        }


    }




    private JComboBox<String> comboTablas;
    private Connection miConexion;
    private JTextArea areaInformacion;
    private FileReader entrada;


}



