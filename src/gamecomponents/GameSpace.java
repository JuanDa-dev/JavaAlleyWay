package gamecomponents;


import interfaces.ControlInterface;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
 * @author Santiago Llerena
 */
public class GameSpace extends JPanel {

    private int balls,score;
    private final Ball ball = new Ball(160, 480, this);
    private final Table table = new Table(110, 500);
    private final LinkedList<Brick> bricks;
    private boolean juego;
    private final ControlInterface ventana;

    public GameSpace(ControlInterface ventana) {
        this.setBackground(Color.darkGray);
        balls = 3;
        score=0;
        bricks = new LinkedList<>();
        this.ventana = ventana;
        this.setLadrillos(10, 50, ventana.getBounds());
        juego = false;
    }

    public boolean isJuego() {
        return juego;
    }

    public void setJuego(boolean juego) {
        this.juego = juego;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ControlInterface getScreen() {
        return this.ventana;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        dibujar(g2);
        this.actualizar();
    }

    public void dibujar(Graphics2D g) {
        g.fillOval(ball.getX(), ball.getY(), ball.getANCHO(), ball.getALTO());
        g.fillRect(table.getX(), table.getY(), table.getANCHO(), table.getALTO());
        for (int i = 0; i < bricks.size(); i = i + 1) {
            if ((i % 2) == 1) {
                g.setColor(Color.YELLOW);
                g.fill(bricks.get(i).getLadrillo());
            } else if ((i % 2) == 0) {
                g.setColor(Color.green);
                g.fill(bricks.get(i).getLadrillo());
            }
        }
    }

    public void actualizar() {
        ball.mover(juego, getBounds(), table, bricks);
        table.mover(getBounds());
        if(balls<=0){
            gameOver();
        }
        hud();
    }

    private int colision(Table tabla) {
        if(ball.getPelota().intersects(tabla.getCenter())){
            return 0;
        }else if(ball.getPelota().intersects(tabla.getLeft())){
            return -1;
        }else if(ball.getPelota().intersects(tabla.getRiqht())){
            return 1;
        }
        return 2;
    }

    private void setLadrillos(int x, int y, Rectangle limites) {
        int dx = x, dy = y;
        for (int i = 0; i < 30; i++) {

            bricks.add(new Brick(dx, dy));
            if (dx + bricks.get(i).getANCHO() < limites.width - 250) {
                dx += bricks.get(i).getANCHO() + 3;
            } else {
                dx = x;
                dy += bricks.get(i).getALTO() + 3;
            }
        }
    }

    private void gameOver() {
        ventana.getGameOver().setVisible(true);
        ventana.getHilo().stop();
    }

    private void hud(){
        ventana.getBalls().setText(this.balls+"");
        ventana.getScore().setText(this.score+"");
    }
    
}
