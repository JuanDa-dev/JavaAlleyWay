/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_videogame_80s;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

/**
 *
 * @author juanq
 */
public class EspacioJuego extends JFrame implements KeyListener, ActionListener {

    private JButton inicio, pausa, reset, principio;
    private JPanel panelGUI;//instancio un panel
    private int x = 200, y = 665;//coordenadas X y Y de la bola iniciales
    protected boolean juego;//variable boleana para comenzar el juego
    private int bolas;
    private ArrayList<Ladrillo> ladrillos;
    private Bola b;
    private Tabla barra;
    private JFrame principal;

    public EspacioJuego(JFrame principal) {
        this.setLayout(null);//Se especifica que se va a trabajar con coordenadas
        this.setResizable(false);//Para que no se cambie el tamaño de la interfaz
        this.setBounds(0, 0, 690, 720);//Establezco las coordenadas y el ancho y el alto de la interfaz
        this.setTitle("Alleyway V 1.1");
        this.setLocationRelativeTo(null);//Posiciona la interfaz en el centro
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//Cuando se cierra el programa, tambien deje de ejecutarse
        addKeyListener(this);
        setFocusable(true);
        bolas = 3;
        ladrillos = new ArrayList();
        barra = new Tabla(165, 680);
        this.principal = principal;
        componentes();
    }

    public void componentes() {
        //Agrego un panel GUI
        panelGUI = new JPanel();
        panelGUI.setLayout(null);
        panelGUI.setBounds(412, 0, 275, 720);
        panelGUI.setBackground(new Color(170, 170, 170));
        add(panelGUI,-1);

        //Agrego los botones
        //Boton de inicio
        inicio = new JButton("Iniciar");
        inicio.setBounds(15, 600, 70, 50);
        inicio.setFocusable(false);
        panelGUI.add(inicio);
        inicio.addActionListener(this);

        //Boton de pausa
        pausa = new JButton("Pausar");
        pausa.setBounds(100, 600, 100, 50);
        pausa.setFocusable(false);
        panelGUI.add(pausa);
        pausa.addActionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);//Para no dejar rastro
        g.setColor(new Color(52, 52, 60));
        g.fillRect(0, 0, 415, 720);
        Toolkit t = Toolkit.getDefaultToolkit();//Obtengo un objeto de la clase toolkit
        Image tabla = t.getImage("src/java_videogame_80s/data/Imagenes/Bar.jpg");//Obtengo la imagen de la tabla
        g.setColor(new Color(170, 170, 170));
        if (juego) {

            g.fillOval(b.getX(), b.getY(), 15, 15);

        } else {
            g.fillOval(barra.getX() + 35, y, 15, 15);
        }
        g.drawImage(tabla, barra.getX(), barra.getY(), 85, 10, this);//dibujo la tabla
        try {
            Thread.sleep(45);//Retardo en milisegundos
        } catch (InterruptedException ex) {
            Logger.getLogger(EspacioJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.paintComponents(g);
        repaint();//Vuelvo a pintar
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inicio && !juego) {
            b = new Bola(barra.getX() + 35, y, 400, 720, barra);
            b.inicio();//inicio el hilo
            juego = true;
            inicio.setEnabled(false);
        }
        if (e.getSource() == pausa) {
            if (pausa.getText().equals("Pausar")) {
                barra.setMove(false);//pausa el movimiento de la tabla
                b.pausa();//pausa el movimiento de la bola
                pausa.setText("Reanudar");
            } else {
                barra.setMove(true);//reanuda el movimiento de la tabala
                b.continuar();//reanuda el movimiento de la bola
                pausa.setText("Pausar");
            }
        }
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
        if (bolas <= 0) {
            b.pausa();
            barra.setMove(false);
        }
    }
}
