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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","rooms"})
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    private double longitude, latitude,altitude;

    @OneToMany(mappedBy = "cinema",fetch = FetchType.LAZY)
    private List<Room> rooms ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cityId",nullable = false)
    private City city;
}
