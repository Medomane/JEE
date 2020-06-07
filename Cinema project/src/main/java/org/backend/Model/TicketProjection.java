package org.backend.Model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "ticketProjection",types = {Ticket.class})
public interface TicketProjection {
    public Long getId() ;
    public String getClientName();
    public double getPrice();
    public int getPaymentCode ();
    public boolean getReserved();
    public Place getPlace();
}
