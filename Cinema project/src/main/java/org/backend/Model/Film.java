package org.backend.Model;

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
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String title;
    @Temporal(TemporalType.TIME)
    private Date duration ;
    private String director ;
    @Lob
    private String description;
    private String photo;
    private Date date;

    @OneToMany(mappedBy = "film",fetch = FetchType.LAZY)
    private List<Projection> projections;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId",nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Category category;
}
