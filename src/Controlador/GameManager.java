/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.util.Random;
/**
 *
 * @author Juan
 */
public class GameManager {
    
    private SistemaSonido sistemaSonido;
    private int puntosActual;
    private int puntosProximo;
    private GestorJugadores gestorJugadores;
    
    
    public GameManager(GestorJugadores gestorJugadores){
        sistemaSonido = new SistemaSonido();
    }
    
    
    public void lanzarTejo(){
        Random random = new Random();
        
        switch(random.nextInt(5)){
            case 0->{
                //mano
                this.puntosActual++;
            }
            case 1->{
                //mecha
                this.puntosActual+=3;
            }
            case 2->{
                //bocin
                this.puntosActual+=6;
            }
            case 3->{
                //moñona
                this.puntosActual+=9;
               
            }
            case 4->{
                //otro
                //mucho malo
            }
        }
        
    }
    
    
    public void comprobarGanador(){
        if(this.puntosActual >26){
            return;
        }
    }
  
    
}
