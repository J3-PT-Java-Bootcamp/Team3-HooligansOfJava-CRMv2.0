package com.ironhack.repository;

import com.ironhack.model.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalesRepRepository extends JpaRepository<SalesRep, Long> {

    SalesRep findSalesRepByName(String name);


    @Query(value = "SELECT s.name, COUNT(l.salesRep) FROM SalesRep s JOIN Lead l ON s.id = l.salesRep GROUP BY s.name")
    List<Object[]> groupByName();

}
