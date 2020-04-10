package org.bank.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn( name="type_compte", discriminatorType= DiscriminatorType.STRING,length=2)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","operations"})
public abstract class Compte {
    @Id
    private String numCompte ;
    private double solde ;
    @CreationTimestamp
    private Date dateCreation ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_code",nullable = false)
    private Client client ;

    @OneToMany(mappedBy="compte")
    private List<Operation> operations;
}
