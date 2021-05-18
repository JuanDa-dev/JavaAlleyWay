/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamecomponents;

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
public class TableTest {

    public TableTest() {
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
     * Test of choque method, of class Table.
     */
    @Test
    public void testChoque() {
        System.out.println("choque");
        Ball bola = new Ball(160, 80);//Como el balon golpea la tabla por arriba
        Table instance = new Table(150, 95);//Se espera que se devuelva por arriba
        String expResult = "up";
        String result = instance.choque(bola);
        assertEquals(expResult, result);
    }

}
