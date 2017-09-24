package com.ubs.opsit.interviews;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for MinutesEnum.
 * 
 * @author Rizwan Saeed Shaikh
 *
 */
public class MinutesEnumTest {

    @Test
    public void testOn() {
        
        Assert.assertEquals("Y", MinutesEnum.ON.getSymbol());
    }
    
    @Test
    public void testQuarter() {
        
        Assert.assertEquals("R",MinutesEnum.QUARTER.getSymbol());
    }
    
    @Test
    public void testOff() {
        
        Assert.assertEquals("O",MinutesEnum.OFF.getSymbol());
    }
}
