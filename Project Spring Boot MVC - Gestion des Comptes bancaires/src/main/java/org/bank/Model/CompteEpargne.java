package org.bank.Model;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {
        private double taux;
}
