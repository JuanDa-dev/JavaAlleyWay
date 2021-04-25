package Utils;

import gamecomponents.GameSpace;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Santiago Llerena
 */
public class Hilo extends Thread {

    private GameSpace espacioDeJuego;
//    private Timer timer = new Timer();
//    private TimerTask score ;

    public Hilo(GameSpace lamina) {
        this.espacioDeJuego = lamina;
    }

    public void pause() {
//        score.cancel();
//        timer.cancel();
    }

    public void reanudar() {
//        timer = new Timer();
//        score = new TimerTask() {
//            @Override
//            public void run() {
//                espacioDeJuego.setScore(espacioDeJuego.getScore() + 3);
//            }
//        };
//        timer.schedule(score, 5000, 3000);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(6);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
            espacioDeJuego.repaint();
        }
    }

}
