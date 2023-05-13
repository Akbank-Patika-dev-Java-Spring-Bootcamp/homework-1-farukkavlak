package com.farukkavlak.akbankhw1.generic.service;/*
Created by farukkavlak on 12.05.2023
@author: farukkavlak
@date: 12.05.2023
@project: akbank-hw1
*/

import com.farukkavlak.akbankhw1.generic.entity.BaseAdditionalFields;
import com.farukkavlak.akbankhw1.generic.entity.BaseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public abstract class BaseEntityService<E extends BaseEntity, D extends JpaRepository<E,Long>> {

    private final D dao;

    public Collection<E> findAll() {
        try {
            return this.dao.findAll();
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public E findById(Long id) {
        try{
            Optional<E> entity = this.dao.findById(id);
            if (entity.isPresent()) {
                return entity.get();
            } else {
                throw new RuntimeException("Entity not found");
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public E save(E entity) {
        this.setAdditionalFields(entity);
        try {
            return this.dao.save(entity);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private void setAdditionalFields(E entity) {
        BaseAdditionalFields baseAdditionalFields = entity.getBaseAdditionalFields();
        if (baseAdditionalFields == null) {
            baseAdditionalFields = new BaseAdditionalFields();
            entity.setBaseAdditionalFields(baseAdditionalFields);
        }

        if (entity.getBaseAdditionalFields().getCreateDate() == null) {
            baseAdditionalFields.setCreateDate(new Date());
        }

        baseAdditionalFields.setUpdateDate(new Date());
    }

    public void delete(E e) {
        this.dao.delete(e);
    }

    public D getDao() {
        return this.dao;
    }

}
