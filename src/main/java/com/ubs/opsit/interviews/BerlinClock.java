package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.utility.Utilities;

import static com.ubs.opsit.interviews.Constants.*;

/**
 * Berlin clock view of specified time. Refer <a href=
 * "https://github.com/rizwansaeedshaikh/java-berlin-clock/blob/master/README.md">README.md</a>
 * for details on Berlin time.
 * 
 * @author Rizwan Saeed Shaikh
 *
 */
public class BerlinClock implements TimeConverter {

    /**
     * Converts time to Berlin clock format.
     * 
     * @param aTime
     *            String representation of the time in hh:MM:ss format.
     * @return specified time converted to Berlin Clock format.
     * @throws IllegalArgumentException
     *             if any of hours, minutes or seconds parts are missing or they
     *             are not numbers.
     */
    @Override
    public String convertTime(String aTime) {

        StringBuilder lBerlinTimeRet = new StringBuilder();

        int[] lTimePartsArray = Utilities.extractHoursMinsSeconds(aTime);

        int lHours = lTimePartsArray[0];
        int lMinutes = lTimePartsArray[1];
        int lSeconds = lTimePartsArray[2];

        return lBerlinTimeRet.append(buildSecondsLine(lSeconds)).append(System.lineSeparator())
                .append(buildHourFirstLine(lHours)).append(System.lineSeparator()).append(buildHourSecondLine(lHours))
                .append(System.lineSeparator()).append(buildMinutesFirstLine(lMinutes)).append(System.lineSeparator())
                .append(buildMinutesSecondLine(lMinutes)).toString();
    }

    /**
     * Generate and return seconds part the Berlin Clock time.
     * 
     * @param aSeconds
     *            int specifying the seconds part of time.
     * @return String containing seconds part of the Berlin Clock time
     */
    public String buildSecondsLine(final int aSeconds) {

        StringBuilder lSecondsBuilder = new StringBuilder();
        if (aSeconds % 2 == 0)
            lSecondsBuilder.append(SecondsEnum.ON.getSymbol());
        else
            lSecondsBuilder.append(SecondsEnum.OFF.getSymbol());

        return lSecondsBuilder.toString();
    }

    /**
     * Generate and return first line of hours part the Berlin Clock time.
     * 
     * @param aHours
     *            int specifying the hours part of time.
     * @return String containing first line of hours part of the Berlin Clock
     *         time
     */
    public String buildHourFirstLine(final int aHours) {

        /**
         * First line of hours lits a lamp for every 5 hours.
         */
        return generateLampStatuses(aHours, WEIGHTAGE_FIRST_LINE_HOURS,
                NO_OF_BULBS_FIRST_LINE_HOURS, HoursEnum.ON.getSymbol(), HoursEnum.OFF.getSymbol());
    }

    /**
     * Generate and return second line of hours part the Berlin Clock time.
     * 
     * @param aHours
     *            int specifying the hours part of time.
     * @return String containing first line of hours part of the Berlin Clock
     *         time
     */
    public String buildHourSecondLine(final int aHours) {

        /**
         * Second line of hours lits a lamp for every hour missed by first line,
         * so hours argument must be aHours % WEIGHTAGE_FIRST_LINE_HOURS i.e
         * aHours % WEIGHTAGE_FIRST_LINE_HOURS % 5
         */
        return generateLampStatuses(aHours % WEIGHTAGE_FIRST_LINE_HOURS, WEIGHTAGE_SECOND_LINE_HOURS,
                NO_OF_BULBS_SECOND_LINE_HOURS, HoursEnum.ON.getSymbol(), HoursEnum.OFF.getSymbol());
    }

    /**
     * Generate and return first line of minutes part the Berlin Clock time.
     * 
     * @param aMinutes
     *            int specifying the minutes part of time.
     * @return String containing first line of minutes part of the Berlin Clock
     *         time
     */
    public String buildMinutesFirstLine(final int aMinutes) {

        StringBuilder lMinutesBuilder = new StringBuilder();
        int lMinutesTemp = aMinutes;

        // build first line of minutes
        for (int lCount = 0; lCount < NO_OF_BULBS_FIRST_LINE_MINUTES; lCount++) {
            lMinutesTemp = lMinutesTemp - WEIGHTAGE_FIRST_LINE_MINUTES;
            if (lMinutesTemp >= 0 && (lCount + 1) % 3 == 0)
                lMinutesBuilder.append(MinutesEnum.QUARTER.getSymbol());
            else if (lMinutesTemp >= 0 && (lCount + 1) % 3 != 0)
                lMinutesBuilder.append(MinutesEnum.ON.getSymbol());
            else
                lMinutesBuilder.append(MinutesEnum.OFF.getSymbol());
        }

        return lMinutesBuilder.toString();
    }

    /**
     * Generate and return second line of minutes part the Berlin Clock time.
     * 
     * @param aMinutes
     *            int specifying the minutes part of time.
     * @return String containing second line of minutes part of the Berlin Clock
     *         time
     */
    public String buildMinutesSecondLine(final int aMinutes) {

        /**
         * Second line of minutes lits a lamp for every minute missed by first line,
         * so minutes argument must be aMinutes % WEIGHTAGE_FIRST_LINE_HOURS i.e
         * aHours % WEIGHTAGE_FIRST_LINE_HOURS % 5
         */
        return generateLampStatuses(aMinutes % WEIGHTAGE_FIRST_LINE_MINUTES, WEIGHTAGE_SECOND_LINE_MINUTES,
                NO_OF_BULBS_SECOND_LINE_MINUTES, MinutesEnum.ON.getSymbol(), MinutesEnum.OFF.getSymbol());
    }

    private String generateLampStatuses(final int aTime, final int aWeightageOfEachLamp, final int aNoOfLamps,
            String aOnSymbol, String aOffSymbol) {

        /**
         * Mutable and non - synchronized StringBuilder object to hold lamp
         * status (on / off)
         */
        StringBuilder lLampStatuses = new StringBuilder();

        /**
         * Keep subtracting the weightage of each lamp from aTime argument,
         * unless result becomes negative. At which point remaining lamps can be
         * turned off. After each subtraction, if result is positive turn on the
         * subsequent bulb else turn it off.
         */
        for (int lCount = 0; lCount < aNoOfLamps; lCount++) {
            lLampStatuses = aTime - (aWeightageOfEachLamp * (lCount + 1)) >= 0 ? lLampStatuses.append(aOnSymbol)
                    : lLampStatuses.append(aOffSymbol);
        }

        return lLampStatuses.toString();
    }
}
