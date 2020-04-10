package org.bank.Model;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",length=2)

public abstract class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero ;
    @CreationTimestamp
    private Date dateOperation ;
    private double montant ;
    @ManyToOne
    @JoinColumn(name = "compte_code")
    private Compte compte ;
}
