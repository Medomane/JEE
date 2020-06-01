package org.cinema.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","tickets"})
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private int number ;
    private double longitude, latitude,altitude;

    @OneToMany(mappedBy = "place",fetch = FetchType.LAZY)
    private List<Ticket> tickets ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roomId",nullable = false)
    private Room room;
}
