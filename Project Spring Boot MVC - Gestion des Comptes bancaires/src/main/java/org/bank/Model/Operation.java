package org.bank.Model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",length=2)

public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private Date dateOperation ;
    private double montant ;
    //@JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compte compte ;
}
