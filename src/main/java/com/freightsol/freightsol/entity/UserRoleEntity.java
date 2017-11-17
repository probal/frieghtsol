package com.freightsol.freightsol.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * Created by probal on 11/17/17.
 */
@Entity
@Table(name = "UserRole")
public class UserRoleEntity extends BaseEntity {

    @NotBlank
    private String name;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
