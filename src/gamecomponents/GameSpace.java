package gamecomponents;

import Utils.PlaySounds;
import interfaces.ControlInterface;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ConcurrentModificationException;
import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;
import main.App;
import niveles.Nivel;
import niveles.Nivel1;
import niveles.Nivel2;
import niveles.Nivel3;

public class GameSpace extends JPanel {

    private Nivel nivel;
    private boolean juego;
    private int maxPoderes = 5;
    private int balls, score;
    private Ball ball;
    private final Table table;
    private ControlInterface ventana;
    private Clip BgMusic;

    public GameSpace(ControlInterface ventana) {
        this.setBackground(Color.darkGray);
        this.ventana = ventana;
        ball = new Ball(160, 480);
        table = new Table(110, 530);
        balls = 3;
        score = 0;
        juego = false;
        niveles();
    }

    public Table getTable() {
        return table;
    }

    public Ball getBall() {
        return ball;
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

    public Clip getBgMusic() {
        return nivel.getBgMusic();
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public boolean isJuego() {
        return juego;
    }

    public void setJuego(boolean juego) {
        this.juego = juego;
    }

    public ControlInterface getScreen() {
        return this.ventana;
    }

    public int getMaxPoderes() {
        return maxPoderes;
    }

    public void setMaxPoderes(int maxPoderes) {
        this.maxPoderes = maxPoderes;
    }

    public void niveles() {
        PlaySounds clipL1 = new PlaySounds("src\\dataSounds\\BackgroundMusicL1.wav");
        PlaySounds clipL2 = new PlaySounds("src\\dataSounds\\BackgroundMusicL2.wav");
        PlaySounds clipL3 = new PlaySounds("src\\dataSounds\\BackgroundMusicL3.wav");
        nivel = new Nivel1();
        nivel.setBgMusic(clipL1.getClip());
        nivel.createBricks();
        nivel.setSiguiente(new Nivel2());
        nivel.getSiguiente().setBgMusic(clipL2.getClip());
        nivel.getSiguiente().setSiguiente(new Nivel3());
        nivel.getSiguiente().getSiguiente().setBgMusic(clipL3.getClip());
        nivel.getBgMusic().loop(-1);
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
            nivel.showBricks(g);
        } catch (ConcurrentModificationException e) {//Si se elimina un ladrillo, mientras estaba recorriendo los ladrillos
            nivel.showBricks(g);//muestra de nuevo los ladrillos
        }

        if (App.poder != null) {
            Power poder = App.poder;
            if (poder.poder.equals(Poder.Life)) {
                try {
                    BufferedImage bi = ImageIO.read(this.getClass().getResourceAsStream("../dataImages/life.png"));
                    g.drawImage(bi, (int) poder.x, (int) poder.y, this);
                } catch (IOException ex) {
                }
            } else if (poder.poder.equals(Poder.Star)) {
                try {
                    BufferedImage bi = ImageIO.read(this.getClass().getResourceAsStream("../dataImages/star.png"));
                    g.drawImage(bi, (int) poder.x, (int) poder.y, this);
                } catch (IOException ex) {
                }
            }
        }
    }

    public void actualizar() {
        nivel.actualizar(ball, juego, getBounds(), table, this);
        if (balls <= 0 || nivel == null) {
            gameOver();
        }

        if (App.poder != null) {
            Power poder = App.poder;
            poder.y += poder.dy;
            if (App.poder.y == getBounds().height) {
                App.poder = null;
            }
            if (table.getTabla().intersects(new Rectangle2D.Double(poder.x, poder.y, poder.DIAMETRO, poder.DIAMETRO))) {
                if (poder.poder.equals(Poder.Life)) {
                    balls++;
                } else if (poder.poder.equals(Poder.Star)) {
                    score += 200;
                }
                App.poder = null;
            }
        }
        pasoNivel();
        hud();
    }

    //Cuando se pasa un nivel del juego
    private void pasoNivel() {
        if (nivel.longitudArrayLadrillos() == 0) {//Si no quedan ladrillos, pasa al siguiente nivel
            nivel.getBgMusic().close();
            nivel = nivel.getSiguiente();
            nivel.getBgMusic().loop(-1);
            nivel.createBricks();
            table.setX(110);
            ball.setX(160);
            ball.setY(480);
            ball.setCambioX(1);
            ball.setCambioY(-1);
            this.setJuego(false);
            ventana.getHilo().pause();
            ventana.setbPause(false);
            this.setMaxPoderes(5);
        }
    }

    private void gameOver() {
        nivel.getBgMusic().stop();
        PlaySounds Gover = new PlaySounds("src\\dataSounds\\GameOverSound.wav");
        Gover.getClip().start();
        ventana.getGameOver().show();
        ventana.getHilo().stop();
    }

    private void hud() {
        ventana.getBalls().setText(this.balls + "");
        ventana.getScore().setText(this.score + "");
    }

}
