/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yago
 */
public class TestExtensions {
    
    public TestExtensions() {
    }
    
    @Test
    public void testIsInteger() {
        System.out.println("isInteger");
        String pInput = "1";
        boolean expResult = true;
        boolean result = Extensions.isInteger(pInput);
        assertEquals(expResult, result);
    }

    /**
     * Test of isFloat method, of class Utlis.
     */
    @Test
    public void testIsFloat() {
        System.out.println("isFloat");
        String pInput = "1.2";
        boolean expResult = true;
        boolean result = Extensions.isFloat(pInput);
        assertEquals(expResult, result);
    }
    
}
