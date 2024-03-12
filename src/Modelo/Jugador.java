/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import javax.swing.ImageIcon;

/**
 *
 * @author Familia Mora
 */
public class Jugador {
    private String nombre;
    private String cedula;
    private int edad;
    private ImageIcon foto;

    public Jugador(String nombre, String cedula, int edad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
    }
    
    public Jugador(String nombre, String cedula, int edad, ImageIcon foto) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public int getEdad() {
        return edad;
    }

    public ImageIcon getFoto() {
        return foto;
    }
    
}
