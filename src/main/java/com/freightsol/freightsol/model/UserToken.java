package com.freightsol.freightsol.model;

import com.freightsol.freightsol.model.auth.UserAccount;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 * Created by probal on 10/10/17.
 */
@RequestScope
@Component
public class UserToken {

    private Long userId;

    private String name;

    private String email;

    private String phoneNumber;

    private String modules;

    private long issuedOn;

    public UserToken() {
    }

    public UserToken(UserAccount userAccount) {
        this.userId = userAccount.getId();
        this.name = userAccount.getFullName();
        this.email = userAccount.getEmail();
        this.phoneNumber = userAccount.getMobileNumber();
        this.modules = userAccount.getModules();
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getModules() {
        return modules;
    }

    public void setModules(String modules) {
        this.modules = modules;
    }
}
