package org.backend.Controller;

import org.backend.Repository.PlaceRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaceController {
    final PlaceRepository placeRepository;
    public PlaceController(PlaceRepository placeRepository) { this.placeRepository = placeRepository; }
}
