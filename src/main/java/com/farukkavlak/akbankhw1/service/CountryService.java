package com.farukkavlak.akbankhw1.service;/*
Created by farukkavlak on 12.05.2023
@author: farukkavlak
@date: 12.05.2023
@project: akbank-hw1
*/

import com.farukkavlak.akbankhw1.dao.CountryDao;
import com.farukkavlak.akbankhw1.dto.CountryDto;
import com.farukkavlak.akbankhw1.dto.CountryPatchRequestDto;
import com.farukkavlak.akbankhw1.dto.CountryPostRequestDto;
import com.farukkavlak.akbankhw1.entity.Country;
import com.farukkavlak.akbankhw1.generic.service.BaseEntityService;
import com.farukkavlak.akbankhw1.mapper.CountryMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CountryService extends BaseEntityService<Country, CountryDao> {
    private CountryDao countryDao;
    public CountryService(CountryDao dao) {
        super(dao);
    }

    public CountryDto saveCountry(CountryPostRequestDto countryPostRequestDto) {
        Country country = CountryMapper.INSTANCE.postRequestDtoToEntity(countryPostRequestDto);
        this.save(country);
        return CountryMapper.INSTANCE.entityToDto(country);
    }

    public Collection<CountryDto> getAllCountries() {
        Collection<Country> countries = this.findAll();
        return CountryMapper.INSTANCE.entityListToDTOList(countries);
    }

    public CountryDto findCountryById(Long id) {
        Country country = this.findById(id);
        return CountryMapper.INSTANCE.entityToDto(country);
    }

    public void changePresident(CountryPatchRequestDto countryPatchRequestDto) {
        Country country = this.findById(countryPatchRequestDto.getId());
        country.setPresidentName(countryPatchRequestDto.getPresidentName());
        this.save(country);
    }

}
