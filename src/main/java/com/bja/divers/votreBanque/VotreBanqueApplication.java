package com.bja.divers.votreBanque;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bja.divers.votreBanque.dao.ClientRepository;
import com.bja.divers.votreBanque.dao.CompteRepository;
import com.bja.divers.votreBanque.dao.OperationRepository;
import com.bja.divers.votreBanque.entities.Client;
import com.bja.divers.votreBanque.entities.Compte;
import com.bja.divers.votreBanque.entities.CompteCourant;
import com.bja.divers.votreBanque.entities.CompteEpargne;
import com.bja.divers.votreBanque.services.IBanqueService;

@SpringBootApplication
public class VotreBanqueApplication implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;
    
    @Autowired
    private CompteRepository compteRepository;
    
    @Autowired
    private OperationRepository operationRepository;
    
    @Autowired
    IBanqueService banqueService;
    
    public static void main(String[] args) {
	SpringApplication.run(VotreBanqueApplication.class, args);

    }

    
    public void init() {
	
	Client client=	clientRepository.save(new Client("eric", "email@ffes.com"));
	Client client2=	clientRepository.save(new Client("paul", "email@ffes.com"));
	
	Compte compte = compteRepository.save(new CompteCourant("cpt1", new Date(), 677, client, 100));
	Compte compte2 = compteRepository.save(new CompteCourant("cpt2", new Date(), 1000, client2, 100));
	Compte compte3 = compteRepository.save(new CompteEpargne("ep1", new Date(), 6770, client, 10));
	
	banqueService.verser("cpt1", 100.00);
	banqueService.verser("cpt1", 100.00);
	banqueService.verser("cpt1", 100.00);
	banqueService.verser("cpt1", 100.00);
	banqueService.verser("cpt1", 1000.00);
	banqueService.verser("cpt2", 100.00);
	banqueService.verser("cpt2", 100.00);
	banqueService.retirer("cpt2", 10.00);
	banqueService.virement("cpt1", "ep1", 2);
	
	System.out.println("client "+client);
	System.out.println("compte "+compte);

	
    }
    
    @Override
    public void run(String... args) throws Exception {
		
	
//	init();
	
    }

}
