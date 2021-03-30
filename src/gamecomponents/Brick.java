package gamecomponents;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

public class Brick {

    private final int x, y, ANCHO = 60, ALTO = 30;
    private Color color; 
  
   

   public Brick(int x, int y, int alto, int ancho, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
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

    public Rectangle2D getLadrillo() {
        return new Rectangle2D.Double(x, y, ANCHO, ALTO);
    }

    public Rectangle2D getLado1() {
        return new Rectangle2D.Double(x, y + 1, 1, ALTO - 2);
    }

    public Rectangle2D getLado2() {
        return new Rectangle2D.Double(x + ANCHO - 1, y + 1, 1, ALTO - 2);
    }
 public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    protected String choque(Ball bola) {
        if (bola.getX() + bola.getANCHO() == this.getX()) {//Si la bola se acerca por la izquierda
            if (bola.getY() + bola.getANCHO() >= this.getY() && bola.getY() <= this.getY() + this.getALTO()) {//si la bola golpea por el lado izquierdo
                return "left";//va hacia  la izquierda
            }
        } else if (bola.getX() == this.getX() + this.getANCHO()) {//Si la bola se acerca por la derecha
            if (bola.getY() + bola.getANCHO() >= this.getY() && bola.getY() <= this.getY() + this.getALTO()) {//si la bola golpea por el lado izquierdo
                return "right";//Va hacia la derecha
            }
        } else if (bola.getY() + bola.getANCHO() == this.getY()) {//Si la bola se acerca por arriba
            if (bola.getX() + bola.getANCHO() >= this.getX() && bola.getX() <= this.getX() + this.getANCHO()) {//Si la bola golpea por arriba
                return "up";//Va hacia arriba
            }
        } else if (bola.getY() == this.getY() + this.getALTO()) {//Si la bola se acerca por debajo
            if (bola.getX() + bola.getANCHO() >= this.getX() && bola.getX() <= this.getX() + this.getANCHO()) {//Si la bola golpea por arriba
                return "down";//Va hacia abajo
            }
        }
        return "";//No golpea la tabla
    }
}
