/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niveles;

import gamecomponents.Brick;
import java.awt.Graphics2D;
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

    public LinkedList<Brick> getBricks() {
        return bricks;
    }

    public void showBricks(Graphics2D g) {
        for (Brick ladrillo : this.getBricks()) {
            g.setColor(ladrillo.getColor());//Color del ladrillo
            g.fillRect(ladrillo.getX(), ladrillo.getY(), ladrillo.getANCHO(), ladrillo.getALTO());
        }
    }

    public abstract void createBricks();

    public abstract void cambioColores();

}
