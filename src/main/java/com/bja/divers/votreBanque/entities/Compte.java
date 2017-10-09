package com.bja.divers.votreBanque.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_CPTE",discriminatorType=DiscriminatorType.STRING, length=2)
public abstract class Compte implements Serializable {

    @Id
    private String num;
    private Date dateCreation ;
    private double solde;
    
    @OneToMany(mappedBy="compte")
    private Collection<Operation> operations;
    
    @ManyToOne  // si on met rien la cle entrangere s'appellera client
    @JoinColumn(name="CODE_CLI")
    private Client client;
    
    
    public Compte() {
	super();
	// TODO Auto-generated constructor stub
    }


    public Compte(String num, Date dateCreation, double solde, Client client) {
	super();
	this.num = num;
	this.dateCreation = dateCreation;
	this.solde = solde;
	this.client = client;
    }









    public String getNum() {
        return num;
    }

    
    public void setNum(String num) {
        this.num = num;
    }

    
    public Date getDateCreation() {
        return dateCreation;
    }

    
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    
    public double getSolde() {
        return solde;
    }

    
    public void setSolde(double solde) {
        this.solde = solde;
    }

    
    public Client getClient() {
        return client;
    }

    
    public void setClient(Client client) {
        this.client = client;
    }
    
    
    
}
