/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecomponents;

import interfaces.ControlInterface;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.LinkedList;
import niveles.Nivel;
import niveles.Nivel1;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Edilberto
 */
public class BallTest {

    public BallTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of mover method, of class Ball.
     */
    @Test
    public void testMover() {
        System.out.println("mover");
        boolean mover = true;//Se puede mover la bola
        GameSpace g = new GameSpace(new ControlInterface());//Panel de juego
        Rectangle limites = new Rectangle(0, 0, 200, 400);//Limites del juego
        Table tabla = new Table(160, 80);
        LinkedList<Brick> ladrillos = new LinkedList<>();
        Nivel nivel = new Nivel1(g);
        nivel.createBricks();//Creo los ladrillos
        //Añado los ladrillos
        for (int i = 0; i < nivel.longitudArrayLadrillos(); i++) {
            ladrillos.add(nivel.getBrick(i));
        }
        Ball instance = new Ball(180, 65, g);
        instance.mover(mover, limites, tabla, ladrillos);
        int resultadoEsperado = 64;
        int resultadoObtenido = instance.getY();
        assertEquals(resultadoEsperado, resultadoObtenido);
    }

}
