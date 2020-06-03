package org.backend.Model;

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
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinemaId",nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Cinema cinema;

    @OneToMany(mappedBy = "room",fetch = FetchType.LAZY)
    private List<Place> places;
    @OneToMany(mappedBy = "room",fetch = FetchType.LAZY)
    private List<Projection> projections;
}
