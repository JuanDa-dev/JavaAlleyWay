package gamecomponents;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Ball implements Runnable {

    private int x;//Coordenada X de la bola
    private int y;//Coordenada Y de la bola
    private final int limiteX;//Limite X del frame
//Limite X del frame
    private final int limiteY;
    //variable que hace ir a la izquierda o derecha la bola
    //Limite Y del frame
    private int cambioX;
    private int cambioY = -1;//variable que hace subir o bajar la bola
    Thread hilo;//Instancio un objeto
    private final Table barra;

    public Ball(int x, int y, int limiteX, int limiteY, Table barra) {
        this.cambioX = 1;
//Constructor de la clase Bola
        this.x = x;
        this.y = y;
        this.limiteX = limiteX;
        this.limiteY = limiteY;
        this.barra = barra;
        hilo = new Thread(this);//Creo un nuevo hilo
    }

    //Metodos getter and setter
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void inicio() {//metodo que comienza el hilo
        hilo.start();
    }

    public void pausa() {//metodo que pausa el hilo
        hilo.suspend();
    }

    public void continuar() {//metodo que reanuda el hilo
        hilo.resume();
    }

    @Override
    public void run() {//metodo run
        try {
            while (true) {
                if (x > limiteX) {//si se sobrepasa el limite se devuelve
                    cambioX = -1;
                }
                if (x < 0) {//si esta menos del limite avanza
                    cambioX = 1;
                }
                if (y < 25) {//si esta menos del limite avanza
                    cambioY = 1;
                }
                if (x > barra.getX() - 7.5 && x < barra.getX() + 92.5 && y == barra.getY() - 15) {
                    cambioY = -1;
                }
                x += cambioX;
                y += cambioY;
                Thread.sleep(5);//Retardo en milisegundos
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Ball.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
