/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_videogame_80s.gamecomponents;

import java_videogame_80s.gamecomponents.Tabla;
import java_videogame_80s.gamecomponents.Bola;
import java_videogame_80s.gamecomponents.Ladrillo;
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
public class EspacioJuego extends JFrame implements KeyListener, ActionListener{
    
    private JButton inicio, pausa;
    private JPanel panel;//instancio un panel
    private int x = 200, y = 665;//coordenadas X y Y de la bola iniciales
    protected boolean juego;//variable boleana para comenzar el juego
    private ArrayList<Bola> bolas;
    private ArrayList<Ladrillo> ladrillos;
    private Bola b;
    private Tabla barra;

    public EspacioJuego() {
        this.setLayout(null);//Se especifica que se va a trabajar con coordenadas
        this.setResizable(false);//Para que no se cambie el tamaño de la interfaz
        this.setBounds(0, 0, 690, 720);//Establezco las coordenadas y el ancho y el alto de la interfaz
        this.setTitle("Alleyway V 1.1");
        this.setLocationRelativeTo(null);//Posiciona la interfaz en el centro
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//Cuando se cierra el programa, tambien deje de ejecutarse
        addKeyListener(this);
        setFocusable(true);
        bolas = new ArrayList();
        ladrillos = new ArrayList();
        barra = new Tabla(165,680);
        componentes();
    }
    
    public void componentes() {
        //Agrego un panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 690, 720);
        panel.setBackground(new Color(170, 170, 170));
        add(panel);

        //Agrego los botones
        //Boton de inicio
        inicio = new JButton("Iniciar");
        inicio.setBounds(430, 600, 70, 50);
        inicio.setFocusable(false);
        panel.add(inicio);
        inicio.addActionListener(this);

        //Boton de pausa
        pausa = new JButton("Pausar");
        pausa.setBounds(515, 600, 100, 50);
        pausa.setFocusable(false);
        panel.add(pausa);
        pausa.addActionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);//Para no dejar rastro
        g.setColor(new Color(52, 52, 60));
        g.fillRect(0, 0, 415, 720);
        Toolkit t = Toolkit.getDefaultToolkit();//Obtengo un objeto de la clase toolkit
        Image tabla = t.getImage("src/java_videogame_80s/data/Imagenes/Bar.jpg");//Obtengo la imagen de la tabla
        g.setColor(new Color(170,170,170));
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
            Logger.getLogger(EspacioJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.paintComponents(g);
        repaint();//Vuelvo a pintar
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inicio && !juego) {
            b = new Bola(barra.getX() + 35, y, 400, 720,barra);
            bolas.add(b);//Agrego al ArrayList
            b.inicio();//inicio el hilo
            juego = true;
        }
        if (e.getSource() == pausa) {
            if (pausa.getText().equals("Pausar")) {
                b.pausa();
                pausa.setText("Reanudar");
            } else {
                b.continuar();
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
    
}
