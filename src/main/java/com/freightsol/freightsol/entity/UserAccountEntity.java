package com.freightsol.freightsol.entity;

import com.freightsol.freightsol.model.auth.UserAccount;
import org.hibernate.validator.constraints.NotBlank;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

/**
 * Created by probal on 11/17/17.
 */
@Entity
@Table(name = "UserAccount",
        indexes = {
            @Index(name="email", columnList = "email", unique = true),
            @Index(name="fullName", columnList = "fullName")
        })
public class UserAccountEntity extends BaseEntity {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    private String fullName;

    private String mobileNumber;

    private String modules;

    private UserAccount convertToModel(final UserAccountEntity userAccountEntity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userAccountEntity, UserAccount.class);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getModules() {
        return modules;
    }

    public void setModules(String modules) {
        this.modules = modules;
    }
}
