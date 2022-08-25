package com.ironhack.repository;

import com.ironhack.model.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepRepository extends JpaRepository<SalesRep, Long> {

    SalesRep findSalesRepByName(String name);

}
