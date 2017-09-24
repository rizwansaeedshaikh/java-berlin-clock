package com.ubs.opsit.interviews;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link BerlinClock}
 * 
 * @author Rizwan Saeed Shaikh
 *
 */
public class BerlinClockTest {

    private BerlinClock iBerlinClock = new BerlinClock();

    @Test
    public void testMidnight() {

        String lMidnightTime = iBerlinClock.convertTime("24:00:00");
        String lExpectedTime = "Y" + System.lineSeparator() + "RRRR" + System.lineSeparator() + "RRRR"
                + System.lineSeparator() + "OOOOOOOOOOO" + System.lineSeparator() + "OOOO";
        Assert.assertEquals(lExpectedTime, lMidnightTime);
    }

    @Test
    public void testJustBeforetMidnight() {

        String lJustBeforeMidnightTime = iBerlinClock.convertTime("23:59:59");
        String lExpectedTime = "O" + System.lineSeparator() + "RRRR" + System.lineSeparator() + "RRRO"
                + System.lineSeparator() + "YYRYYRYYRYY" + System.lineSeparator() + "YYYY";
        Assert.assertEquals(lExpectedTime, lJustBeforeMidnightTime);
    }

    @Test
    public void testMiddleOfAfternoon() {

        String lMiddleOfAfternoonTime = iBerlinClock.convertTime("13:17:01");
        String lExpectedTime = "O" + System.lineSeparator() + "RROO" + System.lineSeparator() + "RRRO"
                + System.lineSeparator() + "YYROOOOOOOO" + System.lineSeparator() + "YYOO";

        Assert.assertEquals(lExpectedTime, lMiddleOfAfternoonTime);
    }

    @Test
    public void testMidnightInAnotherFormat() {

        String lMidnightTime = iBerlinClock.convertTime("00:00:00");
        String lExpectedTime = "Y" + System.lineSeparator() + "OOOO" + System.lineSeparator() + "OOOO"
                + System.lineSeparator() + "OOOOOOOOOOO" + System.lineSeparator() + "OOOO";
        Assert.assertEquals(lExpectedTime, lMidnightTime);
    }

    // Seconds lamp must blink on / off every 2 seconds.
    @Test
    public void testSecondsLampBlinksEveryTwoSeconds() {

        /**
         * If it blinks on / off every 2 seconds, it changes its state every
         * second.
         */
        String secondsLampAtASecond = iBerlinClock.buildSecondsLine(11);
        String secondsLampAtNextSecond = iBerlinClock.buildSecondsLine(12);
        Assert.assertNotEquals(secondsLampAtASecond, secondsLampAtNextSecond);

        /**
         * Accordingly it must also toggle at the last and first second.
         */
        secondsLampAtASecond = iBerlinClock.buildSecondsLine(59);
        secondsLampAtNextSecond = iBerlinClock.buildSecondsLine(0);
        Assert.assertNotEquals(secondsLampAtASecond, secondsLampAtNextSecond);
    }

    // Seconds lamp has 1 bulb
    @Test
    public void testNumberOfLampsInSecondsLine() {

        Assert.assertEquals(1, iBerlinClock.buildSecondsLine(0).length());
    }

    /**
     * Test valid boundary values of seconds. Invalid boundaries are covered in
     * UtilitiesTest.
     */
    @Test
    public void testBuildSecondLinesBoundaries() { //

        Assert.assertEquals(SecondsEnum.OFF.getSymbol(), iBerlinClock.buildSecondsLine(59));
        Assert.assertEquals(SecondsEnum.ON.getSymbol(), iBerlinClock.buildSecondsLine(0));
    }

    // First line of hours should have 4 lamps
    @Test
    public void testNumberOfLampsInHoursFirstLine() {

        // boundary hour
        Assert.assertEquals(4, iBerlinClock.buildHourFirstLine(23).length());

        // median hour
        Assert.assertEquals(4, iBerlinClock.buildHourFirstLine(12).length());

        // boundary hour
        Assert.assertEquals(4, iBerlinClock.buildHourFirstLine(0).length());
    }

    // Second line of hours should have 4 lamps
    @Test
    public void testNumberOfLampsInHoursSecondLine() {

        // boundary hour
        Assert.assertEquals(4, iBerlinClock.buildHourSecondLine(23).length());

        // median hour
        Assert.assertEquals(4, iBerlinClock.buildHourSecondLine(12).length());

        // boundary hour
        Assert.assertEquals(4, iBerlinClock.buildHourSecondLine(0).length());
    }

    // First line of hours should lit a red lamp for every 5 hours.
    @Test
    public void testBuildHourFirstLine() {

        Assert.assertEquals("OOOO", iBerlinClock.buildHourFirstLine(0));
        Assert.assertEquals("OOOO", iBerlinClock.buildHourFirstLine(1));
        Assert.assertEquals("ROOO", iBerlinClock.buildHourFirstLine(5));
        Assert.assertEquals("ROOO", iBerlinClock.buildHourFirstLine(6));
        Assert.assertEquals("ROOO", iBerlinClock.buildHourFirstLine(9));
        Assert.assertEquals("RROO", iBerlinClock.buildHourFirstLine(10));
        Assert.assertEquals("RROO", iBerlinClock.buildHourFirstLine(12));
        Assert.assertEquals("RRRO", iBerlinClock.buildHourFirstLine(19));
        Assert.assertEquals("RRRR", iBerlinClock.buildHourFirstLine(24));
    }

    /*
     * Second line of hours should lit a red lamp for every hour missed by first
     * line.
     */
    @Test
    public void testBuildHourSecondLine() {

        Assert.assertEquals("OOOO", iBerlinClock.buildHourSecondLine(0));
        Assert.assertEquals("ROOO", iBerlinClock.buildHourSecondLine(1));
        Assert.assertEquals("OOOO", iBerlinClock.buildHourSecondLine(5));
        Assert.assertEquals("ROOO", iBerlinClock.buildHourSecondLine(6));
        Assert.assertEquals("RRRO", iBerlinClock.buildHourSecondLine(8));
        Assert.assertEquals("RRRR", iBerlinClock.buildHourSecondLine(9));
        Assert.assertEquals("OOOO", iBerlinClock.buildHourSecondLine(10));
        Assert.assertEquals("RROO", iBerlinClock.buildHourSecondLine(12));
        Assert.assertEquals("RRRR", iBerlinClock.buildHourSecondLine(19));
        Assert.assertEquals("RRRR", iBerlinClock.buildHourSecondLine(24));
    }

    // First line of minutes must have 11 bulbs
    @Test
    public void testNumberIfLampsInMinutesFirstLine() {

        // boundary minute
        Assert.assertEquals(11, iBerlinClock.buildMinutesFirstLine(0).length());

        // median minute
        Assert.assertEquals(11, iBerlinClock.buildMinutesFirstLine(30).length());

        // boundary minute
        Assert.assertEquals(11, iBerlinClock.buildMinutesFirstLine(59).length());
    }

    // Second line of minutes must have 4 bulbs
    @Test
    public void testNumberOfLampsInMinutesSecondLine() {

        // boundary minute
        Assert.assertEquals(4, iBerlinClock.buildMinutesSecondLine(0).length());

        // median minute
        Assert.assertEquals(4, iBerlinClock.buildMinutesSecondLine(30).length());

        // boundary minute
        Assert.assertEquals(4, iBerlinClock.buildMinutesSecondLine(59).length());
    }

    /**
     * Minutes line must lit a yellow lamp for every 5 minutes with 3rd, 6th and
     * 9th lamp being red.
     */
    @Test
    public void testBuildMinutesFirstLine() {
        
        Assert.assertEquals("OOOOOOOOOOO", iBerlinClock.buildMinutesFirstLine(0));
        Assert.assertEquals("OOOOOOOOOOO", iBerlinClock.buildMinutesFirstLine(1));
        Assert.assertEquals("YOOOOOOOOOO", iBerlinClock.buildMinutesFirstLine(5));
        Assert.assertEquals("YOOOOOOOOOO", iBerlinClock.buildMinutesFirstLine(6));
        Assert.assertEquals("YYROOOOOOOO", iBerlinClock.buildMinutesFirstLine(17));
        Assert.assertEquals("YYROOOOOOOO", iBerlinClock.buildMinutesFirstLine(15));
        Assert.assertEquals("YYRYYROOOOO", iBerlinClock.buildMinutesFirstLine(30));
        Assert.assertEquals("YYRYYROOOOO", iBerlinClock.buildMinutesFirstLine(31));
        Assert.assertEquals("YYRYYRYYRYY", iBerlinClock.buildMinutesFirstLine(59));
        Assert.assertEquals("YYRYYRYYRYO", iBerlinClock.buildMinutesFirstLine(54));
        
    }
    
    /**
     * Minutes line must lit a yellow lamp for every lamp missed by the first line
     */
    @Test
    public void testBuildMinutesSecondLine() {
        
        Assert.assertEquals("OOOO", iBerlinClock.buildMinutesSecondLine(0));
        Assert.assertEquals("YOOO", iBerlinClock.buildMinutesSecondLine(1));
        Assert.assertEquals("OOOO", iBerlinClock.buildMinutesSecondLine(5));
        Assert.assertEquals("YYOO", iBerlinClock.buildMinutesSecondLine(7));
        Assert.assertEquals("YYYO", iBerlinClock.buildMinutesSecondLine(8));
        Assert.assertEquals("OOOO", iBerlinClock.buildMinutesSecondLine(15));
        Assert.assertEquals("OOOO", iBerlinClock.buildMinutesSecondLine(30));
        Assert.assertEquals("YOOO", iBerlinClock.buildMinutesSecondLine(31));
        Assert.assertEquals("YYYY", iBerlinClock.buildMinutesSecondLine(59));
        Assert.assertEquals("YYYY", iBerlinClock.buildMinutesSecondLine(24));
        
    }

}
