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
    private int clave = 0;

    public ArchivoAleatorio(File Fl) {
        this.canReg = 0;
        this.tamañoRegistro = 129;
        
        /*
        4+4+40+20+20+20+20+1= 129 bytes
         */
        try {
            Rf = new RandomAccessFile(Fl, "rw");

        } catch (Exception e) {
            System.exit(0);
        }
    }

    public void escribir(int numeroEquipo, String nombreEquipo, String nameJ1, String nameJ2, String nameJ3, String nameJ4, boolean resultado) {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(
                System.in));
        try {
            this.clave = Math.round(Rf.length()/this.tamañoRegistro) + 1;
            nombreEquipo = this.completarTamañoBytes(nombreEquipo, 20);
            nameJ1 = this.completarTamañoBytes(nameJ1, 10);
            nameJ2 = this.completarTamañoBytes(nameJ2, 10);
            nameJ3 = this.completarTamañoBytes(nameJ3, 10);
            nameJ4 = this.completarTamañoBytes(nameJ4, 10);

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
        String respuesta = ("");
        try {
            Rf.seek(0);
            canReg = Rf.length() / tamañoRegistro;

            for (int r = 0; r < canReg; r++) {
                clave = Rf.readInt();
                numeroEquipo = Rf.readInt();
                nombreEquipo = "";
                nameJ1 = "";
                nameJ2 = "";
                nameJ3 = "";
                nameJ4 = "";

                for (int i = 0; i < 20; ++i) {
                    nombreEquipo += Rf.readChar();
                }

                for (int i = 0; i < 10; ++i) {
                    nameJ1 += Rf.readChar();
                }

                for (int i = 0; i < 10; ++i) {
                    nameJ2 += Rf.readChar();
                }

                for (int i = 0; i < 10; ++i) {
                    nameJ3 += Rf.readChar();
                }

                for (int i = 0; i < 10; ++i) {
                    nameJ4 += Rf.readChar();
                }

                resultado = Rf.readBoolean();

                if (resultado == true) {
                    aux = "Ganador";
                } else {
                    aux = "Perdedor";
                }

                respuesta += ("\n" + clave + "\t\t" + numeroEquipo + "\t\t" + nombreEquipo + "\t" + nameJ1 + "\t" + nameJ2 + "\t" + nameJ3 + "\t" + nameJ4 + "\t" + aux + "\n");
            }
        } catch (Exception e) {
        }
        return respuesta;
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

        if (n.length() < tamaño + 1 ) {
            for (int i = n.length(); i < tamaño; i++) {
                n = n + " ";
            }

        }
        return n;
    }
}
