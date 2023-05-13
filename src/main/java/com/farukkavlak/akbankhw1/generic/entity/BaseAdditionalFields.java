package com.farukkavlak.akbankhw1.generic.entity;/*
Created by farukkavlak on 12.05.2023
@author: farukkavlak
@date: 12.05.2023
@project: akbank-hw1
*/

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Embeddable
public class BaseAdditionalFields {
    @Column(
            name = "CREATE_DATE",
            updatable = false
    )
    @CreatedDate
    private Date createDate;
    @Column(
            name = "UPDATE_DATE"
    )
    @LastModifiedDate
    private Date updateDate;

    public BaseAdditionalFields() {
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setCreateDate(final Date createDate) {
        this.createDate = createDate;
    }

    public void setUpdateDate(final Date updateDate) {
        this.updateDate = updateDate;
    }
}