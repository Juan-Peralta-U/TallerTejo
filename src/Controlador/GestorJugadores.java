/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Equipo;
import Modelo.Jugador;
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
    }

    public void AgregarEquipo(int id, String nombre, String departamento) {
        equipos.add(new Equipo(id, nombre, departamento));
    }

    public void cargarEquipos(ArchivoPropiedades propiedades) {

        int i = 1; //itera por cada equipo

        while (propiedades.getData("Equipo" + i + ".nombre") != null) {

            //no aseguramos que el equipo exista
            if (propiedades.getData("Equipo" + i + ".departamento") == null) {
                continue;
            }

            if (propiedades.getData("Equipo" + i + ".numero") == null) {
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
    
    
    public void seleccionarEquipos(){
        Random random = new Random();
        int randomIndex = random.nextInt(this.equipos.size());
        this.equipoActual = equipos.get(randomIndex);
        equipos.remove(randomIndex);
        randomIndex =random.nextInt(this.equipos.size());
        this.equipoProximo = equipos.get(randomIndex);
        equipos.remove(randomIndex);
    }

    public void intercanbiarEquipos(){
        Equipo tempEquipo = this.equipoActual;
        this.equipoActual = this.equipoProximo;
        this.equipoProximo = tempEquipo;
    }
    
    public void manejarTurno(){
        if(this.turno < 3)
            this.turno ++;
        if(this.turno > 3){
            intercanbiarEquipos();
            this.turno = 0;
        }
    }

}
