package com.farukkavlak.akbankhw1.dao;/*
Created by farukkavlak on 12.05.2023
@author: farukkavlak
@date: 12.05.2023
@project: akbank-hw1
*/

import com.farukkavlak.akbankhw1.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryDao extends JpaRepository<Country, Long> {
}
