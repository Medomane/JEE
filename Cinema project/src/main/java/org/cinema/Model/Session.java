package org.cinema.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","projections"})
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @OneToMany(mappedBy = "session",fetch = FetchType.LAZY)
    private List<Projection> projections;
}
