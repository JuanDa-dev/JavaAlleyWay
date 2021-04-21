package gamecomponents;

import Utils.PlaySounds;
import interfaces.ControlInterface;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;

public class GameSpace extends JPanel {

    private int balls, score;
    private Ball ball = new Ball(160, 480, this);
    private final Table table = new Table(110, 530);
    private LinkedList<Brick> bricks;
    private boolean juego;
    private ControlInterface ventana;
    private Clip BgMusic;

    public GameSpace(ControlInterface ventana) {
        PlaySounds clip = new PlaySounds("src\\dataSounds\\BackgroundMusic.wav");
        this.BgMusic=clip.getClip();
        BgMusic.loop(-1);
        this.setBackground(Color.darkGray);
        balls = 3;
        score = 0;
        bricks = new LinkedList<>();
        this.ventana = ventana;
        createBricks(); 
        juego = false;
    }

    public Clip getBgMusic() {
        return BgMusic;
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
    }

    public void actualizar() {
        ball.mover(juego, getBounds(), table, bricks);
        table.mover(getBounds());
        if (balls <= 0 || bricks.isEmpty()) {
            gameOver();
        }
        hud();
    }

    private void createBricks() {
        Color color = new Color(98, 187, 55);
        int salto = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 11; j++) {
                switch (i) {//Depedendiendo de para hacer saltos y establecer el color al ladrillo
                    case 2:
                    case 3:
                        color = new Color(225, 220, 17);
                        salto = 20;
                        break;
                    case 4:
                    case 5:
                        color = new Color(20, 220, 217);
                        salto = 40;
                        break;
                    case 6:
                    case 7:
                        color = new Color(202, 40, 202);
                        salto = 60;
                        break;
                }
                bricks.add(new Brick(10 + 62 * j, 20 + 17 * i + salto, color));
            }
        }
    }

    //Muestro los ladrillos
    private void showBricks(Graphics2D g) {
        for (Brick ladrillo : bricks) {
            g.setColor(ladrillo.getColor());//Color del ladrillo
            g.fillRect(ladrillo.getX(), ladrillo.getY(), ladrillo.getANCHO(), ladrillo.getALTO());
        }
    }

    private void gameOver() {
        BgMusic.stop();
        PlaySounds Gover = new PlaySounds("src\\dataSounds\\GameOverSound.wav");
        Gover.getClip().start();
        ventana.getGameOver().setVisible(true);
        ventana.getHilo().stop();
        
    }

    private void hud() {
        ventana.getBalls().setText(this.balls + "");
        ventana.getScore().setText(this.score + "");
    }

}
