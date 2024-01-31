package com.example.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.data.jpa.domain.City;
import com.example.data.jpa.service.CitySearchCriteria;
import com.example.data.jpa.service.CityService;

//generate city controller rest api
// Path: src/main/java/com/example/data/jpa/web/CityController.java
@RestController
public class CityController{    

    @Autowired
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService){
        this.cityService = cityService;
    }
    //get cities    
    @RequestMapping(value="/cities", method=RequestMethod.GET)
    public Page<City> getCities(CitySearchCriteria criteria, Pageable pageable){
        return cityService.findCities(criteria, pageable);
    }
    //get city
    @RequestMapping(value="/city", method=RequestMethod.GET)
    public City getCity(@RequestParam("name") String name,@RequestParam("country") String country){
        return cityService.getCity(name, country);
    }

}
