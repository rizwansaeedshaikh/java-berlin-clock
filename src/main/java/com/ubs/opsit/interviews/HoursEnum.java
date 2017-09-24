package com.ubs.opsit.interviews;

/**
 * Enum restricting the states that hours bulbs can be in.
 * 
 * @author Rizwan Saeed Shaikh
 *
 */
public enum HoursEnum {

    ON("R"), OFF("O");

    private String iSymbol;

    public String getSymbol() {
        return iSymbol;
    }

    HoursEnum(String aSymbol) {
        this.iSymbol = aSymbol;
    }
}
