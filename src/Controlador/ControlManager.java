/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ArchivoAleatorio;
import Modelo.ArchivoPropiedades;
import Modelo.Equipo;
import Vista.FileChooser;
import Vista.MainWindow;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

/**
 *
 * @author Juan
 */
public class ControlManager implements ActionListener {

    private FileChooser fileChooser1;
    private FileChooser fileChooser2;
    private ArchivoPropiedades dataEquipos;
    private GameManager gestorPrincipal;
    private GestorJugadores gestorJugadores;
    private ArchivoAleatorio archivoSalida;
    private MainWindow ventanaPrincipal;

    public ControlManager() {
        ventanaPrincipal = new MainWindow(this);
        
        
        fileChooser1 = new FileChooser("Selecciona archivo propiedades");
        fileChooser2 = new FileChooser("Seleccione el archivo aleatorio");
        dataEquipos = new ArchivoPropiedades(fileChooser1.getFile());
        gestorJugadores = new GestorJugadores();
        gestorJugadores.cargarEquipos(dataEquipos);
        gestorPrincipal = new GameManager(this.gestorJugadores, this.ventanaPrincipal.teamPanelA, this.ventanaPrincipal.teamPanelB);
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
                ventanaPrincipal.labPuntos.setText(this.gestorPrincipal.getPuntos());
                
                if(this.gestorPrincipal.comprobarGanador()){
                   ventanaPrincipal.btnJugar.setEnabled(true);
                   ventanaPrincipal.btnLanzar.setEnabled(false);
                   
                   if(gestorPrincipal.getPuntosA() > gestorPrincipal.getPuntosB()){
                       ventanaPrincipal.mensajeEmergente(gestorJugadores.getEquipoProximo().getNombre() + " ha ganado");
                   } else {
                       ventanaPrincipal.mensajeEmergente(gestorJugadores.getEquipoActual().getNombre() + " ha ganado");
                   }
                   
                }
                
                this.gestorPrincipal.manejarTurno();
                ventanaPrincipal.labTurno.setText("Turno:" + this.gestorPrincipal.getTurnos());
            }
            case "Volver a jugar" -> {
                configurarEquipos();
                
                if(gestorJugadores.getEquipoActual().getJugadores().size()<4){
                    ventanaPrincipal.mensajeEmergente("No hay suficientes equipos o jugadores para una nueva partida");
                    return;
                }
                
                gestorPrincipal.nuevaPartida();
               
                ventanaPrincipal.btnJugar.setEnabled(false);
                ventanaPrincipal.btnLanzar.setEnabled(true);           
                
                ventanaPrincipal.labPuntos.setText(this.gestorPrincipal.getPuntos());
                ventanaPrincipal.labTurno.setText("Turno:" + this.gestorPrincipal.getTurnos());
            }
            case "Salir" -> {
                archivoSalida = new ArchivoAleatorio(fileChooser2.getFile());
                //Guardar
                //Leer y dar resultados en consola
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
