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
import java.util.HashMap;
import javax.swing.ImageIcon;

/**
 *
 * @author Juan
 */
public class GestorJugadores {

    private Equipo equipoActual;
    private Equipo equipoProximo;
    private ArrayList<Equipo> equipos;
    private ArrayList<Jugador> jugadoresNoElectos;
    private HashMap<Equipo, String> resultados;

    public GestorJugadores() {
        this.equipos = new ArrayList<>();
        this.jugadoresNoElectos = new ArrayList<>();
        this.resultados = new HashMap<>();
        this.equipoActual = null;
        this.equipoProximo = null;

        crearJugadores();
    }

    public void AgregarEquipo(int id, String nombre, String departamento) {
        equipos.add(new Equipo(id, nombre, departamento));
    }

    public void AgregarResultados(Equipo equipo, String resultado) {
        this.resultados.put(equipo, resultado);
    }

    public Equipo getEquipoActual() {
        return equipoActual;
    }

    public Equipo getEquipoProximo() {
        return equipoProximo;
    }

    public HashMap<Equipo, String> getResultados() {
        return resultados;
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

        if (this.equipos.size() < 2) {
            return;
        }

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

    public void seleccionarJugadores(Equipo equipo) {
        if (this.jugadoresNoElectos.size() < 4) {
            return;
        }
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
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

    public void cargarVistaEquipo(TeamPanel panelEquipo) {
        if (equipoActual == null || equipoProximo == null) {
            return;
        }

        if (equipoActual.getJugadores().isEmpty() || equipoProximo.getJugadores().isEmpty()) {
            return;
        }

        panelEquipo.labEquipo.setText(this.equipoActual.getNombre());

        panelEquipo.labJugador1.setText(this.equipoActual.getJugador(0).getNombre());
        panelEquipo.labFoto1.setIcon(this.equipoActual.getJugador(0).getFoto());

        panelEquipo.labJugador2.setText(this.equipoActual.getJugador(1).getNombre());
        panelEquipo.labFoto2.setIcon(this.equipoActual.getJugador(1).getFoto());

        panelEquipo.labJugador3.setText(this.equipoActual.getJugador(2).getNombre());
        panelEquipo.labFoto3.setIcon(this.equipoActual.getJugador(2).getFoto());

        panelEquipo.labJugador4.setText(this.equipoActual.getJugador(3).getNombre());
        panelEquipo.labFoto4.setIcon(this.equipoActual.getJugador(3).getFoto());

    }

    public void crearJugadores() {
        this.jugadoresNoElectos.add(new Jugador("Dina", "123456789", 25, new ImageIcon(getClass().getResource("/fotos/Dina.png"))));
        this.jugadoresNoElectos.add(new Jugador("Aquiles", "987654321", 30, new ImageIcon(getClass().getResource("/fotos/Aquiles.png"))));
        this.jugadoresNoElectos.add(new Jugador("Dbora", "456789123", 28, new ImageIcon(getClass().getResource("/fotos/Dbora.png"))));
        this.jugadoresNoElectos.add(new Jugador("Zoyla", "789123456", 27, new ImageIcon(getClass().getResource("/fotos/Zoyla.png"))));
        this.jugadoresNoElectos.add(new Jugador("Susana", "321654987", 23, new ImageIcon(getClass().getResource("/fotos/Susana.png"))));
        this.jugadoresNoElectos.add(new Jugador("Elvis", "654321789", 29, new ImageIcon(getClass().getResource("/fotos/Elvis.png"))));
        this.jugadoresNoElectos.add(new Jugador("Elsa", "147258369", 26, new ImageIcon(getClass().getResource("/fotos/Elsa.png"))));
        this.jugadoresNoElectos.add(new Jugador("Esteban", "369147258", 24, new ImageIcon(getClass().getResource("/fotos/Esteban.png"))));
        this.jugadoresNoElectos.add(new Jugador("Yola", "258369147", 31, new ImageIcon(getClass().getResource("/fotos/Yola.png"))));
        this.jugadoresNoElectos.add(new Jugador("Elba", "852369741", 22, new ImageIcon(getClass().getResource("/fotos/Elba.png"))));
        this.jugadoresNoElectos.add(new Jugador("Mario", "369852147", 27, new ImageIcon(getClass().getResource("/fotos/Mario.png"))));
        this.jugadoresNoElectos.add(new Jugador("Benito", "741258963", 26, new ImageIcon(getClass().getResource("/fotos/Benito.png"))));
        this.jugadoresNoElectos.add(new Jugador("Luz", "159263478", 24, new ImageIcon(getClass().getResource("/fotos/Luz.png"))));
        this.jugadoresNoElectos.add(new Jugador("Armando", "852147369", 28, new ImageIcon(getClass().getResource("/fotos/Armando.png"))));
        this.jugadoresNoElectos.add(new Jugador("Alan", "369741852", 25, new ImageIcon(getClass().getResource("/fotos/Alan.png"))));
        this.jugadoresNoElectos.add(new Jugador("Andres", "4147814615", 30, new ImageIcon(getClass().getResource("/fotos/Andres.png"))));
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }
}
