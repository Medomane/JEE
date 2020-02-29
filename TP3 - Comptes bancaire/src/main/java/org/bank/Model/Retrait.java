package org.bank.Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("r")

public class Retrait extends Operation{

}
