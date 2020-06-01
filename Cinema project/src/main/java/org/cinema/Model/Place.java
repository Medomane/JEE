package org.cinema.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Room room;
}
