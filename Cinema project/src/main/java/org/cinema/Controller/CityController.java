package org.cinema.Controller;

import org.cinema.Repository.CityRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
    final CityRepository cityRepository;
    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
}