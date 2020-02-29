package org.bank.Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cc")
public class CompteCourant extends Compte {
        private double decouvert;
}
