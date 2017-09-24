package com.ubs.opsit.interviews.utility;


/**
 * <b>Final, non-instantiable</b> class containing commonly needed utilities.
 * 
 * @author Rizwan Saeed Shaikh
 */
public final class Utilities {

	/**
	 * Utilities class need not be instantiated. Hence the private modifier.
	 */
	private Utilities() {}

	/**
	 * @param aTime
	 *            String containing time in format hh:MM:ss.
	 * @return int[] containing hours, minutes and seconds part in the first
	 *         second and third position respectively
	 * @throws IllegalArgumentException
	 *             if any of hours, minutes or seconds parts are missing or they
	 *             are not numbers.
	 */
	public static int[] extractHoursMinsSeconds(String aTime) {

		/*
		 * Declare and initialize an String array for holding hours, minutes and
		 * seconds.
		 */
		String[] lTimePartsArray = aTime.split(":");

		if (lTimePartsArray.length != 3) {
			throw new IllegalArgumentException("Invalid time. " + aTime
					+ " Expected format hh:MM:ss. Where hh: hours, MM: minutes and ss: seconds.");
		}

		/*
		 * Declare and initialize an integer array of size 3 for holding hours,
		 * minutes and seconds.
		 */
		int[] lTimePartsIntArray = new int[3];

		/*
		 * Hours minutes and seconds can now be extracted without worrying about
		 * ArrayIndexOutOfBoundsException. Still NumberFormatException can
		 * occur.
		 */
		try {
			lTimePartsIntArray[0] = Integer.parseInt(lTimePartsArray[0]);
			lTimePartsIntArray[1] = Integer.parseInt(lTimePartsArray[1]);
			lTimePartsIntArray[2] = Integer.parseInt(lTimePartsArray[2]);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Invalid Time. " + aTime + " contains non-numerical characters.");
		}
		
		if(lTimePartsIntArray[0] < 0 || lTimePartsIntArray[0] > 24) {
		    throw new IllegalArgumentException("Invalid hour " + lTimePartsIntArray[0] + " . Hour must be between 0 and 24 inclusive.");
		}
		
		if(lTimePartsIntArray[1] < 0 || lTimePartsIntArray[1] > 59) {
                    throw new IllegalArgumentException("Invalid minute " + lTimePartsIntArray[1] + " . Minute must be between 0 and 24 inclusive.");
                }
		
		if(lTimePartsIntArray[2] < 0 || lTimePartsIntArray[2] > 59) {
                    throw new IllegalArgumentException("Invalid second " + lTimePartsIntArray[2] + " . Second must be between 0 and 24 inclusive.");
                }

		return lTimePartsIntArray;
	}
}
