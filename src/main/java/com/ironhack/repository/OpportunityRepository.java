package com.ironhack.repository;

import com.ironhack.model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {

    @Query(value = "SELECT * FROM Opportunity JOIN Account ON account = opportunity WHERE companyName = :companyName", nativeQuery = true)
    Opportunity findOpportunityByCompanyName(@Param("companyName") String companyName);
}
