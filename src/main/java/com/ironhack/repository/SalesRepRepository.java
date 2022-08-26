package com.ironhack.repository;

import com.ironhack.model.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalesRepRepository extends JpaRepository<SalesRep, Long> {

    SalesRep findSalesRepByName(String name);


    @Query(value = "SELECT s.name, COUNT(l.salesRep) FROM SalesRep s JOIN Lead l ON s.id = l.salesRep GROUP BY s.name")
    List<Object[]> groupLeadsByName();

    @Query(value = "SELECT s.name, COUNT(l.salesRep) FROM SalesRep s JOIN Opportunity l ON s.id = l.salesRep GROUP BY s.name")
    List<Object[]> groupOpportunityByName();

    @Query(value = "SELECT s.name, COUNT(l.salesRep) FROM SalesRep s JOIN Opportunity l ON s.id = l.salesRep WHERE l.status ='CLOSED_LOST' GROUP BY s.name")
    List<Object[]>  groupOpportunityByNameLost();
    @Query(value = "SELECT s.name, COUNT(l.salesRep) FROM SalesRep s JOIN Opportunity l ON s.id = l.salesRep WHERE l.status ='OPEN' GROUP BY s.name")
    List<Object[]>  groupOpportunityByNameOpen();
    @Query(value = "SELECT s.name, COUNT(l.salesRep) FROM SalesRep s JOIN Opportunity l ON s.id = l.salesRep WHERE l.status ='CLOSED_WON' GROUP BY s.name")
    List<Object[]>  groupOpportunityByNameWon();
}
