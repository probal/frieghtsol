package com.freightsol.freightsol.models;

import org.joda.time.DateTime;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 * Created by probal on 10/10/17.
 */
@RequestScope
@Component
public class UserToken {

    private String name;

    private String email;

    private String phoneNumber;

    private long issuedOn;

    public UserToken() {
    }

    public UserToken(PersonModel pm) {
        this.name = pm.getName();
        this.email = pm.getEmail();
        this.phoneNumber = "1234566";
        DateTime createdOn = new DateTime();
        this.issuedOn = createdOn.getMillis();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
