/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ArchivoPropiedades;
import Modelo.Equipo;
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
    private FileChooser fileChooser;
    private ArchivoPropiedades dataEquipos;
    private GameManager gestorPrincipal;
    private GestorJugadores gestorJugadores;

    public ControlManager() {
        ventanaPrincipal = new MainWindow(this);
        fileChooser = new FileChooser();
        dataEquipos = new ArchivoPropiedades(fileChooser.getFile());
        gestorJugadores = new GestorJugadores();
        gestorJugadores.cargarEquipos(dataEquipos);
        gestorPrincipal = new GameManager(gestorJugadores, this.ventanaPrincipal.teamPanelA, this.ventanaPrincipal.teamPanelB);
        gestorPrincipal.nuevaPartida();
        
        ventanaPrincipal.btnLanzar.addActionListener(this);
        ventanaPrincipal.btnJugar.addActionListener(this);
        ventanaPrincipal.btnSalir.addActionListener(this);
        iniciarVista();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "Lanzar el tejo" -> {
                ventanaPrincipal.mensajeEmergente("" + this.gestorPrincipal.lanzarTejo());
                this.gestorPrincipal.asignarPuntaje();
                if(this.gestorPrincipal.comprobarGanador()){
                   ventanaPrincipal.btnJugar.setEnabled(true);
                   ventanaPrincipal.btnLanzar.setEnabled(false);
                   ventanaPrincipal.mensajeEmergente(this.gestorJugadores.getEquipoActual().getNombre()+ " ha Ganado");
                }
                this.gestorPrincipal.manejarTurno();
                ventanaPrincipal.labPuntos.setText(this.gestorPrincipal.getPuntos());
                ventanaPrincipal.labTurno.setText("Turno:" + this.gestorPrincipal.getTurnos());
            }
            case "Volver a jugar" -> {
                configurarEquipos();
                ventanaPrincipal.btnJugar.setEnabled(false);
                ventanaPrincipal.btnLanzar.setEnabled(true);                
                this.gestorPrincipal.nuevaPartida();
                ventanaPrincipal.labPuntos.setText(this.gestorPrincipal.getPuntos());
                ventanaPrincipal.labTurno.setText("Turno:" + this.gestorPrincipal.getTurnos());
            }
            case "Salir" -> {
                //Gurdar
                //Salir
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
        ventanaPrincipal.btnJugar.setEnabled(false);
        
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
