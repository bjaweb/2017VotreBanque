package com.bja.divers.votreBanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bja.divers.votreBanque.entities.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, String>{

}
