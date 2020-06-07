package org.backend.Model;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;
import java.util.List;

@Projection(name = "p1",types = {org.backend.Model.Projection.class})
public interface ProjectionProjection {
    public Long getId();
    public Date getDate();
    public Room getRoom();
    public Film getFilm();
    public Session getSession();
    public List<Ticket> getTickets();
}
