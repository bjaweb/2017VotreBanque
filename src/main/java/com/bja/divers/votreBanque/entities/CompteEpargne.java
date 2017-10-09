package com.bja.divers.votreBanque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="CE")
public class CompteEpargne extends Compte {

    
    private double taux;

    
    
    
    public CompteEpargne() {
	super();	
    }


    public CompteEpargne(String num, Date dateCreation, double solde, Client client, double taux) {
	super(num, dateCreation, solde, client);
	this.taux = taux;
    }


    public double getTaux() {
        return taux;
    }

    
    public void setTaux(double taux) {
        this.taux = taux;
    }
    
    
    
    
    
}
