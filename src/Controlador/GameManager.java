/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.TeamPanel;
import java.util.Random;

/**
 *
 * @author Juan
 */
public class GameManager {

    private SistemaSonido sistemaSonido;
    private int puntosA = 0;
    private int puntosB = 0;
    private int puntosActual = 0;
    private TeamPanel teamPanelActual;
    private TeamPanel teamPanelProximo;
    private GestorJugadores gestorJugadores;
    private int turnoJugador = 0;
    private int totalTurnosEquipo = 0;

    public GameManager(GestorJugadores gestorJugadores, TeamPanel teamPanelProximo, TeamPanel teamPanelActual) {
        this.sistemaSonido = new SistemaSonido();
        this.gestorJugadores = gestorJugadores;
        this.teamPanelActual = teamPanelActual;
        this.teamPanelProximo = teamPanelProximo;
    }

    public boolean nuevaPartida() {
        
        if ((this.totalTurnosEquipo % 2) != 0) {
            this.pasarTurno();
        }

        this.puntosA = 0;
        this.puntosB = 0;
        this.puntosActual = 0;
        this.totalTurnosEquipo = 0;
        this.turnoJugador = 0;
        this.pasarTurno();
        this.teamPanelActual.resaltarJugador(this.turnoJugador+1);
        
        return true;
    }

    public String lanzarTejo() {
        Random random = new Random();

        this.puntosActual = 0;
        int resultadoRandom = random.nextInt(5);
        switch (resultadoRandom) {
            case 0 -> {
                this.puntosActual++;
                return "Mano!!";
            }
            case 1 -> {
                this.puntosActual += 3;
                return "Mecha!!";
            }
            case 2 -> {
                this.puntosActual += 6;
                return "Bocin!!";
            }
            case 3 -> {
                this.puntosActual += 9;
                return "Moñona!!";
            }
            case 4 -> {
                return "Fallo!!! Que malo";
            }
        }

        return null;
    }

    public String getTurnos(){
        return String.valueOf(this.totalTurnosEquipo);
    }
    
    
    public boolean comprobarGanador() {

        int puntosActules;
        if ((this.totalTurnosEquipo % 2) == 0) {
            puntosActules = this.puntosB;
        } else {
            puntosActules = this.puntosA;
        }
        
        if (puntosActules > 26) {
            this.gestorJugadores.AgregarResultados(this.gestorJugadores.getEquipoActual(), "Ganador");
            this.gestorJugadores.AgregarResultados(this.gestorJugadores.getEquipoProximo(), "Pededor");
            return true;
        }

        return false;
    }

    public void asignarPuntaje() {
        if ((this.totalTurnosEquipo % 2) == 0) {
            this.puntosB += this.puntosActual;
        } else {
            this.puntosA += this.puntosActual;
        }

    }

    public void manejarTurno() {
        if (this.turnoJugador < 3) {
            this.teamPanelActual.resaltarJugador(this.turnoJugador + 2);
            this.turnoJugador++;
        } else {
            this.pasarTurno();
        }
    }

    public String getPuntos() {
        return this.puntosA + " : " + this.puntosB;
    }

    public void pasarTurno() {
        this.turnoJugador = 0;
        this.totalTurnosEquipo++;
        this.gestorJugadores.intercambiarEquipos();

        //Intercambio de teamPanel
        TeamPanel tempTeamPanel = this.teamPanelActual;
        this.teamPanelActual = this.teamPanelProximo;
        this.teamPanelProximo = tempTeamPanel;
        this.teamPanelProximo.deshabilitar();
        this.teamPanelActual.habilitar();
        this.teamPanelActual.resaltarJugador(this.turnoJugador+1);


    }

}
