package com.freightsol.freightsol.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by probal on 11/17/17.
 */
@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected Long id;

    protected Date createdDate;

    protected Date modifiedDate;

    protected Long createdBy;

    protected Long updatedBy;

    @Version
    private long version;

    @PrePersist
    public void prePersist() {
        this.createdDate = (createdDate == null) ? new Date() : createdDate;
        this.modifiedDate = new Date();
    }

    //TODO: Is it covered already in prePersist()
    @PreUpdate
    public void preUpdate() {
        this.modifiedDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }
}
