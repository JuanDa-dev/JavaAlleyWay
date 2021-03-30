package gamecomponents;

import interfaces.ControlInterface;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import javax.swing.JPanel;

public class GameSpace extends JPanel {

    private int balls, score;
    private Ball ball = new Ball(160, 480, this);
    private final Table table = new Table(110, 500);
    private LinkedList<Brick> bricks;
    private boolean juego;
    private ControlInterface ventana;

    public GameSpace(ControlInterface ventana) {
        this.setBackground(Color.darkGray);
        balls = 3;
        score = 0;
        bricks = new LinkedList<>();
        this.ventana = ventana;
        createBricks(); 
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
        paint(g2);
        this.actualizar();
    }

    public void paint(Graphics2D g) {
        g.fillOval(ball.getX(), ball.getY(), ball.getANCHO(), ball.getALTO());
        g.fillRect(table.getX(), table.getY(), table.getANCHO(), table.getALTO());
          try {
            showBricks(g);
        } catch (ConcurrentModificationException e) {//Si se elimina un ladrillo, mientras estaba recorriendo los ladrillos
            showBricks(g);//muestra de nuevo los ladrillos
        }
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
        ball.mover(juego, getBounds(), table, colision(table), bricks);
        table.mover(getBounds());
        if (balls <= 0) {
            gameOver();
        }
        hud();
    }

    private int colision(Table tabla) {
        if (ball.getPelota().intersects(tabla.getCenter())) {
            return 0;
        } else if (ball.getPelota().intersects(tabla.getLeft())) {
            return -1;
        } else if (ball.getPelota().intersects(tabla.getRiqht())) {
            return 1;
        }
        return 2;
    }

    private void createBricks() {
        Color color = new Color(11, 48, 134);
        int salto = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                switch (i) {//Depedendiendo de para hacer saltos y establecer el color al ladrillo
                    case 2:
                    case 3:
                        color = new Color(133, 84, 12);
                        salto = 25;
                        break;
                    case 4:
                    case 5:
                        color = new Color(57, 78, 87);
                        salto = 50;
                        break;
                    case 6:
                    case 7:
                        color = new Color(79, 55, 89);
                        salto = 75;
                        break;
                }
                bricks.add(new Brick(7 + 60 * j, 50 + 30 * i + salto, 20, 50, color));
            }
        }
    }

    //Muestro los ladrillos
    private void showBricks(Graphics g) {
        for (Brick ladrillo : bricks) {
            g.setColor(ladrillo.getColor());//Color del ladrillo
            g.fillRect(ladrillo.getX(), ladrillo.getY(), ladrillo.getANCHO(), ladrillo.getALTO());
        }
    }

    private void gameOver() {
        ventana.getGameOver().setVisible(true);
        ventana.getHilo().stop();
    }

    private void hud() {
        ventana.getBalls().setText(this.balls + "");
        ventana.getScore().setText(this.score + "");
    }

}
