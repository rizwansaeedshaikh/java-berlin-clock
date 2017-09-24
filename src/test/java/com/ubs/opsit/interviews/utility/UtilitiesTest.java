package com.ubs.opsit.interviews.utility;

import org.junit.Assert;
import org.junit.Test;

import com.ubs.opsit.interviews.utility.Utilities;

/**
 * Test class for Utilities
 * 
 * @author Rizwan Saeed Shaikh
 *
 */
public class UtilitiesTest {

    @Test
    public void testExtractHoursMinsSecondsSunnyDay() {

        int[] lTimePartsIntArray = Utilities.extractHoursMinsSeconds("14:15:03");
        Assert.assertEquals(lTimePartsIntArray[0], 14);
        Assert.assertEquals(lTimePartsIntArray[1], 15);
        Assert.assertEquals(lTimePartsIntArray[2], 03);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMissingTimeParts() {
        
        Utilities.extractHoursMinsSeconds("12:23");
    }

    // check for message later if possible
    @Test(expected = IllegalArgumentException.class)
    public void testExtractHoursMinsSecondsInvalidHour() {

        Utilities.extractHoursMinsSeconds("0w:15:03");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExtractHoursMinsSecondsInvalidMinute() {

        Utilities.extractHoursMinsSeconds("4:1g:04");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExtractHoursMinsSecondsInvalidSecond() {

        Utilities.extractHoursMinsSeconds("4:11:d4");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSecondsOutOfRange() {
        
        Utilities.extractHoursMinsSeconds("4:5:60");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSecondsNegative() {
        
        Utilities.extractHoursMinsSeconds("4:5:-1");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMinutesOutOfRange() {
        
        Utilities.extractHoursMinsSeconds("4:61:0");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMinutesNegative() {
        
        Utilities.extractHoursMinsSeconds("4:-1:1");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testHoursOutOfRange() {
        
        Utilities.extractHoursMinsSeconds("25:25:0");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testHoursNegative() {
        
        Utilities.extractHoursMinsSeconds("-1:56:1");
    }
}
