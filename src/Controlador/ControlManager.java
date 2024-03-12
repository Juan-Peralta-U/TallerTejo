/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ArchivoAleatorio;
import Modelo.ArchivoPropiedades;
import Vista.FileChooser;
import Vista.MainWindow;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Juan
 */
public class ControlManager implements ActionListener {

    private MainWindow ventanaPrincipal;
    private FileChooser fileChooser1;
    private FileChooser fileChooser2;
    private ArchivoPropiedades dataEquipos;
    private GameManager gestorPrincipal;
    private GestorJugadores gestorJugadores;
    private ArchivoAleatorio archivoSalida;

    public ControlManager() {
        ventanaPrincipal = new MainWindow(this);
        fileChooser1 = new FileChooser("Selecciona archivo propiedades");
        fileChooser2 = new FileChooser("Seleccione el archivo aleatorio");
        dataEquipos = new ArchivoPropiedades(fileChooser1.getFile());
        archivoSalida = new ArchivoAleatorio(fileChooser2.getFile());
        gestorJugadores = new GestorJugadores();
        gestorJugadores.cargarEquipos(dataEquipos);
        gestorPrincipal = new GameManager(gestorJugadores);

        ventanaPrincipal.btnLanzar.addActionListener(this);
        ventanaPrincipal.btnJugar.addActionListener(this);
        ventanaPrincipal.btnSalir.addActionListener(this);
        iniciarVista();

        archivoSalida.escribir(0, 5, "jajaj", "Juan", "Cesar", "Care", "Monda", true);
        System.out.println(archivoSalida.lecturaRegistros());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "Lanzar el tejo" -> {
                ventanaPrincipal.mensajeEmergente("" + this.gestorPrincipal.lanzarTejo());
            }
            case "Volver a jugar" -> {
                configurarEquipos();
            }
            case "Salir" -> {

            }
        }
    }

    private void iniciarVista() {
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.setTitle("Tejo");
        ventanaPrincipal.setLocationRelativeTo(null);

        ventanaPrincipal.getContentPane().setBackground(new Color(235, 239, 255));
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.teamPanelB.labEquipo.setBackground(Color.red);

        configurarEquipos();
    }

    public void configurarEquipos() {
        this.gestorJugadores.seleccionarEquipos();
        this.gestorJugadores.cargarVistaEquipo(this.ventanaPrincipal.teamPanelA);
        this.gestorJugadores.intercambiarEquipos();
        this.gestorJugadores.cargarVistaEquipo(this.ventanaPrincipal.teamPanelB);
        this.gestorJugadores.intercambiarEquipos();
    }

}
