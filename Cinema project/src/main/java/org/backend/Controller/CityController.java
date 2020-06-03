package org.backend.Controller;

import org.backend.Repository.CityRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
    final CityRepository cityRepository;
    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
}