package com.farukkavlak.akbankhw1.entity;/*
Created by farukkavlak on 12.05.2023
@author: farukkavlak
@date: 12.05.2023
@project: akbank-hw1
*/

import com.farukkavlak.akbankhw1.generic.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Country extends BaseEntity {
    @Id
    @SequenceGenerator(name="country_seq",sequenceName="country_seq", allocationSize = 1)
    @GeneratedValue(generator="country_seq",strategy= GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true, nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String presidentName;
}
