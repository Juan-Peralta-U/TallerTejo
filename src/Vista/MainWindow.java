/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ControlManager;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author cesar
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    
    private ControlManager control;
    public MainWindow(ControlManager control) {
        initComponents();
        this.control=control;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labTitulo = new javax.swing.JLabel();
        teamPanelA = new Vista.TeamPanel();
        teamPanelB = new Vista.TeamPanel();
        labPuntos = new javax.swing.JLabel();
        btnLanzar = new javax.swing.JButton();
        labTituloPuntos = new javax.swing.JLabel();
        labTurno = new javax.swing.JLabel();
        btnJugar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        labTitulo.setBackground(new java.awt.Color(147, 164, 255));
        labTitulo.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        labTitulo.setText("      Simulación de partida");
        labTitulo.setOpaque(true);

        labPuntos.setFont(new java.awt.Font("Dubai Medium", 1, 36)); // NOI18N
        labPuntos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPuntos.setText("0 - 0");

        btnLanzar.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        btnLanzar.setText("Lanzar el tejo");

        labTituloPuntos.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N
        labTituloPuntos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTituloPuntos.setText("PUNTAJE");
        labTituloPuntos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        labTurno.setFont(new java.awt.Font("Dubai Medium", 0, 16)); // NOI18N
        labTurno.setForeground(new java.awt.Color(51, 51, 51));
        labTurno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTurno.setText("Turno 1");
        labTurno.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        btnJugar.setBackground(new java.awt.Color(72, 70, 255));
        btnJugar.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        btnJugar.setForeground(new java.awt.Color(255, 255, 255));
        btnJugar.setText("Volver a jugar");

        btnSalir.setBackground(new java.awt.Color(72, 70, 255));
        btnSalir.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnJugar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(teamPanelA, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(btnLanzar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labTituloPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(labPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(teamPanelB, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(labTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(teamPanelA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labTurno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labTituloPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(btnLanzar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addComponent(teamPanelB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnJugar)
                    .addComponent(btnSalir))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void mensajeEmergente(String m){
        JOptionPane.showMessageDialog(null, m);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnJugar;
    public javax.swing.JButton btnLanzar;
    public javax.swing.JButton btnSalir;
    public javax.swing.JLabel labPuntos;
    private javax.swing.JLabel labTitulo;
    private javax.swing.JLabel labTituloPuntos;
    public javax.swing.JLabel labTurno;
    public Vista.TeamPanel teamPanelA;
    public Vista.TeamPanel teamPanelB;
    // End of variables declaration//GEN-END:variables
}
