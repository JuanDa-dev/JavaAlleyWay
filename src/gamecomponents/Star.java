package gamecomponents;

import java.awt.geom.Ellipse2D;

/**
 *
 * @author Santiago Llerena
 */
public class Star extends Power {
    
    public Star(float x, float y) {
        super(x, y);
    }

    @Override
    public Ellipse2D getShape() {
        return new Ellipse2D.Double(x, y, DIAMETRO, DIAMETRO);
    }
    
}
