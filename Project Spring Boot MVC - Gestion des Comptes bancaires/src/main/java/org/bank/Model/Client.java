package org.bank.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","comptes"})
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code ;
    private String nom ;
    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    private List<Compte> comptes ;
}
