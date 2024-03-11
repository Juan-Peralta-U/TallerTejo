/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.File;

/**
 *
 * @author Familia Mora
 */
public class ArchivoPropiedades {
    private File archivo;
    private Properties propiedades = new Properties();
    private InputStream entrada = null;

    public ArchivoPropiedades(File archivo) {
        this.archivo = archivo;
    }

    public void leerArchivo() {
        if(archivo == null)return;
        
        try {
            entrada = new FileInputStream(archivo);
            propiedades.load(entrada);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            if (entrada == null)return;
            
            try {
                entrada.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public String getData(String key){
        return this.propiedades.getProperty(key);
    }
    
    
}
