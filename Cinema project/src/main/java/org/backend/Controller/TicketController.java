package org.backend.Controller;

import lombok.Data;
import org.backend.Model.Ticket;
import org.backend.Repository.TicketRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class TicketController {
    final TicketRepository ticketRepository;
    public TicketController(TicketRepository ticketRepository) { this.ticketRepository = ticketRepository; }

    @PostMapping("/buy")
    @Transactional
    public List<Ticket> BuyTicket(@RequestBody Info info){
        List<Ticket> list = ticketRepository.findAllById(info.getTickets());
        list.forEach(ticket -> {
            ticket.setReserved(true);
            ticket.setClientName(info.getClientName());
            ticketRepository.save(ticket);
        });
        return list ;
    }
}
@Data
class Info{
    private String clientName ;
    private List<Long> tickets = new ArrayList<>();
}