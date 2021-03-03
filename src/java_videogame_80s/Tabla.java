/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_videogame_80s;

import java.awt.event.KeyEvent;

/**
 *
 * @author Edilberto
 */
public class Tabla {

    private int x;//coordenada X de la tabla
    private int y;//coordenada Y de la tabla
    private boolean move;//iterador entre mover o estar quieto

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

    protected void mover(KeyEvent e) {//metodo para mover la barra
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
