package org.bank.Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ce")
public class CompteEpargne extends Compte {
        private double taux;
}
