package com.ironhack.repository;

import com.ironhack.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "SELECT a.city, COUNT(a.city) FROM Account a  GROUP BY a.city")
    List<Object[]> OpportunityByCity();

    @Query(value = "SELECT a.city, COUNT(a.city) FROM Account a JOIN Opportunity o ON o.decisionMaker = a.id WHERE o.status ='CLOSED_LOST' GROUP BY a.city")
    List<Object[]>  OpportunityByCityStatusClosed();

    @Query(value = "SELECT a.city, COUNT(a.city) FROM Account a JOIN Opportunity o ON o.decisionMaker = a.id WHERE o.status ='CLOSED_WON' GROUP BY a.city")
    List<Object[]>  OpportunityByCityStatusWon();

    @Query(value = "SELECT a.city, COUNT(a.city) FROM Account a JOIN Opportunity o ON o.decisionMaker = a.id WHERE o.status ='OPEN' GROUP BY a.city")
    List<Object[]>  OpportunityByCityStatusOpen();

    @Query(value = "SELECT a.country, COUNT(a.country) FROM Account a JOIN Opportunity o ON o.decisionMaker = a.id WHERE o.status ='OPEN' GROUP BY a.country")
    List<Object[]>  OpportunityByCountryStatusOpen();

    @Query(value = "SELECT a.country, COUNT(a.country) FROM Account a JOIN Opportunity o ON o.decisionMaker = a.id WHERE o.status ='CLOSED_LOST' GROUP BY a.country")
    List<Object[]>  OpportunityByCountryStatusLost();

    @Query(value = "SELECT a.country, COUNT(a.country) FROM Account a JOIN Opportunity o ON o.decisionMaker = a.id WHERE o.status ='CLOSED_WON' GROUP BY a.country")
    List<Object[]>  OpportunityByCountryStatusWon();

    @Query(value = "SELECT a.country, COUNT(a.country) FROM Account a  GROUP BY a.country")
    List<Object[]>  OpportunityByCountry();
}
