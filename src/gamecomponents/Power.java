package gamecomponents;

import java.awt.geom.Ellipse2D;

/**
 *
 * @author Santiago Llerena
 */
public abstract class Power {

//    private class MoveThread extends Thread {
//        
//        Power poder;
//
//        public MoveThread(Power poder) {
//            this.poder = poder;
//        }
//        
//        @Override
//        public void run() {
//            while (true) {
//                poder.x+=dx;
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(MoveThread.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//
//    }
    protected float x, y, dy;
    final int DIAMETRO = 20;
//    protected MoveThread hilo;
//

    public Power(float x, float y) {
        this.x = x;
        this.y = y;
        this.dy = 0.5f;
//        hilo=new MoveThread(this);
//        hilo.start();
    }
//    
//    public void iniciar(){
//        hilo.start();
//    }
//    
//    public void reanudar(){
//        hilo.resume();
//    }
//    
//    public void parar(){
//        hilo.stop();
//    }
//    
//    public void suspender(){
//        hilo.suspend();
//    }   

    public abstract Ellipse2D getShape();

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }
}
