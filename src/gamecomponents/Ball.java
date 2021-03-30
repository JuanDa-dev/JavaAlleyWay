package gamecomponents;

import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.LinkedList;

/**
 *
 * @author Santiago Llerena
 */
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

    public void mover(boolean mover, Rectangle limites, Table tabla, LinkedList<Brick> ladrillos) {
        if (mover) {
//            x += cambioX;
//            y += cambioY;
//            boolean b = false;
//            for (int i = 0; i < ladrillos.size(); i++) {
//                if (i == 0) {
//                    b = false;
//                }
//                if (colision(ladrillos.get(i))) {
//                    if (colisionLados(ladrillos.get(i))) {
//                        if (b == false) {
//                            cambioX = -cambioX;
//                            b = true;
//                        }
//                    } else {
//                        cambioY = -cambioY;
//                    }
//                    ladrillos.remove(i);
//                    panel.setScore(panel.getScore()+50);
//                }
//            }
//            if (colision==-1&&EventosTeclado.izq) {
//                cambioY = -cambioY;
//                cambioX=-1;
//                y = tabla.getY() -20;
//            }else if(colision==1&&EventosTeclado.der){
//                cambioY = -cambioY;
//                cambioX=1;
//                y = tabla.getY() -20;
//            }else if(colision!=2){
//                cambioY = -cambioY;
//                y = tabla.getY() -20;
//            }
//            if (x > limites.getMaxX() - ANCHO) {
//                cambioX = -cambioX;
//            }
//            if (y < limites.getMaxY() - 40) {
//                cambioY = -cambioY;
//            }
//            if (x < 0) {
//                cambioX = -cambioX;
//            }
//            if (y > 0) {
//                cambioY = -cambioY;
//            }
//            if(y==limites.getMaxY()-100){
//                panel.setBalls(panel.getBalls()-1);
//                panel.setJuego(false);
//                panel.getScreen().setbPause(false);
//            }
            if (x > limites.getMaxX()) {//si se sobrepasa el limite se devuelve
                cambioX = -1;
            }
            if (x < 0) {//si esta menos del limite avanza
                cambioX = 1;
            }
            if (y < 25) {//si esta menos del limite avanza
                cambioY = 1;
            }
            if (tabla.choque(this).equals("up")) {
                cambioY = -1;
            } else if (tabla.choque(this).equals("left")) {
                cambioX = -1;
            } else if (tabla.choque(this).equals("right")) {
                cambioX = 1;
            }
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
                    panel.setScore(panel.getScore()+50);
                }
                indice++;
            }
            if (eliminar != -1) {
                ladrillos.remove(eliminar);
            }
            x += cambioX;
            y += cambioY;
        } else {
            x = tabla.getX() + 60;
            y = tabla.getY() - 20;
        }
    }

    private boolean colision(Brick l) {
        return getPelota().intersects(l.getLadrillo());
    }

    private boolean colisionLados(Brick l) {
        if (getPelota().intersects(l.getLado1())) {
            return true;
        } else if (getPelota().intersects(l.getLado2())) {
            return true;
        }
        return false;
    }

}
