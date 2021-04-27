/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niveles;

import gamecomponents.Ball;
import gamecomponents.Brick;
import gamecomponents.GameSpace;
import gamecomponents.Table;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 *
 * @author Edilberto
 */
public abstract class Nivel {

    private Nivel siguiente;
    private LinkedList<Brick> bricks;

    public Nivel(GameSpace ventana) {
        bricks = new LinkedList<>();
        siguiente = null;
    }

    public Nivel getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nivel siguiente) {
        this.siguiente = siguiente;
    }

    //Obtengo un ladrillo
    public Brick getBrick(int i) {
        return this.bricks.get(i);
    }

    //Muestro los ladrillos
    public void showBricks(Graphics2D g) {
        for (Brick ladrillo : bricks) {
            g.setColor(ladrillo.getColor());//Color del ladrillo
            g.fillRect(ladrillo.getX(), ladrillo.getY(), ladrillo.getANCHO(), ladrillo.getALTO());
        }
    }

    //devuelvo el tamaño del arraylist
    public int longitudArrayLadrillos() {
        return bricks.size();
    }

    //Añado un ladrillo
    public void añadirLadrillo(Brick b) {
        this.bricks.add(b);
    }

    //Vacio el arrayList
    public void vaciarLadrillos() {
        this.bricks.clear();
    }

    public void actualizar(Ball ball, boolean mover, Rectangle limites, Table tabla) {
        ball.mover(mover, limites, tabla, bricks);
        tabla.mover(limites);
    }

    public abstract void createBricks();

    public abstract void cambioColores();

    public void cambiarColoresNivel3(Color color, Color colorRandom, Color color2, Color colorRandom2, Color color3, Color colorRandom3) {
        for (Brick brick : bricks) {
            if (brick.getColor().equals(color)) {
                brick.setColor(colorRandom);
            } else if (brick.getColor().equals(color2)) {
                brick.setColor(colorRandom2);
            } else if (brick.getColor().equals(color3)) {
                brick.setColor(colorRandom3);
            }
        }
    }

}
