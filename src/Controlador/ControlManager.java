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
        ventanaPrincipal = new MainWindow();
        fileChooser = new FileChooser();
        cargarArchivo = new ArchivoPropiedades(fileChooser.getFile());
        gestorPrincipal = new GameManager();
        gestorJugadores = new GestorJugadores();
        

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
    }
    
    
}    

    
