package gamecomponents;

import java.awt.geom.Ellipse2D;

/**
 *
 * @author Santiago Llerena
 */
public class Power {
    
    protected float x, y, dy;
    final Poder poder;
    final int DIAMETRO = 20;
//    protected MoveThread hilo;
//

    public Power(float x, float y,Poder poder) {
        this.x = x;
        this.y = y;
        this.dy = 0.5f;
        this.poder=poder;
    }
    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }
}
