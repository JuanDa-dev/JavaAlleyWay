package gamecomponents;

import interfaces.ControlInterface;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Santiago Llerena
 */
public class KeyEvents extends KeyAdapter {

    static boolean izq, der;
    ControlInterface ventana;

    public KeyEvents(ControlInterface ventana) {
        this.ventana = ventana;
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int id = ke.getKeyCode();

        if (id == KeyEvent.VK_LEFT) {
            izq = true;
        }
        if (id == KeyEvent.VK_RIGHT) {
            der = true;
        }

        if (id == KeyEvent.VK_SPACE) {
            ventana.pause();
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        int id = ke.getKeyCode();

        if (id == KeyEvent.VK_LEFT) {
            izq = false;
        }
        if (id == KeyEvent.VK_RIGHT) {
            der = false;
        }
    }

}
