package com.freightsol.freightsol.exception;

/**
 * Created by probal on 10/9/17.
 */
public class ResourceNotFoundException extends RuntimeException {

    private String resourceIdentifier;

    public ResourceNotFoundException(String resourceIdentifier, String message) {
        super(message);
        this.resourceIdentifier = resourceIdentifier;
    }
}
