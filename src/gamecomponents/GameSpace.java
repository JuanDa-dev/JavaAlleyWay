package gamecomponents;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import gamecomponents.Ball;
import gamecomponents.Brick;
import gamecomponents.Table;

public class GameSpace extends javax.swing.JFrame implements KeyListener {

    private final int x; //coordenadas X y Y de la bola iniciales
    //coordenadas X y Y de la bola iniciales
    private final int y = 665;//coordenadas X y Y de la bola iniciales
    protected boolean juego;//variable boleana para comenzar el juego
    private final int balls;
    private final ArrayList<Ball> bolas;
    private final ArrayList<Brick> ladrillos;
    private Ball b;
    private final Table barra;

    public GameSpace() {
        this.x = 200;
        initComponents();
        bolas = new ArrayList();
        ladrillos = new ArrayList();
        barra = new Table(165, 680);
        addKeyListener(this);
        setFocusable(true);
        balls = 3;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentGameSpace = new javax.swing.JPanel();
        pauseButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Alleyway V 1.1.");
        setBounds(new java.awt.Rectangle(0, 0, 690, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(690, 720));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        contentGameSpace.setBackground(new java.awt.Color(170, 170, 170));

        pauseButton.setText("Pausar");
        pauseButton.setFocusable(false);
        pauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentGameSpaceLayout = new javax.swing.GroupLayout(contentGameSpace);
        contentGameSpace.setLayout(contentGameSpaceLayout);
        contentGameSpaceLayout.setHorizontalGroup(
            contentGameSpaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentGameSpaceLayout.createSequentialGroup()
                .addComponent(pauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 325, Short.MAX_VALUE))
        );
        contentGameSpaceLayout.setVerticalGroup(
            contentGameSpaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentGameSpaceLayout.createSequentialGroup()
                .addComponent(pauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 675, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentGameSpace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentGameSpace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseButtonActionPerformed
        if (juego) {
            if (pauseButton.getText().equals("Pausar")) {
                barra.setMove(false);
                b.pausa();
                pauseButton.setText("Reanudar");
            } else if (pauseButton.getText().equals("Reanudar")) {
                barra.setMove(true);
                b.continuar();
                pauseButton.setText("Pausar");
            }
        }
    }//GEN-LAST:event_pauseButtonActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if (!juego) {
            b = new Ball(barra.getX() + 35, y, 400, 720, barra);
            bolas.add(b);//Agrego al ArrayList
            b.inicio();//inicio el hilo
            juego = true;
            barra.setMove(true);

        }
    }//GEN-LAST:event_formMouseClicked

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
            java.util.logging.Logger.getLogger(GameSpace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameSpace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameSpace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameSpace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new GameSpace().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentGameSpace;
    private javax.swing.JButton pauseButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color(52, 52, 60));
        g.fillRect(0, 0, 400, 720);
        Toolkit t = Toolkit.getDefaultToolkit();//Obtengo un objeto de la clase toolkit
        Image tabla = t.getImage("src/dataImages/Bar.jpg");//Obtengo la imagen de la barra
        g.setColor(new Color(155, 152, 152));
        if (juego) {
            bolas.forEach((bola1) -> {
                //recorro la lista de arreglos
                g.fillOval(bola1.getX(), bola1.getY(), 15, 15);
            });
        } else {
            g.fillOval(barra.getX() + 35, y, 15, 15);
        }
        g.drawImage(tabla, barra.getX(), barra.getY(), 85, 10, this);//dibujo la barra
        try {
            Thread.sleep(0);//Retardo en milisegundosrepaint();
        } catch (InterruptedException ex) {
            Logger.getLogger(GameSpace.class.getName()).log(Level.SEVERE, null, ex);

        }
        repaint();
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
