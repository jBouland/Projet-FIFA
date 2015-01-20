/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fifa.packVue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joris
 */
public class MonModelTableTest {
    
    public MonModelTableTest() {
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
     * Test of setValueAt method, of class MonModelTable.
     */
    @Test
    public void testSetValueAt() {
        System.out.println("setValueAt");
        Object o = null;
        int i = 0;
        int i1 = 0;
        MonModelTable instance = null;
        instance.setValueAt(o, i, i1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of testValeur method, of class MonModelTable.
     */
    @Test
    public void testTestValeur() {
        System.out.println("testValeur");
        String val = "";
        MonModelTable instance = null;
        boolean expResult = false;
        boolean result = instance.testValeur(val);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isNumeric method, of class MonModelTable.
     */
    @Test
    public void testIsNumeric() {
        System.out.println("isNumeric");
        String str = "";
        boolean expResult = false;
        boolean result = MonModelTable.isNumeric(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isCellEditable method, of class MonModelTable.
     */
    @Test
    public void testIsCellEditable() {
        System.out.println("isCellEditable");
        int i = 0;
        int i1 = 0;
        MonModelTable instance = null;
        boolean expResult = false;
        boolean result = instance.isCellEditable(i, i1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueAt method, of class MonModelTable.
     */
    @Test
    public void testGetValueAt() {
        System.out.println("getValueAt");
        int row = 0;
        int column = 0;
        MonModelTable instance = null;
        Object expResult = null;
        Object result = instance.getValueAt(row, column);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRowCount method, of class MonModelTable.
     */
    @Test
    public void testGetRowCount() {
        System.out.println("getRowCount");
        MonModelTable instance = null;
        int expResult = 0;
        int result = instance.getRowCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnCount method, of class MonModelTable.
     */
    @Test
    public void testGetColumnCount() {
        System.out.println("getColumnCount");
        MonModelTable instance = null;
        int expResult = 0;
        int result = instance.getColumnCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnName method, of class MonModelTable.
     */
    @Test
    public void testGetColumnName() {
        System.out.println("getColumnName");
        int column = 0;
        MonModelTable instance = null;
        String expResult = "";
        String result = instance.getColumnName(column);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeLigne method, of class MonModelTable.
     */
    @Test
    public void testRemoveLigne() {
        System.out.println("removeLigne");
        int index = 0;
        MonModelTable instance = null;
        instance.removeLigne(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
