package com.farukkavlak.akbankhw1.generic.entity;/*
Created by farukkavlak on 12.05.2023
@author: farukkavlak
@date: 12.05.2023
@project: akbank-hw1
*/

import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    @Embedded
    private BaseAdditionalFields baseAdditionalFields;

    public BaseEntity() {
    }

    public BaseAdditionalFields getBaseAdditionalFields() {
        return this.baseAdditionalFields;
    }

    public void setBaseAdditionalFields(final BaseAdditionalFields baseAdditionalFields) {
        this.baseAdditionalFields = baseAdditionalFields;
    }
}
