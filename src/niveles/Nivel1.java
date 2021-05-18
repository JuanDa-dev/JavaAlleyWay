/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niveles;

import gamecomponents.Brick;
import gamecomponents.GameSpace;
import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Edilberto
 */
public class Nivel1 extends Nivel {

    @Override
    public void createBricks() {
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
                this.añadirLadrillo(new Brick(10 + 62 * j, 20 + 17 * i + salto, color));
            }
        }
    }

    //cambio los colores de todos los ladrillos
    @Override
    public void cambioColores() {
        if (this.longitudArrayLadrillos() == 88) {
            int n = 22;
            for (int i = 0; i < 4; i++) {
                Random random = new Random();
                int red = random.nextInt(256);//Genera un numero aleatorio entre 0 - 255
                int green = random.nextInt(256);
                int blue = random.nextInt(256);
                Color color = new Color(red, green, blue);//Establezco el nuevo color
                for (int j = n - 22; j < n; j++) {
                    this.getBrick(j).setColor(color);
                }
                n += 22;
            }
        }
    }

}
