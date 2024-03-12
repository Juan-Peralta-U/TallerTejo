/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

/**
 *
 * @author Familia Mora
 */
public class ArchivoAleatorio {

    private RandomAccessFile Rf;
    private long tamañoRegistro;
    private long canReg;

    public ArchivoAleatorio(File Fl) {
        this.canReg = 0;
        this.tamañoRegistro = 109;

        /*
        4+4+40+20+20+20+20+1= 109 bytes
         */
        try {
            Rf = new RandomAccessFile(Fl, "rw");

        } catch (FileNotFoundException fnfe) {

        }
    }

    public void escribir(int clave, int numeroEquipo, String nombreEquipo, String nameJ1, String nameJ2, String nameJ3, String nameJ4, boolean resultado) {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(
                System.in));
        try {
            nombreEquipo = this.completarTamañoBytes(nombreEquipo, 40);
            nameJ1 = this.completarTamañoBytes(nameJ1, 20);
            nameJ2 = this.completarTamañoBytes(nameJ2, 20);
            nameJ3 = this.completarTamañoBytes(nameJ3, 20);
            nameJ4 = this.completarTamañoBytes(nameJ4, 20);

            if (Rf.length() != 0) {
                Rf.seek(Rf.length());
            }
            Rf.writeInt(clave);
            Rf.writeInt(numeroEquipo);
            Rf.writeChars(nombreEquipo);
            Rf.writeChars(nameJ1);
            Rf.writeChars(nameJ2);
            Rf.writeChars(nameJ3);
            Rf.writeChars(nameJ4);
            Rf.writeBoolean(resultado);

        } catch (FileNotFoundException fnfe) {/* Archivo no encontrado */
        } catch (IOException ioe) {
            /* Error al escribir */
        }
    }

    public String lecturaRegistros() {
        int clave = 0;
        int numeroEquipo = 0;
        String nombreEquipo = "";
        String nameJ1 = "";
        String nameJ2 = "";
        String nameJ3 = "";
        String nameJ4 = "";
        String aux = "";
        boolean resultado = false;
        String respuesta = ("Registro\tNumeroEquipo\tNombreEquipo\tNombreJugador1\tNombreJugador2\tNombreJugador3\tNombreJugador4\tResulatdo\n");
        try {
            Rf.seek(0);
            canReg = Rf.length() / tamañoRegistro;

            for (int r = 0; r < canReg; r++) {
                clave = Rf.readInt();
                numeroEquipo = Rf.readInt();

                for (int i = 0; i < 41; ++i) {
                    nombreEquipo += Rf.readChar();
                }

                for (int i = 0; i < 21; ++i) {
                    nameJ1 += Rf.readChar();
                }

                for (int i = 0; i < 21; ++i) {
                    nameJ2 += Rf.readChar();
                }

                for (int i = 0; i < 21; ++i) {
                    nameJ3 += Rf.readChar();
                }

                for (int i = 0; i < 21; ++i) {
                    nameJ4 += Rf.readChar();
                }

                resultado = Rf.readBoolean();

                if (resultado == true) {
                    aux = "Ganador";
                } else {
                    aux = "Perdedor";
                }

                respuesta += (clave + "\t" + numeroEquipo + "\t" + nombreEquipo + "\t" + nameJ1 + "\t" + nameJ2 + "\t" + nameJ3 + "\t" + nameJ4 + "\t" + aux + "\n");
            }
        } catch (Exception e) {
        }
        return null;
    }

//    public int ultimoRegistro() {
//        int clave = 0;
//        try {
//            Rf.seek(Rf.length() - tamañoRegistro);
//            clave = Rf.readInt();
//        } catch (FileNotFoundException fnfe) {/* Archivo no encontrado */
//        } catch (IOException ioe) {
//            /* Error al escribir */
//        }
//        return clave;
//    }
    private String completarTamañoBytes(String n, int tamaño) {

        if (n.length() < tamaño + 1) {
            for (int i = n.length(); i < tamaño + 1; i++) {
                n = n + " ";
            }

        }
        return n;
    }
}
