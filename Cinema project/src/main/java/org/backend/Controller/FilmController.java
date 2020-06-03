package org.backend.Controller;

import org.backend.Repository.FilmRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class FilmController {
    final FilmRepository filmRepository;
    public FilmController(FilmRepository filmRepository) { this.filmRepository = filmRepository; }

    @GetMapping(value = "/image/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] image(@PathVariable Long id) throws Exception {
        return Files.readAllBytes(Paths.get(new File(System.getProperty("user.home")+"/cinema/images/"+filmRepository.getOne(id).getPhoto()).toURI()));
    }
}
