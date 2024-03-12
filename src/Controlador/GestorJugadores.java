/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ArchivoPropiedades;
import Modelo.Equipo;
import Modelo.Jugador;
import Vista.TeamPanel;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Juan
 */
public class GestorJugadores {

    private Equipo equipoActual;
    private Equipo equipoProximo;
    private ArrayList<Equipo> equipos;
    private ArrayList<Jugador> jugadoresNoElectos;
    private int turno;

    public GestorJugadores() {
        this.equipos = new ArrayList<>();
        this.jugadoresNoElectos = new ArrayList<>();
        this.equipoActual = null;
        this.equipoProximo = null;
        
        crearJugadores();
    }

    public void AgregarEquipo(int id, String nombre, String departamento) {
        equipos.add(new Equipo(id, nombre, departamento));
    }

    public void cargarEquipos(ArchivoPropiedades propiedades) {

        int i = 1; //itera por cada equipo
        
        
        while (propiedades.getData("Equipo" + i + ".nombre") != null) {
            
            //no aseguramos que el equipo exista
            if (propiedades.getData("Equipo" + i + ".departamento") == null) {
                i++;
                continue;
            }

            if (propiedades.getData("Equipo" + i + ".numero") == null) {
                i++;
                continue;
            }

            this.AgregarEquipo(
                    Integer.valueOf(propiedades.getData("Equipo" + i + ".numero")),
                    propiedades.getData("Equipo" + i + ".nombre"),
                    propiedades.getData("Equipo" + i + ".departamento")
            );
            
            i++;//suma al iterador para buscar el proximo equipo
        }
    }

    public void seleccionarEquipos() {

        if(this.equipos.size() < 2)
            return;
        
        Random random = new Random();
        
        int randomIndex = random.nextInt(this.equipos.size());
        this.equipoActual = equipos.get(randomIndex);
        this.seleccionarJugadores(this.equipoActual);
        equipos.remove(randomIndex);
        
        randomIndex = random.nextInt(this.equipos.size());     
        this.equipoProximo = equipos.get(randomIndex);
        this.seleccionarJugadores(this.equipoProximo);
        equipos.remove(randomIndex);
    }

    
    public void seleccionarJugadores(Equipo equipo){
        if(this.jugadoresNoElectos.size() < 4)
            return;
        Random random = new Random();
        for(int i=0; i<4; i++){
            int randomIndex = random.nextInt(this.jugadoresNoElectos.size());
            equipo.add(this.jugadoresNoElectos.get(randomIndex));
            this.jugadoresNoElectos.remove(randomIndex);
        }
    }
    
    public void intercambiarEquipos() {
        Equipo tempEquipo = this.equipoActual;
        this.equipoActual = this.equipoProximo;
        this.equipoProximo = tempEquipo;
    }

    public void manejarTurno() {
        if (this.turno < 3) {
            this.turno++;
        }
        if (this.turno > 3) {
            intercambiarEquipos();
            this.turno = 0;
        }
    }

    public void cargarVistaEquipo(TeamPanel panelEquipo){
        if( equipoActual == null || equipoProximo == null)
            return;
        
        if( equipoActual.getJugadores().isEmpty() || equipoProximo.getJugadores().isEmpty() )
            return;
        
        panelEquipo.labEquipo.setText(this.equipoActual.getNombre());
        panelEquipo.labJugador1.setText(this.equipoActual.getJugador(0));
        panelEquipo.labJugador2.setText(this.equipoActual.getJugador(1));
        panelEquipo.labJugador3.setText(this.equipoActual.getJugador(2));
        panelEquipo.labJugador4.setText(this.equipoActual.getJugador(3));
    }
    
    public void crearJugadores(){
        this.jugadoresNoElectos.add(new Jugador("Dina", "123456789", 25));
        this.jugadoresNoElectos.add(new Jugador("Aquiles", "987654321", 30));
        this.jugadoresNoElectos.add(new Jugador("Dbora", "456789123", 28));
        this.jugadoresNoElectos.add(new Jugador("Zoyla", "789123456", 27));
        this.jugadoresNoElectos.add(new Jugador("Susana", "321654987", 23));
        this.jugadoresNoElectos.add(new Jugador("Elvis", "654321789", 29));
        this.jugadoresNoElectos.add(new Jugador("Elsa", "147258369", 26));
        this.jugadoresNoElectos.add(new Jugador("Esteban", "369147258", 24));
        this.jugadoresNoElectos.add(new Jugador("Yola", "258369147", 31));
        this.jugadoresNoElectos.add(new Jugador("Elba", "852369741", 22));
        this.jugadoresNoElectos.add(new Jugador("Mario", "369852147", 27));
        this.jugadoresNoElectos.add(new Jugador("Benito", "741258963", 26));
        this.jugadoresNoElectos.add(new Jugador("Luz", "159263478", 24));
        this.jugadoresNoElectos.add(new Jugador("Armando", "852147369", 28));
        this.jugadoresNoElectos.add(new Jugador("Alan", "369741852", 25));
        this.jugadoresNoElectos.add(new Jugador("Andres", "4147814615", 50));
    }

}
