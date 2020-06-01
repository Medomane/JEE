package org.cinema.Controller;

import org.cinema.Repository.FilmRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmController {
    final FilmRepository filmRepository;
    public FilmController(FilmRepository filmRepository) { this.filmRepository = filmRepository; }
}
