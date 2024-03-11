/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Familia Mora
 */
public class ControlManager {

    Properties propiedades = new Properties();
    InputStream entrada = null;

    public void leerEquipos() {
        try {
            entrada = new FileInputStream("Equipos.properties");
            propiedades.load(entrada);
            System.out.println(propiedades.getProperty("basedatos"));
            System.out.println(propiedades.getProperty("usuario"));
            System.out.println(propiedades.getProperty("clave"));
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
