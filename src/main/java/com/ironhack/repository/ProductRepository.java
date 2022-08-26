package com.ironhack.repository;

import com.ironhack.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT p.product, COUNT(p.product) FROM Product p GROUP BY p.product")
    List<Object[]> groupOpportunityByName();

    @Query(value = "SELECT p.product, COUNT(p.product) FROM Product p JOIN Opportunity o ON o.salesRep = p.opportunity WHERE o.status ='CLOSED_LOST' GROUP BY p.product")
    List<Object[]>  groupOpportunityByNameLost();
    @Query(value = "SELECT p.product, COUNT(p.product) FROM Product p JOIN Opportunity o ON o.salesRep = p.opportunity WHERE o.status ='OPEN' GROUP BY p.product")
    List<Object[]>  groupOpportunityByNameOpen();
    @Query(value = "SELECT p.product, COUNT(p.product) FROM Product p JOIN Opportunity o ON o.salesRep = p.opportunity WHERE o.status ='CLOSED_WON' GROUP BY p.product")
    List<Object[]>  groupOpportunityByNameWon();
}

