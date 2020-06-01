package org.cinema.Controller;

import org.cinema.Repository.ProjectionRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectionController {
    final ProjectionRepository projectionRepository;
    public ProjectionController(ProjectionRepository projectionRepository) { this.projectionRepository = projectionRepository; }
}
