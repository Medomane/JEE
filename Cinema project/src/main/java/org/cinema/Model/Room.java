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
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","places"},{"hibernateLazyInitializer","handler","projections"})
@JsonIgnoreProperties(ignoreUnknown=true, value={"hibernateLazyInitializer", "handler"})
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
    private Cinema cinema;

    @OneToMany(mappedBy = "room",fetch = FetchType.LAZY)
    private List<Place> places;
    @OneToMany(mappedBy = "room",fetch = FetchType.LAZY)
    private List<Projection> projections;
}
