package org.backend.Controller;

import org.backend.Repository.CinemaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaController {
    final CinemaRepository cinemaRepository;
    public CinemaController(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }
}
