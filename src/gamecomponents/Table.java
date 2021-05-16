package gamecomponents;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Table {

    private int x;
    private final int y;
    private final int ANCHO = 100, ALTO = 10;
    private boolean move;

    public Table(int x, double y) {
        this.x = x;
        this.y = (int) y;
        move = true;
    }

    public boolean isMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
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

    public Rectangle2D getTabla() {
        return new Rectangle2D.Double(x, y, ANCHO, 1);
    }

    public Rectangle2D getLeft() {
        return new Rectangle2D.Double(x, y, ANCHO / 3, 1);
    }

    public Rectangle2D getCenter() {
        return new Rectangle2D.Double(x + ANCHO / 3, y, ANCHO / 3, 1);
    }

    public Rectangle2D getRiqht() {
        return new Rectangle2D.Double(x + (2 * (ANCHO / 3)), y, ANCHO / 3, 1);
    }

    public void mover(Rectangle limites) {
        if (move) {
            if (KeyEvents.izq == true && x >= limites.getMinX()) {
                x--;
            }
            if (KeyEvents.der == true && (x + ANCHO) <= limites.getMaxX()) {
                x++;
            }
        }
    }

    public String choque(Ball bola) {
        if (bola.getY() + bola.getALTO() == this.getY()) {//La bola se acerca por arriba
            if (bola.getX() + bola.getALTO() >= this.getX() && bola.getX() <= this.getX() + this.getANCHO()) {//La bola golpea la tabla
                return "up";//Va hacia arriba
            }
        } else if (bola.getX() == this.getX() + this.getANCHO()) {//La bola se acerca por la derecha
            if (bola.getY() + bola.getANCHO() >= this.getY() && bola.getY() <= this.getY() + this.getALTO()) {//La bola golpea la tabla
                return "right";//Va hacia la derecha
            }
        } else if (bola.getX() + bola.getANCHO() == this.getX()) {//La bola se acerca por la izquierda
            if (bola.getY() + bola.getANCHO() >= this.getY() && bola.getY() <= this.getY() + this.getALTO()) {//La bola golpea la tabla
                return "left";//Va hacia la izquierda
            }
        }
        return "";//No golpea la tabla
    }

}
