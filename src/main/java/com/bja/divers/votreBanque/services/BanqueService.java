package com.bja.divers.votreBanque.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bja.divers.votreBanque.dao.ClientRepository;
import com.bja.divers.votreBanque.dao.CompteRepository;
import com.bja.divers.votreBanque.dao.OperationRepository;
import com.bja.divers.votreBanque.entities.Compte;
import com.bja.divers.votreBanque.entities.CompteCourant;
import com.bja.divers.votreBanque.entities.Operation;
import com.bja.divers.votreBanque.entities.Retrait;
import com.bja.divers.votreBanque.entities.Versement;

@Service
@Transactional
public class BanqueService implements IBanqueService{

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private ClientRepository clientRepository;
    
    @Autowired
    private OperationRepository operationRepository;   
    
    
    @Override
    public Compte consulterCompte(String num) {
	Compte c =  compteRepository.findOne(num);
	if(c==null) throw new RuntimeException("compte introuvable");
	return c;
    }

    @Override
    public void verser(String num, double montant) {
	Compte cp = consulterCompte(num);
	Versement versement = new Versement(new Date(), montant, cp);
	operationRepository.save(versement);	
	cp.setSolde(cp.getSolde()+montant);
	compteRepository.save(cp);
	
    }

    @Override
    public void retirer(String num, double montant) {
	Compte cp = consulterCompte(num);
	
	double decouvert = 0;
	if (cp instanceof CompteCourant) {
	    decouvert = ((CompteCourant) cp).getDecouvert();	    
	}
	
	// compte trop faible
	if(decouvert+cp.getSolde() < montant) {
	    throw new RuntimeException("solde insuffisant");
	}
	
	Retrait retrait = new Retrait(new Date(), montant, cp);
	operationRepository.save(retrait);	
	cp.setSolde(cp.getSolde()-montant);
	compteRepository.save(cp);
	
    }

    @Override
    public void virement(String numSrc, String numDest, double montant) {
	if(numSrc == null || numDest == null 
	   || numSrc.isEmpty() || numDest.isEmpty()
	   || (numSrc.equals(numDest))
	  )
	{
	 throw new RuntimeException("operation impossible : num de comptes incoherents");
	}
	retirer(numSrc, montant);
	verser(numDest, montant);
	
    }

    @Override
    public Page<Operation> listOp(String numCompte, int page, int size) {
	return operationRepository.listOperation(numCompte, new PageRequest(page, size));	
    }

    
    
    
    
}
