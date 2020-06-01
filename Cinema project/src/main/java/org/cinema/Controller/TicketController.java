package org.cinema.Controller;

import org.cinema.Repository.TicketRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
    final TicketRepository ticketRepository;
    public TicketController(TicketRepository ticketRepository) { this.ticketRepository = ticketRepository; }
}
