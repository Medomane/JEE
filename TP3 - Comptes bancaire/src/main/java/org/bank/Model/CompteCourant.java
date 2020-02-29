package org.bank.Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cc")
public class CompteCourant extends Compte {
        private double decouvert;

        public double getDecouvert() {
                return decouvert;
        }

        public void setDecouvert(double decouvert) {
                this.decouvert = decouvert;
        }
}
