package org.cinema.Controller;

import org.cinema.Repository.SessionRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {
    final SessionRepository sessionRepository;
    public SessionController(SessionRepository sessionRepository) { this.sessionRepository = sessionRepository; }
}
