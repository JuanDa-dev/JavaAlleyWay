package gamecomponents;

import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.LinkedList;

public class Ball {

    private int x, y;
    private int cambioX = 1, cambioY = -1;
    private final int ANCHO = 20, ALTO = 20;
    private GameSpace panel;

    public Ball(int x, int y, GameSpace panel) {
        this.x = x;
        this.y = y;
        this.panel = panel;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getANCHO() {
        return ANCHO;
    }

    public int getALTO() {
        return ALTO;
    }

    public Ellipse2D getPelota() {

        return new Ellipse2D.Double(x, y, ANCHO, ALTO);
    }

    public void mover(boolean mover, Rectangle limites, Table tabla, int colision, LinkedList<Brick> ladrillos) {
        if (mover) {
            x += cambioX;
            y += cambioY;
            int indice = 0, eliminar = -1;
            for (Brick ladrillo : ladrillos) {
                if (!ladrillo.choque(this).equals("")) {
                    if (ladrillo.choque(this).equals("right")) {
                        cambioX = 1;
                    } else if (ladrillo.choque(this).equals("left")) {
                        cambioX = -1;
                    } else if (ladrillo.choque(this).equals("up")) {
                        cambioY = -1;
                    } else if (ladrillo.choque(this).equals("down")) {
                        cambioY = 1;
                    }
                    eliminar = indice;
                    panel.setScore(panel.getScore() + 50);
                }
                indice++;
            }
            if (eliminar != -1) {
                ladrillos.remove(eliminar);
            }
            if (colision == -1 && KeyEvents.izq) {
                cambioY = -cambioY;
                cambioX = -1;
                y = tabla.getY() - 20;
            } else if (colision == 1 && KeyEvents.der) {
                cambioY = -cambioY;
                cambioX = 1;
                y = tabla.getY() - 20;
            } else if (colision != 2) {
                cambioY = -cambioY;
                y = tabla.getY() - 20;
            }
            if (x > limites.getMaxX() - ANCHO) {
                cambioX = -cambioX;
            }
            if (y < limites.getMaxY() - 40) {
                cambioY = -cambioY;
            }
            if (x < 0) {
                cambioX = -cambioX;
            }
            if (y > 0) {
                cambioY = -cambioY;
            }
            if (y == limites.getMaxY() - 40) {
                panel.setBalls(panel.getBalls() - 1);
                panel.setJuego(false);
                panel.getScreen().setbPause(false);
            }

        } else {
            x = tabla.getX() + 60;
            y = tabla.getY() - 20;
        }
    }

}
