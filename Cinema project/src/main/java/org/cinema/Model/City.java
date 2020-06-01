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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cinemas"})
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    private double longitude, latitude,altitude;
    @OneToMany(mappedBy = "city",fetch = FetchType.LAZY)
    private List<Cinema> cinemas ;
}
