package com.ubs.opsit.interviews;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for SecondsEnum.
 * 
 * @author Rizwan Saeed Shaikh
 *
 */
public class SecondsEnumTest {

    @Test
    public void testOn() {
        
        Assert.assertEquals("Y", SecondsEnum.ON.getSymbol());
    }
    
    @Test
    public void testOff() {
        
        Assert.assertEquals("O", SecondsEnum.OFF.getSymbol());
    }
}
