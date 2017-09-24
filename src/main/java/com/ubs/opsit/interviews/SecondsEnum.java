package com.ubs.opsit.interviews;

/**
 * Enum restricting the states that seconds bulb can be in.
 * 
 * @author Rizwan Saeed Shaikh
 *
 */
public enum SecondsEnum {

    ON("Y"), OFF("O");

    private String iSymbol;

    public String getSymbol() {
        return iSymbol;
    }

    SecondsEnum(String aSymbol) {
        this.iSymbol = aSymbol;
    }
}
