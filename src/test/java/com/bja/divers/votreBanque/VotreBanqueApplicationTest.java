package com.bja.divers.votreBanque;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bja.divers.votreBanque.dao.ClientRepository;
import com.bja.divers.votreBanque.entities.Client;
import com.bja.divers.votreBanque.entities.Compte;
import com.bja.divers.votreBanque.services.IBanqueService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VotreBanqueApplicationTest implements CommandLineRunner{

	@Autowired
	private ClientRepository clientRepository;

	private static Logger logger = LoggerFactory.getLogger(VotreBanqueApplicationTest.class);
	
	
	@Autowired
	IBanqueService banqueService;


	@Test	 
	public void contextLoads(){

		System.out.println(" bja test "+clientRepository);
		Compte cpt1 = banqueService.consulterCompte("cpt1");
		logger.debug(" c1 "+cpt1);
	}

	@Override
	public void run(String... arg0) throws Exception {
		logger.debug(" bja test "+clientRepository);

	}

	//    @Autowired
	//    private ClientRepository clientRepository;
	//    
	//    public static void main(String[] args) {
	//	SpringApplication.run(VotreBanqueApplicationTest.class, args);
	//
	//    }
	//
	//    @Override
	//    public void run(String... args) throws Exception {	
	//	Client client=	clientRepository.save(new Client("eric", "email@ffes.com"));
	//	System.out.println("client "+client);
	//    }


}
