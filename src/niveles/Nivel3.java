/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niveles;

import gamecomponents.Brick;
import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Edilberto
 */
public class Nivel3 extends Nivel {

    @Override
    public void createBricks() {
        gorra();
        cabeza();
        torso();
        piernas();
        colores();
    }

    //Dibujo la gorra
    private void gorra() {
        int n = 6;
        Color color = new Color(233, 129, 233);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                this.getBricks().add(new Brick(506 - 62 * j, 20 + 17 * i, color));
            }
            n += 2;
        }
    }

    //Dibujo de la cabeza
    private void cabeza() {
        int n = 3;
        Color color = new Color(202, 40, 202);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < n; j++) {
                if (382 + 62 * j > 444) {
                    color = new Color(255, 255, 32);
                }
                this.getBricks().add(new Brick(382 + 62 * j, 54 + 17 * i, color));
                color = new Color(202, 40, 202);
                if (i >= 2) {
                    if (i == 4) {
                        color = new Color(255, 255, 32);
                    }
                    this.getBricks().add(new Brick(72, 54 + 17 * i, color));
                }
                this.getBricks().add(new Brick(382 - 62 * (j + 1), 54 + 17 * i, color));
            }
            if (n < 4) {
                n++;
            }
        }
        n = 7;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 && j != 4 && j != 5) || j == n - 1) {
                    color = new Color(255, 255, 32);
                }
                this.getBricks().add(new Brick(134 + 62 * j, 139 + 17 * i, color));
                color = new Color(202, 40, 202);
            }
            n--;
        }
    }

    //Dibujo del torso
    private void torso() {
        int n = 3;
        Color color = new Color(202, 40, 202);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 3 && j < n - 2) {
                    this.getBricks().add(new Brick(382 + 62 * j, 190 + 17 * i, new Color(255, 255, 32)));
                    this.getBricks().add(new Brick(258 - 62 * j, 190 + 17 * i, new Color(255, 255, 32)));
                } else {
                    this.getBricks().add(new Brick(382 + 62 * j, 190 + 17 * i, color));
                    this.getBricks().add(new Brick(258 - 62 * j, 190 + 17 * i, color));
                }
            }
            if (190 + 17 * i > 207) {
                this.getBricks().add(new Brick(320, 190 + 17 * i, new Color(255, 255, 32)));
            } else {
                this.getBricks().add(new Brick(320, 190 + 17 * i, new Color(233, 129, 233)));
            }
            if (n < 5) {
                n++;
            }
        }
        this.getBricks().add(new Brick(258, 173, color));
        this.getBricks().add(new Brick(320, 173, color));
        this.getBricks().add(new Brick(382, 173, color));
    }

    //Dibujo de las piernas
    private void piernas() {
        Color color = null;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                //Pies
                color = new Color(233, 129, 233);
                this.getBricks().add(new Brick(10 + 62 * j, 326 + 17 * i, color));
                this.getBricks().add(new Brick(444 + 62 * j, 326 + 17 * i, color));
                if (i == 1 && j == 3) {
                    break;
                }
                //Rodillas
                this.getBricks().add(new Brick(10 + 62 * (j + 1), 292 + 17 * i, new Color(255, 255, 32)));
                this.getBricks().add(new Brick(630 - 62 * (j + 1), 292 + 17 * i, new Color(255, 255, 32)));
            }
        }
    }

    //Establezco los colore
    private void colores() {
        amarillo();
        morado();
        moradoClaro();
    }

    private void amarillo() {
        this.getBricks().get(17).setColor(new Color(255, 255, 32));
        this.getBricks().get(23).setColor(new Color(255, 255, 32));
        this.getBricks().get(53).setColor(new Color(255, 255, 32));
        this.getBricks().get(14).setColor(new Color(255, 255, 32));
        this.getBricks().get(16).setColor(new Color(255, 255, 32));
        this.getBricks().get(20).setColor(new Color(255, 255, 32));
        this.getBricks().get(22).setColor(new Color(255, 255, 32));
        this.getBricks().get(28).setColor(new Color(255, 255, 32));
        this.getBricks().get(40).setColor(new Color(255, 255, 32));
        this.getBricks().get(77).setColor(new Color(255, 255, 32));
        this.getBricks().get(80).setColor(new Color(255, 255, 32));
        this.getBricks().get(84).setColor(new Color(255, 255, 32));
        this.getBricks().get(87).setColor(new Color(255, 255, 32));
        this.getBricks().get(94).setColor(new Color(255, 255, 32));
        this.getBricks().get(95).setColor(new Color(255, 255, 32));
        this.getBricks().get(98).setColor(new Color(255, 255, 32));
        this.getBricks().get(105).setColor(new Color(255, 255, 32));
        this.getBricks().get(106).setColor(new Color(255, 255, 32));
        this.getBricks().get(109).setColor(new Color(255, 255, 32));
        this.getBricks().get(122).setColor(new Color(255, 255, 32));
        this.getBricks().get(133).setColor(new Color(255, 255, 32));
    }

    private void morado() {
        this.getBricks().get(55).setColor(new Color(202, 40, 202));
    }

    private void moradoClaro() {
        this.getBricks().get(78).setColor(new Color(233, 129, 233));
        this.getBricks().get(79).setColor(new Color(233, 129, 233));
        this.getBricks().get(81).setColor(new Color(233, 129, 233));
        this.getBricks().get(82).setColor(new Color(233, 129, 233));
        this.getBricks().get(85).setColor(new Color(233, 129, 233));
        this.getBricks().get(86).setColor(new Color(233, 129, 233));
        this.getBricks().get(88).setColor(new Color(233, 129, 233));
        this.getBricks().get(89).setColor(new Color(233, 129, 233));
        this.getBricks().get(90).setColor(new Color(233, 129, 233));
        this.getBricks().get(91).setColor(new Color(233, 129, 233));
        this.getBricks().get(97).setColor(new Color(233, 129, 233));
        this.getBricks().get(108).setColor(new Color(233, 129, 233));
    }

    @Override
    public void cambioColores() {
        Random random = new Random();
        Color color = this.getBricks().get(0).getColor();
        Color colorRandom = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        Color color2 = this.getBricks().get(22).getColor();
        Color colorRandom2 = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        Color color3 = this.getBricks().get(55).getColor();
        Color colorRandom3 = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        for (Brick brick : this.getBricks()) {
            if (brick.getColor().equals(color)) {
                brick.setColor(colorRandom);
            } else if (brick.getColor().equals(color2)) {
                brick.setColor(colorRandom2);
            } else if (brick.getColor().equals(color3)) {
                brick.setColor(colorRandom3);
            }
        }
    }

}
