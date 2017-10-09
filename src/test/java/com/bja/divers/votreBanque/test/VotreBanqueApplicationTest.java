package com.bja.divers.votreBanque.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bja.divers.votreBanque.dao.ClientRepository;
import com.bja.divers.votreBanque.entities.Client;

@SpringBootApplication
public class VotreBanqueApplicationTest implements CommandLineRunner{

    @Autowired
    private ClientRepository clientRepository;
    
    public static void main(String[] args) {
	SpringApplication.run(VotreBanqueApplicationTest.class, args);

    }

    @Override
    public void run(String... args) throws Exception {	
	Client client=	clientRepository.save(new Client("eric", "email@ffes.com"));
	System.out.println("client "+client);
    }
}
