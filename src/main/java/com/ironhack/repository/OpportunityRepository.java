package com.ironhack.repository;

import com.ironhack.model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {

    @Query(value = "SELECT * FROM opportunity op JOIN contact co ON op.decision_maker_id = co.id JOIN account ac on " +
            "co.account_id = ac.id WHERE ac.company_name = :companyName", nativeQuery = true)
    List<Opportunity> findByCompanyName(@Param("companyName") String companyName);
}
