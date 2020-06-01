package org.cinema.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String title;
    private double duration ;
    private String director ;
    private String description;
    private String photo;
    private String date;

    @OneToMany(mappedBy = "film",fetch = FetchType.LAZY)
    private List<Projection> projections;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId",nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Category category;
}
