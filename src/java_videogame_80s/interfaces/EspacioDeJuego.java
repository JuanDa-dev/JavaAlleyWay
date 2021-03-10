/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_videogame_80s.interfaces;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_videogame_80s.gamecomponents.Bola;
import java_videogame_80s.gamecomponents.Ladrillo;
import java_videogame_80s.gamecomponents.Tabla;

/**
 *
 * @author Edilberto
 */
public class EspacioDeJuego extends javax.swing.JFrame implements KeyListener {

    private int x = 200, y = 665;//coordenadas X y Y de la bola iniciales
    protected boolean juego;//variable boleana para comenzar el juego
    private int balls;
    private ArrayList<Bola> bolas;
    private ArrayList<Ladrillo> ladrillos;
    private Bola b;
    private Tabla barra;

    public EspacioDeJuego() {
        initComponents();
        bolas = new ArrayList();
        ladrillos = new ArrayList();
        barra = new Tabla(165, 680);
        addKeyListener(this);
        setFocusable(true);
        balls = 3;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Alleyway V 1.1.");
        setBounds(new java.awt.Rectangle(0, 0, 690, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(690, 720));

        jPanel1.setBackground(new java.awt.Color(170, 170, 170));

        jButton1.setText("Iniciar");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Pausar");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(496, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(641, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!juego) {
            b = new Bola(barra.getX() + 35, y, 400, 720, barra);
            bolas.add(b);//Agrego al ArrayList
            b.inicio();//inicio el hilo
            juego = true;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(juego){
            if (jButton2.getText().equals("Pausar")) {
                barra.setMove(false);
                b.pausa();
                jButton2.setText("Reanudar");
            } else {
                barra.setMove(true);
                b.continuar();
                jButton2.setText("Pausar");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EspacioDeJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EspacioDeJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EspacioDeJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EspacioDeJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EspacioDeJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void paint(Graphics g) {
        super.paint(g);//Para no dejar rastro
        g.setColor(new Color(52, 52, 60));
        g.fillRect(0, 0, 415, 720);
        Toolkit t = Toolkit.getDefaultToolkit();//Obtengo un objeto de la clase toolkit
        Image tabla = t.getImage("src/data/Images/Bar.jpg");//Obtengo la imagen de la tabla
        g.setColor(new Color(170, 170, 170));
        if (juego) {
            for (Bola bola1 : bolas) {//recorro la lista de arreglos
                g.fillOval(bola1.getX(), bola1.getY(), 15, 15);
            }
        } else {
            g.fillOval(barra.getX() + 35, y, 15, 15);
        }
        g.drawImage(tabla, barra.getX(), barra.getY(), 85, 10, this);//dibujo la tabla
        try {
            Thread.sleep(45);//Retardo en milisegundos
        } catch (InterruptedException ex) {
            Logger.getLogger(EspacioDeJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();//Vuelvo a pintar
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        barra.mover(e);//metodo para mover la barra
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void gameOver() {
        if (balls <= 0) {
            b.pausa();
            barra.setMove(false);
        }
    }
    
}
