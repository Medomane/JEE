package org.cinema.Controller;

import org.cinema.Repository.PlaceRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaceController {
    final PlaceRepository placeRepository;
    public PlaceController(PlaceRepository placeRepository) { this.placeRepository = placeRepository; }
}
