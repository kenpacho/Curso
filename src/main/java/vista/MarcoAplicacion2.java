package vista;

import controlador.controladorBotonEjecuta;
import controlador.controladorCargaMenus;

import javax.swing.*;
import java.awt.*;

public class MarcoAplicacion2 extends JFrame {




    public MarcoAplicacion2() {

        setTitle("Consulta BBDD");

        setBounds(500, 300, 400, 400);

        setLayout(new BorderLayout());

        JPanel menus = new JPanel();

        menus.setLayout(new FlowLayout());

        secciones = new JComboBox<>();

        secciones.setEditable(false);

        secciones.addItem("Todos");

        paises = new JComboBox<>();

        paises.setEditable(false);

        paises.addItem("Todos");

        resultado = new TextArea(4, 50);

        resultado.setEditable(false);

        add(resultado);

        menus.add(secciones);

        menus.add(paises);

        add(menus, BorderLayout.NORTH);

        add(resultado, BorderLayout.CENTER);

        JButton botonConsulta = new JButton("Consulta");

        add(botonConsulta, BorderLayout.SOUTH);

        botonConsulta.addActionListener(new controladorBotonEjecuta(this));

        addWindowListener(new controladorCargaMenus(this));

    }


    public JComboBox<String> paises;
    public TextArea resultado;
    public JComboBox<String> secciones;
}