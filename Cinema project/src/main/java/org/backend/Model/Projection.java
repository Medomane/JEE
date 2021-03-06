package org.backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","tickets"})
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Projection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "roomId",nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Room room;

    @ManyToOne
    @JoinColumn(name = "filmId",nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Film film;

    @ManyToOne
    @JoinColumn(name = "sessionId",nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Session session;

    @OneToMany(mappedBy = "projection")
    private List<Ticket> tickets ;
}
