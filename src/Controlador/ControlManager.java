/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.FileChooser;
import Vista.MainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Juan
 */
public class ControlManager implements ActionListener{

    private MainWindow ventanaPrincipal; 
    private FileChooser fileChooser;
    private ArchivoPropiedades cargarArchivo;
    private GameManager gestorPrincipal;
    private GestorJugadores gestorJugadores;

    
    public ControlManager() {
        fileChooser = new FileChooser();
        cargarArchivo = new ArchivoPropiedades(fileChooser.getFile());
        gestorJugadores = new GestorJugadores();
        gestorJugadores.cargarEquipos(cargarArchivo);
        gestorPrincipal = new GameManager(gestorJugadores);
        ventanaPrincipal = new MainWindow();

        
        ventanaPrincipal.btnLanzar.addActionListener(this);
        ventanaPrincipal.btnJugar.addActionListener(this);
        ventanaPrincipal.btnSalir.addActionListener(this);
  
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch(e.getActionCommand()){
            case "Lanzar el tejo"->{
                this.gestorPrincipal.lanzarTejo();
            }
            case "Volver a jugar"->{
                this.gestorJugadores.seleccionarEquipos();
                this.gestorJugadores.cargarVistaEquipo(this.ventanaPrincipal.teamPanelA);
                this.gestorJugadores.intercanbiarEquipos();
                this.gestorJugadores.cargarVistaEquipo(this.ventanaPrincipal.teamPanelB);
                this.gestorJugadores.intercanbiarEquipos();
            }
            case "Salir"->{
                
            }
        }
    }
    
    
}    

    
