package com.freightsol.freightsol.model.auth;

import com.freightsol.freightsol.entity.UserRoleEntity;

/**
 * Created by probal on 11/17/17.
 */
public class UserRole {

    private Long id;

    private String name;

    private String description;

    public UserRole() {
    }

    public UserRole(UserRoleEntity userRoleEntity) {
        this.id = userRoleEntity.getId();
        this.name = userRoleEntity.getName();
        this.description = userRoleEntity.getDescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
