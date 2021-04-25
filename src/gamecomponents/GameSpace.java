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

    private int balls, score;
    private Ball ball = new Ball(160, 480, this);
    private final Table table = new Table(110, 530);
    private Nivel nivel;
    private boolean juego;
    private ControlInterface ventana;
    private Clip BgMusic;

    public GameSpace(ControlInterface ventana) {
        PlaySounds clip = new PlaySounds("src\\dataSounds\\BackgroundMusic.wav");
        this.BgMusic = clip.getClip();
        BgMusic.loop(-1);
        this.setBackground(Color.darkGray);
        balls = 3;
        score = 0;
        this.ventana = ventana;
        juego = false;
        niveles();
    }

    public Clip getBgMusic() {
        return BgMusic;
    }

    public Table getTable() {
        return table;
    }

    public Ball getBall() {
        return ball;
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

    public void niveles() {
        nivel = new Nivel1();
        nivel.createBricks();
        nivel.setSiguiente(new Nivel2());
        nivel.getSiguiente().setSiguiente(new Nivel3());
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
        
        if(App.poder!=null){
            Power poder=App.poder;
            if (poder instanceof Life) {
                try {
                    BufferedImage bi = ImageIO.read(this.getClass().getResourceAsStream("../dataImages/life.png"));
                    g.drawImage(bi, (int) (((Life) poder).x), (int) ((Life) poder).y, this);
                } catch (IOException ex) {
                }
            } else if (poder instanceof Star) {
                try {
                    BufferedImage bi = ImageIO.read(this.getClass().getResourceAsStream("../dataImages/star.png"));
                    g.drawImage(bi, (int) (((Star) poder).x), (int) ((Star) poder).y, this);
                } catch (IOException ex) {
                }
            }
        }
    }

    public void actualizar() {
        ball.mover(juego, getBounds(), table, nivel.getBricks());
        table.mover(getBounds());
        if (balls <= 0 || nivel.getSiguiente() == null) {
            gameOver();
        }

        if (App.poder != null) {
            Power poder=App.poder;
            poder.y += poder.dy;
            if (App.poder.y == getBounds().height) {
                App.poder=null;
            }
            if (table.getTabla().intersects(new Rectangle2D.Double(poder.x, poder.y, poder.DIAMETRO, poder.DIAMETRO))) {
                if(poder instanceof Life){
                    balls++;
                }else if(poder instanceof Star){
                    score+=200;
                }
                App.poder=null;
            }
        }
        pasoNivel();
        hud();
    }

    //Cuando se pasa un nivel del juego
    private void pasoNivel() {
        if (nivel.getBricks().isEmpty()) {//Si no quedan ladrillos, pasa al siguiente nivel
            nivel = nivel.getSiguiente();
            nivel.createBricks();
            table.setX(110);
            ball.setX(160);
            ball.setY(480);
            ball.setCambioX(1);
            ball.setCambioY(-1);
            this.setJuego(false);
            ventana.getHilo().pause();
            ventana.setbPause(false);
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
