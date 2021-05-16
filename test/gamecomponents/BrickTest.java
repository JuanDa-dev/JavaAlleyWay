/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecomponents;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
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
public class BrickTest {

    public BrickTest() {
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
     * Test of choque method, of class Brick.
     */
    @Test
    public void testChoque() {
        System.out.println("choque");
        Ball bola = new Ball(160, 40, null);
        Brick instance = new Brick(175, 40, null);
        String expResult = "left";
        String result = instance.choque(bola);
        assertEquals(expResult, result);
    }

    /**
     * Test of generarPoder method, of class Brick.
     */
    @Test
    public void testGenerarPoder() {
        System.out.println("generarPoder");
        Brick instance = new Brick(175, 50, Color.red);
        Poder expResult = Poder.Life;
        Poder result = instance.generarPoder().poder;
        assertEquals(expResult, result);
    }

}
