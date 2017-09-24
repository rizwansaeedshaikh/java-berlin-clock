package com.ubs.opsit.interviews;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for HoursEnum.
 * 
 * @author Rizwan Saeed Shaikh
 *
 */
public class HoursEnumTest {

    @Test
    public void testOn() {

        Assert.assertEquals("R", HoursEnum.ON.getSymbol());
    }

    @Test
    public void testOff() {

        Assert.assertEquals("O", HoursEnum.OFF.getSymbol());
    }
}
