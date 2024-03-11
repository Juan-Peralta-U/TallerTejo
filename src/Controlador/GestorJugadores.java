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

}
