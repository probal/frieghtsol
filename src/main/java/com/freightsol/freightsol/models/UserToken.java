package com.freightsol.freightsol.models;

import org.joda.time.DateTime;

/**
 * Created by probal on 10/10/17.
 */
public class UserToken {

    private String fullName;

    private String email;

    private String phoneNumber;

    private long issuedOn;

    public UserToken() {
    }

    public UserToken(PersonModel pm) {
        this.fullName = pm.getFirstName();
        this.email = pm.getEmail();
        this.phoneNumber = pm.getPhoneNumber();
        DateTime createdOn = new DateTime();
        this.issuedOn = createdOn.getMillis();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getIssuedOn() {
        return issuedOn;
    }

    public void setIssuedOn(long issuedOn) {
        this.issuedOn = issuedOn;
    }
}
