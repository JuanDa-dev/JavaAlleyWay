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
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;
import javax.sound.sampled.Clip;

/**
 *
 * @author Edilberto
 */
public abstract class Nivel {

    private Nivel siguiente;
    private LinkedList<Brick> bricks;
    private Clip BgMusic;

    public Nivel() {
        bricks = new LinkedList<>();
        siguiente = null;
        BgMusic = null;
    }

    public Nivel getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nivel siguiente) {
        this.siguiente = siguiente;
    }

    public Clip getBgMusic() {
        return BgMusic;
    }

    public void setBgMusic(Clip BgMusic) {
        this.BgMusic = BgMusic;
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

    //Actualizo la pantalla
    public void actualizar(Ball ball, boolean mover, Rectangle limites, Table tabla, GameSpace panel) {
        ball.mover(mover, limites, tabla, bricks, panel);
        tabla.mover(limites);
    }

    //Creo los ladrillos
    public abstract void createBricks();

    //Cambio de colores de los ladrillos
    public abstract void cambioColores();

}
