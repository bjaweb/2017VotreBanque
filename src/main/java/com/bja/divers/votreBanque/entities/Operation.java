package com.bja.divers.votreBanque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_OP", discriminatorType=DiscriminatorType.STRING, length=1)
public abstract class Operation {

    @Id @GeneratedValue
    private Long numOperation;
    private Date dateOperation;
    private double montant;
    
    @ManyToOne
    @JoinColumn(name="NUM_COMPTE")
    private Compte compte;
            
    public Operation() {
	super();
	// TODO Auto-generated constructor stub
    }

    public Operation(Date dateOperation, double montant, Compte compte) {
	super();
	this.dateOperation = dateOperation;
	this.montant = montant;
	this.compte = compte;
    }

    public Long getNumOperation() {
        return numOperation;
    }
    
    public void setNumOperation(Long numOperation) {
        this.numOperation = numOperation;
    }
    
    public Date getDateOperation() {
        return dateOperation;
    }
    
    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }
    
    public double getMontant() {
        return montant;
    }
    
    public void setMontant(double montant) {
        this.montant = montant;
    }
    
    public Compte getCompte() {
        return compte;
    }
    
    public void setCompte(Compte compte) {
        this.compte = compte;
    }
    
    
    
    
}
