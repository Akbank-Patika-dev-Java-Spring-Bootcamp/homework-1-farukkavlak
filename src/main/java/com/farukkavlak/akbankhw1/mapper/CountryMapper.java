package com.farukkavlak.akbankhw1.mapper;/*
Created by farukkavlak on 12.05.2023
@author: farukkavlak
@date: 12.05.2023
@project: akbank-hw1
*/

import com.farukkavlak.akbankhw1.dto.CountryDto;
import com.farukkavlak.akbankhw1.dto.CountryPostRequestDto;
import com.farukkavlak.akbankhw1.entity.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Collection;

@Mapper()
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    //Entity to Dto
    @Mapping(target = "id")
    CountryDto entityToDto(Country country);
    //Post Request Dto to Entity
    Country postRequestDtoToEntity(CountryPostRequestDto countryPostRequestDto);
    @Mapping(target = "id")
    Collection<CountryDto> entityListToDTOList(Collection<Country> countries);
}
