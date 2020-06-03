package org.backend.Controller;

import org.backend.Repository.SessionRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {
    final SessionRepository sessionRepository;
    public SessionController(SessionRepository sessionRepository) { this.sessionRepository = sessionRepository; }
}
