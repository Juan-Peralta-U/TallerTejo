/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Familia Mora
 */
public class Equipo {
    private int id;
    private String nombre;
    private String departamento;
    private ArrayList<Jugador> jugadores; 

    public Equipo(int id, String nombre, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.jugadores = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDepartamento() {
        return departamento;
    }
    
    public String getJugador(int index){
        return this.jugadores.get(index).getNombre();
    }
    
    public void add(Jugador nuevoJugador){
        this.jugadores.add(nuevoJugador);
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
            
}

