package com.farukkavlak.akbankhw1.controller;/*
Created by farukkavlak on 12.05.2023
@author: farukkavlak
@date: 12.05.2023
@project: akbank-hw1
*/

import com.farukkavlak.akbankhw1.dto.CountryDto;
import com.farukkavlak.akbankhw1.dto.CountryPatchRequestDto;
import com.farukkavlak.akbankhw1.dto.CountryPostRequestDto;
import com.farukkavlak.akbankhw1.generic.response.RestResponse;
import com.farukkavlak.akbankhw1.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/countries")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;

    //Get all countries
    @GetMapping()
    public ResponseEntity findAll() {
        Collection<CountryDto> countries = countryService.getAllCountries();
        return ResponseEntity.ok(RestResponse.of(countries));
    }

    //Get country by id
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        CountryDto countryDto = countryService.findCountryById(id);
        return ResponseEntity.ok(RestResponse.of(countryDto));
    }

    //Create country
    @PostMapping()
    public ResponseEntity save(@RequestBody CountryPostRequestDto countryPostRequestDto) {
        CountryDto countryDto = countryService.saveCountry(countryPostRequestDto);
        return ResponseEntity.ok(RestResponse.of(countryDto));
    }

    //Update president name
    @PatchMapping()
    public ResponseEntity patchPresident(@RequestBody CountryPatchRequestDto countryPatchRequestDto) {
        countryService.changePresident(countryPatchRequestDto);
        return ResponseEntity.ok(RestResponse.empty());
    }

}
