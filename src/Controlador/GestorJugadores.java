/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Equipo;
import Modelo.Jugador;
import java.util.ArrayList;
/**
 *
 * @author Juan
 */
public class GestorJugadores {
    
    private ArrayList<Equipo> equipos;
    private ArrayList<Jugador> jugadoresNoElectos;

    public GestorJugadores(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }
    
}
