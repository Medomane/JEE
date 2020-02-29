package org.bank.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn( name="TYPE_CPTE", discriminatorType= DiscriminatorType.STRING,length=2)
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private double solde ;
    private Date dateCreation ;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client ;
    @OneToMany(mappedBy="compte")
    private Collection<Operation> operations;
}
