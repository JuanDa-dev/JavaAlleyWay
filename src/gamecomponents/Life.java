package gamecomponents;

import java.awt.geom.Ellipse2D;

/**
 *
 * @author Santiago Llerena
 */
public class Life extends Power {
    
    public Life(float x, float y) {
        super(x, y);
    }

    @Override
    public Ellipse2D getShape() {
        return new Ellipse2D.Double(x, y, DIAMETRO, DIAMETRO);
    }
}
