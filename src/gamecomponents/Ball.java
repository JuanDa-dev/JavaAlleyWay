package gamecomponents;

import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.LinkedList;
import main.App;

public class Ball {

    private int x, y;
    private int cambioX = 1, cambioY = -1;
    private final int ANCHO = 15, ALTO = 15;
    private boolean generar;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        generar = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getANCHO() {
        return ANCHO;
    }

    public int getALTO() {
        return ALTO;
    }

    public void setCambioX(int cambioX) {
        this.cambioX = cambioX;
    }

    public void setCambioY(int cambioY) {
        this.cambioY = cambioY;
    }

    public Ellipse2D getPelota() {
        return new Ellipse2D.Double(x, y, ANCHO, ALTO);
    }

    public void mover(boolean mover, Rectangle limites, Table tabla, LinkedList<Brick> ladrillos, GameSpace panel) {
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
                Power poder = ladrillos.get(eliminar).generarPoder();
                ladrillos.remove(eliminar);
                if (poder != null && generar) {
                    if (panel.getMaxPoderes() > 0) {
                        App.poder = poder;
                        generar = !generar;
                        panel.setMaxPoderes(panel.getMaxPoderes() - 1);
                    }
                } else {
                    if (!generar) {
                        generar = !generar;
                    }
                }
            }
            if (tabla.choque(this).equals("up")) {
                cambioY = -1;
            } else if (tabla.choque(this).equals("left")) {
                cambioX = -1;
            } else if (tabla.choque(this).equals("right")) {
                cambioX = 1;
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
            y = tabla.getY() - 15;
        }
    }

}
