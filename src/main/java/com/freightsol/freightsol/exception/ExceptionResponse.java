package com.freightsol.freightsol.exception;


import java.util.List;

/**
 * Created by probal on 10/9/17.
 */
public class ExceptionResponse {

    private String errorCode;
    private String errorMessage;
    private List<String> errors;


    public ExceptionResponse() {
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
