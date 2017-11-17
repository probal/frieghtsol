package com.freightsol.freightsol.exception;

/**
 * Created by probal on 11/17/17.
 */
public class DataBaseException extends RuntimeException {
    private String resourceIdentifier;

    public DataBaseException(String resourceIdentifier, String message) {
        super(message);
        this.resourceIdentifier = resourceIdentifier;
    }
}
