package java_videogame_80s.gamecomponents;

import java.awt.event.KeyEvent;

public class Tabla {

    private int x;//coordenada X de la tabla
    private int y;//coordenada Y de la tabla
    private boolean move;

    public Tabla(int x, int y) {//Recibe las coordenadas X y Y de la tabla
        this.x = x;
        this.y = y;
        move = true;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setMove(boolean move) {
        this.move = move;
    }

    public boolean isMove() {
        return move;
    }

    public void mover(KeyEvent e) {//metodo para mover la barra
        if (move) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (x < 330) {
                    x += 5;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (x > 0) {
                    x -= 5;
                }
            }
        }
    }

}
