package com.ubs.opsit.interviews;

/**
 * Enum restricting the states that minutes bulbs can be in.
 * 
 * @author Rizwan Saeed Shaikh
 *
 */
public enum MinutesEnum {

    ON("Y"), QUARTER("R"), OFF("O");

    private String iSymbol;

    public String getSymbol() {
        return iSymbol;
    }

    MinutesEnum(String aSymbol) {
        this.iSymbol = aSymbol;
    }
}
