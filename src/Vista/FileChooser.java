/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author cesar
 */
public class FileChooser {
    private JFileChooser fc;
    
    public FileChooser() { }
    
    public File getFile(){
        fc = new JFileChooser(System.getProperty("user.dir"));
        fc.showOpenDialog(fc);
        return fc.getSelectedFile();
    }
}
