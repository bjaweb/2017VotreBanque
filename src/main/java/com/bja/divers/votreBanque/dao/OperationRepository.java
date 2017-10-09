package com.bja.divers.votreBanque.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bja.divers.votreBanque.entities.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long>{

    @Query("from Operation o where o.compte.num = :x order by dateOperation desc")
    public Page<Operation> listOperation (@Param("x")String numCompte, Pageable pageable);
    
}
