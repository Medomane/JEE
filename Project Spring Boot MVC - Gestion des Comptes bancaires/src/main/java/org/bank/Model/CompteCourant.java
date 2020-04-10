package org.bank.Model;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {
        private double decouvert;
}
