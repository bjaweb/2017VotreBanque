package com.bja.divers.votreBanque.services;

import org.springframework.data.domain.Page;

import com.bja.divers.votreBanque.entities.Compte;
import com.bja.divers.votreBanque.entities.Operation;

public interface IBanqueService {


    public Compte consulterCompte(String num);
    public void verser(String num, double montant);
    public void retirer(String num, double montant);
    public void virement(String numSrc, String numDest, double montant);
    public Page<Operation> listOp(String numCompte, int page, int size);


    
    
}
